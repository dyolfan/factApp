package com.colors.student.factsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import static com.colors.student.factsapp.MainActivity.sQLiteHelper;

/**
 * Created by Helena on 14/02/18.
 */

public class FavouritesActivity extends AppCompatActivity {

    private Fact[] facts;


    public class Fact{
        String shortFact;
        TextView view;
        boolean opened = false;
        String fullFact;
        Fact(String shortFact, String fullFact, TextView view){
            this.shortFact = shortFact;
            this.fullFact = fullFact;
            this.view = view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites_view);

        ImageButton toMainMenu = findViewById(R.id.toMainMenu);
        Intents intents = new Intents(this);
        TextView fact = findViewById(R.id.factBox);
        ImageButton favourite = findViewById(R.id.favouriteFact);
        TextView favfact = findViewById(R.id.fact_1);
// Models list \/
        List<FavouritesModel> arrayList = sQLiteHelper.getAllRecords();
        String fullFact = ""+ arrayList.get(0).getFact();
        String shortfact = fullFact;
        if(fullFact.length() > 18)
            shortfact = fullFact.substring(0,14) + "...";


        Fact fact1 = new Fact(shortfact, fullFact,
                (TextView) this.findViewById(R.id.fact_1));
        Fact fact2 = new Fact("Start of fact 2...", "Start of fact 2 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_2));
        Fact fact3 = new Fact("Start of fact 3...", "Start of fact 3 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_3));
        Fact fact4 = new Fact("Start of fact 4...", "Start of fact 4 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_4));

        facts = new Fact[]{fact1, fact2, fact3, fact4};

        for (int i = 0; i < facts.length; i++)
            setListeners(i);

        toMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intents.mainMenu);
            }
        });

    }







    private void setListeners(final int i) {
        final int x = i;
        facts[i].view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!facts[x].opened) {
                    facts[x].view.setText(facts[i].fullFact);
                    facts[x].opened = true;
                }   else { facts[x].view.setText(facts[i].shortFact);
                    facts[x].opened = false;
                }
            }
        });
    }



}
