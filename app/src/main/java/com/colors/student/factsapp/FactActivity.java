package com.colors.student.factsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.colors.student.factsapp.MainActivity.sQLiteHelper;


/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;





    TextView category;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fact_view);
        category = findViewById(R.id.category);

        Intent intent = getIntent();
        String message = intent.getExtras().getString("category");
        category.setText(message);
        ImageButton share = findViewById(R.id.shareBtn);

        //Favourite/SQLite related variables
        ImageButton favourite = findViewById(R.id.favouriteFact);
        TextView factToBeFavourited = findViewById(R.id.factBox);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareText = "Your Body here";
                String shareSub = "Subtitle";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));

            }
        });

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //sQLiteHelper.remakeTable();
                String factString = factToBeFavourited.getText().toString();
               FavouritesModel contact = new FavouritesModel(factString);
               sQLiteHelper.insertRecord(contact);
                //FavouritesModel delpls = new FavouritesModel(factToBeFavourited.getText().toString());
                //sQLiteHelper.deleteRecord(delpls);
            }
        });

    }
}
