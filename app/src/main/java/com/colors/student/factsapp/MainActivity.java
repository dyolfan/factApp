package com.colors.student.factsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;

/**
 * Created by kirils on 13.02.18.
 */

public class MainActivity extends AppCompatActivity {
    public static SQLiteHelper sQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_menu);
        sQLiteHelper = new SQLiteHelper(this);

        Intents intents = new Intents(this);
        Button topFactsBtn = this.findViewById(R.id.topfactsBtn);
        Button favFactsBtn = this.findViewById(R.id.myFavBtn);
        Button addNewFact = this.findViewById(R.id.addFactBtn);
        Button sports = this.findViewById(R.id.sportsBtn);
        Button animals = this.findViewById(R.id.animalsBtn);
        Button history = this.findViewById(R.id.historyBtn);
        Button it = this.findViewById(R.id.itBtn);
        Button politics = this.findViewById(R.id.politicsBtn);


        topFactsBtn.setOnClickListener((v) -> {
            startActivity(intents.topFact);
        });
        favFactsBtn.setOnClickListener((v) -> {
            startActivity(intents.favourites);
        });
        addNewFact.setOnClickListener((v) -> {
            startActivity(intents.newFact);
        });

        sports.setOnClickListener((v) -> {
            Intent intent = intents.factView;
            String buttonText = sports.getText().toString();
            intent.putExtra("category", buttonText);
            startActivity(intent);
        });
        animals.setOnClickListener((v) -> {
            Intent intent = intents.factView;
            String buttonText = animals.getText().toString();
            intent.putExtra("category", buttonText);
            startActivity(intent);
        });
        history.setOnClickListener((v) -> {
            Intent intent = intents.factView;
            String buttonText = history.getText().toString();
            intent.putExtra("category", buttonText);
            startActivity(intent);
        });
        it.setOnClickListener((v) -> {
            Intent intent = intents.factView;
            String buttonText = it.getText().toString();
            intent.putExtra("category", buttonText);
            startActivity(intent);
        });
        politics.setOnClickListener((v) -> {
            Intent intent = intents.factView;
            String buttonText = politics.getText().toString();
            intent.putExtra("category", buttonText);
            startActivity(intent);
        });
    }
}


