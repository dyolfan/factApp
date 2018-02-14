package com.colors.student.factsapp;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kirils on 13.02.18.
 */

public class TopFacts extends AppCompatActivity {

    private Fact[] facts;

    public class Fact {
        TextView view;
        String shortFact;
        boolean oppened = false;
        String fullFact;
        Fact(String shortFact, String fullFact, TextView view) {
            this.shortFact = shortFact;
            this.fullFact = fullFact;
            this.view = view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_facts);

        ImageButton toMainMenuBtn = this.findViewById(R.id.toMainMenuBtn);
        Intents intents = new Intents(this);



        Spinner spinner = this.findViewById(R.id.categorySpinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.categoryList, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        Fact fact1 = new Fact("Start of fact 1...", "Start of fact 1 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_r1));
        Fact fact2 = new Fact("Start of fact 2...", "Start of fact 2 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_r2));
        Fact fact3 = new Fact("Start of fact 3...", "Start of fact 3 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_r3));
        Fact fact4 = new Fact("Start of fact 4...", "Start of fact 4 and more more more more more more more more more more more more more more text",
                (TextView) this.findViewById(R.id.fact_r4));

        facts = new Fact[]{fact1, fact2, fact3, fact4};

        for (int i = 0; i < facts.length; i++)
            setListeners(i);

//        shortFact1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO: Get text from top 1 fact
//                if(!oppened) {
//                    shortFact1.setText("Start of fact 1 and more more more more more more more more more more more more more more text");
//                    oppened = true;
//                } else { shortFact1.setText("Start of fact 1...");
//                    oppened = false;
//                }
//            }
//        });

        toMainMenuBtn.setOnClickListener(new View.OnClickListener() {
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
                if (!facts[x].oppened) {
                    facts[x].view.setText(facts[i].fullFact);
                    facts[x].oppened = true;
                }   else { facts[x].view.setText(facts[i].shortFact);
                    facts[x].oppened = false;
                }
            }
        });
    }
}
