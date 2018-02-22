package com.colors.student.factsapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.colors.student.factsapp.MainActivity.sQLiteHelper;

/**
 * Created by Helena on 14/02/18.
 */

public class FavouritesActivity extends AppCompatActivity {
    private List<Fact> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favourites_view);

        ImageButton toMainMenu = findViewById(R.id.toMainMenu);
        Intents intents = new Intents(this);
        List<FavouritesModel> arrayList = sQLiteHelper.getAllRecords();

        for (FavouritesModel x : arrayList) {
            TextView tv = new TextView(this);
            tv.setWidth(300);
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundColor(Color.rgb(66, 165, 245));
            tv.setTextSize(30);
            tv.setPadding(5, 5, 5, 5);
            LinearLayout layout = this.findViewById(R.id.facts);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 15, 0, 15);

            Fact newFact = new Fact(x.getFact().substring(0, 14) + "... ", x.getFact(), tv);
            list.add(newFact);
            tv.setText(newFact.shortFact);
            layout.addView(tv, layoutParams);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!newFact.opened) {
                        newFact.view.setText(newFact.fullFact);
                        newFact.opened = true;
                    } else {
                        newFact.view.setText(newFact.shortFact);
                        newFact.opened = false;
                    }
                }
            });
        }

        toMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intents.mainMenu);
            }
        });
    }

    public class Fact {
        String shortFact;
        TextView view;
        boolean opened = false;
        String fullFact;

        Fact(String shortFact, String fullFact, TextView view) {
            this.shortFact = shortFact;
            this.fullFact = fullFact;
            this.view = view;
        }
    }
}