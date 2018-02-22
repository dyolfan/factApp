package com.colors.student.factsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.widget.ScrollView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.colors.student.factsapp.databases.Fact;
import com.colors.student.factsapp.databases.FactList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.colors.student.factsapp.MainActivity.sQLiteHelper;
import static android.content.ContentValues.TAG;


/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;
    DatabaseError databaseError;
    DatabaseReference mDatabase;
    FactList list = new FactList();
    private Fact currentFact;
    DatabaseReference currentFactToChange;
    TextView category;
    Boolean open;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        open = false;

        Context context = this.getApplicationContext();
        setContentView(R.layout.fact_view);
        Intents intents = new Intents(this);
        Intent intent = getIntent();//gets intent from MainActivity with the category
        //intitilize elements from view
        TextView category = findViewById(R.id.category);
        Button getFact = findViewById(R.id.getFact);
        ImageButton share = findViewById(R.id.shareBtn);
        ImageButton toMenu = findViewById(R.id.backBtn);
        TextView factBox = findViewById(R.id.factBox);
        ScrollView thisFact = findViewById(R.id.wholeFact);

        Button voteUp = findViewById(R.id.voteUpBtn);
        Button voteDown = findViewById(R.id.voteDownBtn);

        String message = intent.getExtras().getString("category");
        category.setText(message);

        //Favourite/SQLite related variables
        ImageButton favourite = findViewById(R.id.favouriteFact);

        mDatabase = FirebaseDatabase.getInstance("https://factsapp-19a2f.firebaseio.com/").getReference().child(message);
        list = new FactList();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()) {

                    String key = uniqueKeySnapshot.getKey();
                    String text = uniqueKeySnapshot.child("text").getValue().toString();
                    int rating = Integer.parseInt(uniqueKeySnapshot.child("rating").getValue().toString());
                    Fact newFact = new Fact(text, rating, key);
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
                if(!open){
                    open = true;

                    currentFact = list.getFact(message);
                    currentFactToChange = mDatabase.child(currentFact.getKey()).child("rating");
                    factBox.setText(currentFact.getText());
                }
            }


            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }


    });



        getFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //I need a way to save the current fact to a variable
                currentFact = list.getFact(message);
                currentFactToChange = mDatabase.child(currentFact.getKey()).child("rating");
                factBox.setText(currentFact.getText());
//                        Log.i("list: ", Integer.toString(list.sports.size()));
            }
        });

    toMenu.setOnClickListener(view -> {
        open = false;
        startActivity(intents.mainMenu);
    });



    favourite.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //sQLiteHelper.remakeTable();
            String factString = factBox.getText().toString();
            FavouritesModel contact = new FavouritesModel(factString);
            sQLiteHelper.insertRecord(contact);
            //FavouritesModel delpls = new FavouritesModel(factToBeFavourited.getText().toString());
            //sQLiteHelper.deleteRecord(delpls);
        }
    });

    voteUp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view){
            System.out.println(currentFact.getKey());
            System.out.println(currentFact.getText());
            currentFactToChange.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String rating = dataSnapshot.getValue().toString();
                    int ratingInt = Integer.parseInt(rating);
                    try{
                        mDatabase.child(currentFact.getKey()).child("rating").setValue(ratingInt+1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w(TAG, "onCancelled", databaseError.toException());
                }
            });
        }
    });

    voteDown.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){
            System.out.println(currentFact.getKey());
            System.out.println(currentFact.getText());
            System.out.println(mDatabase.child(currentFact.getKey()).child("rating"));
            currentFactToChange.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String rating = dataSnapshot.getValue().toString();
                    int ratingInt = Integer.parseInt(rating);
                    System.out.println(dataSnapshot);
                    try {
                        mDatabase.child(currentFact.getKey()).child("rating").setValue(ratingInt - 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w(TAG, "onCancelled", databaseError.toException());
                }
            });
        }
    });



        share.setOnClickListener(view -> {
            thisFact.setDrawingCacheEnabled(true);
            Bitmap bitmap = thisFact.getDrawingCache();
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

}
