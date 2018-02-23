package com.colors.student.factsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

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

import static android.content.ContentValues.TAG;
import static com.colors.student.factsapp.MainActivity.sQLiteHelper;


/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private String android_id;
    FactList list = new FactList();
    private Fact currentFact;
    DatabaseReference currentFactToChange;
    TextView category;
    Boolean open;
    DatabaseReference mDatabase;
    boolean[] alreadyVoted = {false};
    Context context;
    public static String toastTestMsg = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        open = false;
        android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        context = this.getApplicationContext();
        setContentView(R.layout.fact_view);
        Intents intents = new Intents(this);
        Intent intent = getIntent();
        TextView category = findViewById(R.id.category);
        Button getFact = findViewById(R.id.getFact);
        ImageButton share = findViewById(R.id.shareBtn);
        ImageButton toMenu = findViewById(R.id.backBtn);
        TextView factBox = findViewById(R.id.factBox);

        Button voteUp = findViewById(R.id.voteUpBtn);
        Button voteDown = findViewById(R.id.voteDownBtn);

        String message = intent.getExtras().getString("category");
        category.setText(message);
        ImageButton favourite = findViewById(R.id.favouriteFact);

        mDatabase = FirebaseDatabase.getInstance("https://factsapp-19a2f.firebaseio.com/").getReference().child(message);
        list = new FactList();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()) {
                    String key = uniqueKeySnapshot.getKey();
                    String text = uniqueKeySnapshot.child("text").getValue().toString();
                    Fact newFact = new Fact(text, key);
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

                getFact.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        currentFact = list.getFact(message);
                        currentFactToChange = mDatabase.child(currentFact.getKey()).child("rating");
                        factBox.setText(currentFact.getText());
                        alreadyVoted[0] = false;
                    }
                });

                favourite.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String factString = currentFact.getText();
                        FavouritesModel contact = new FavouritesModel(factString);
                        if(sQLiteHelper.insertRecord(contact)){
                            Toast toast = Toast.makeText(context, "Fact added to favorites", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            Toast toast = Toast.makeText(context, "Fact already added", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                });

                share.setOnClickListener(view -> {
                    factBox.setDrawingCacheEnabled(true);
                    Bitmap bitmap = factBox.getDrawingCache();

                    try {
                        File cachePath = new File(context.getCacheDir(), "images");
                        cachePath.mkdirs(); // don't forget to make the directory
                        FileOutputStream stream = new FileOutputStream(cachePath + "/image.png");
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
                        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                        shareIntent.setDataAndType(contentUri, getContentResolver().getType(contentUri));
                        shareIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
                        startActivity(Intent.createChooser(shareIntent, "Choose an app"));
                    }
                });

                voteUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        applyVotes(true);
                    }
                });

                voteDown.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        applyVotes(false);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        toMenu.setOnClickListener(view -> {
            open = false;
            startActivity(intents.mainMenu);
        });
    }

    private void applyVotes(boolean up) {
        System.out.println(currentFact.getKey());
        System.out.println(currentFact.getText());
        currentFactToChange.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String rating = dataSnapshot.getValue().toString();
                int ratingInt = Integer.parseInt(rating);
                mDatabase.child(currentFact.getKey()).child("ips").getRef().addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            Log.i("ID value", x.getValue().toString());
                            boolean test = x.getValue().toString().equals(android_id);
                            Log.i("Already voted", String.format("%b", test));
                            if (x.getValue().toString().equals(android_id)) ;
                            alreadyVoted[0] = true;
                        }
                        if (!alreadyVoted[0]) {
                            toastTestMsg = "Applied vote";
                            try {
                                if (up)
                                    mDatabase.child(currentFact.getKey()).child("rating").setValue(ratingInt + 1);
                                else
                                    mDatabase.child(currentFact.getKey()).child("rating").setValue(ratingInt - 1);
                                Log.i("Result", "applied");
                                mDatabase.child(currentFact.getKey()).child("ips").push().setValue(android_id);
                                alreadyVoted[0] = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            toastTestMsg = "You have already voted";
                            Toast toast = Toast.makeText(context, "You have already voted", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException());
            }
        });
    }

}
