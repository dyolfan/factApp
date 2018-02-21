package com.colors.student.factsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.colors.student.factsapp.databases.Fact;
import com.colors.student.factsapp.databases.FactController;

/**
 * Created by kirils on 13.02.18.
 */

public class TopFacts extends AppCompatActivity {
    private Fact[] facts = new Fact[10];
    private TextView r1;
    private TextView r2;
    private TextView r3;
    private TextView r4;
    private TextView r5;
    private TextView r6;
    private TextView r7;
    private TextView r8;
    private TextView r9;
    private TextView r10;
    private TextView[] rs;
    private FactController fc = new FactController();

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
        r1 = (TextView) this.findViewById(R.id.fact_r1);
        r2 = (TextView) this.findViewById(R.id.fact_r2);
        r3 = (TextView) this.findViewById(R.id.fact_r3);
        r4 = (TextView) this.findViewById(R.id.fact_r4);
        r5 = (TextView) this.findViewById(R.id.fact_r5);
        r6 = (TextView) this.findViewById(R.id.fact_r6);
        r7 = (TextView) this.findViewById(R.id.fact_r7);
        r8 = (TextView) this.findViewById(R.id.fact_r8);
        r9 = (TextView) this.findViewById(R.id.fact_r9);
        r10 = (TextView) this.findViewById(R.id.fact_r10);
        TextView[] rs1 = {r1,r2,r3,r4,r5,r6,r7,r8,r9,r10};
        rs = rs1;
//        fc.setList();

        fc.factList.sortTopFacts("Sports");

        for(int i = 0; i <10; i++)
            rs[i].setText(fc.factList.sports.get(i).getShortText());
        facts = fc.factList.sports.toArray(facts);
        for (int i = 0; i < 10; i++)
            setListeners(i);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selected = spinner.getSelectedItem().toString();
                    changeTop(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        toMainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intents.mainMenu);
            }
        });
    }

    private void changeTop(String category) {
        switch (category) {
            case "Sports":
                fc.factList.sortTopFacts(category);
                for(int i = 0; i <10; i++)
                    rs[i].setText(fc.factList.sports.get(i).getShortText());
                facts = fc.factList.sports.toArray(facts);
                break;

            case "Animals":
                fc.factList.sortTopFacts(category);
                for(int i = 0; i <10; i++)
                    rs[i].setText(fc.factList.animals.get(i).getShortText());
                facts = fc.factList.animals.toArray(facts);
                break;

            case "Politics":
                fc.factList.sortTopFacts(category);
                for(int i = 0; i <10; i++)
                    rs[i].setText(fc.factList.animals.get(i).getShortText());
                facts = fc.factList.politics.toArray(facts);
                break;
            case "History":
                fc.factList.sortTopFacts(category);
                for(int i = 0; i <10; i++)
                    rs[i].setText(fc.factList.history.get(i).getShortText());
                facts = fc.factList.history.toArray(facts);
                break;
            case "IT":
                fc.factList.sortTopFacts(category);
                for(int i = 0; i <10; i++)
                    rs[i].setText(fc.factList.it.get(i).getShortText());
                facts = fc.factList.it.toArray(facts);
                break;
        }
        for (int i = 0; i < 10; i++)
            setListeners(i);
    }

    private void setListeners(final int i) {
        final int x = i;
        rs[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!facts[x].oppened) {
                    rs[i].setText(facts[i].getText());
                    facts[x].oppened = true;
                }   else { rs[i].setText(facts[i].getShortText());
                    facts[x].oppened = false;
                }
            }
        });
    }
}
