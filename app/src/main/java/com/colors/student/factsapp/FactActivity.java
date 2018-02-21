package com.colors.student.factsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.content.FileProvider;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;

import com.colors.student.factsapp.databases.Fact;
import com.colors.student.factsapp.databases.FactList;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.widget.ShareDialog;
import com.colors.student.factsapp.databases.FactController;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    DatabaseReference mDatabase;
    FactList list = new FactList();

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (shouldAskPermissions()) {
            askPermissions();
        }

        Context context = this.getApplicationContext();
        setContentView(R.layout.fact_view);
        Intents intents = new Intents(this);
        Intent intent = getIntent();//gets intent from MainActivity
        //intitilize elements from view
        TextView category = findViewById(R.id.category);
        Button getFact = findViewById(R.id.getFact);
        ImageButton share = findViewById(R.id.shareBtn);
        ImageButton toMenu = findViewById(R.id.backBtn);
        TextView factBox = this.findViewById(R.id.factBox);
        LinearLayout thisView = findViewById(R.id.thisFact);//this view i want to make a image of

        String message = intent.getExtras().getString("category");
        category.setText(message);

        mDatabase = FirebaseDatabase.getInstance("https://factsapp-19a2f.firebaseio.com/").getReference().child(message);
        list = new FactList();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()){
                    String text = uniqueKeySnapshot.child("text").getValue().toString();
                    int rating = Integer.parseInt(uniqueKeySnapshot.child("rating").getValue().toString());
                    Fact newFact = new Fact(text, rating);
                    Log.i("tag: ", newFact.toString());
                    switch (message) {
                        case "Sports":
                            list.sports.add(newFact);
                            break;
                        case "Animals":
                            list.animals.add(newFact);
                            break;
                        case "Politics":
                            list.politics.add(newFact);
                            break;
                        case "History":
                            list.history.add(newFact);
                            break;
                        case "IT":
                            list.it.add(newFact);
                            break;
                    }
                }
                factBox.setText(list.getFact(message).getText());
                getFact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        factBox.setText(list.getFact(message).getText());
                        Log.i("list: ", Integer.toString(list.sports.size()));
                    }
                });

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


        toMenu.setOnClickListener(view -> {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareText = "Your Body here";
                String shareSub = "Subtitle";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));
                startActivity(intents.mainMenu);
        });


        share.setOnClickListener(view -> {
                thisView.setDrawingCacheEnabled(true);
                Bitmap bitmap = thisView.getDrawingCache();
                try {
                    File cachePath = new File(context.getCacheDir(), "images");
                    cachePath.mkdirs(); // don't forget to make the directory
                    FileOutputStream stream = new FileOutputStream(cachePath + "/image.png"); // overwrites this image every time
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File imagePath = new File(context.getCacheDir(), "images");
                File newFile = new File(imagePath, "image.png");
                Uri contentUri = FileProvider.getUriForFile(context, "com.colors.student.factsapp.fileprovider", newFile);

                if (contentUri != null) {
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // temp permission for receiving app to read this file
                    shareIntent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
                    shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                    startActivity(Intent.createChooser(shareIntent, "Choose an app"));
                }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void askPermissions() {
        String[] permissions = {
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        };
        int requestCode = 200;
        requestPermissions(permissions, requestCode);
    }
    protected boolean shouldAskPermissions() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }



}
