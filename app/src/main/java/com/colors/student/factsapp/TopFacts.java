package com.colors.student.factsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.colors.student.factsapp.databases.Fact;
import com.colors.student.factsapp.databases.FactList;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import static android.content.ContentValues.TAG;

/**
 * Created by kirils on 13.02.18.
 */

public class TopFacts extends AppCompatActivity {
    private static FactList list = new FactList();
    private static DatabaseReference dRef;
    String selected = "Sports";
    boolean wasSelectedSports = false;
    boolean wasSelectedAnimals = false;
    boolean wasSelectedPolitics = false;
    boolean wasSelectedIt = false;
    boolean wasSelectedHistory = false;
    String selectedString = "";
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
        TextView[] rs1 = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10};
        rs = rs1;
        list = new FactList();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected = spinner.getSelectedItem().toString();
                dRef = FirebaseDatabase.getInstance("https://factsapp-19a2f.firebaseio.com/").getReference().child(selected);
                dRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        if (!selectedString.contains(selected)) {
                            for (DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()) {
                                String text = uniqueKeySnapshot.child("text").getValue().toString();
                                String key = uniqueKeySnapshot.getKey();
                                int rating = Integer.parseInt(uniqueKeySnapshot.child("rating").getValue().toString());
                                Fact newFact = new Fact(text, rating, key);
                                Log.i("tag: ", newFact.toString());

                                switch (selected) {
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

                            switch (selected) {
                                case "Sports":
                                    for (int i = 0; i < 10; i++)
                                        rs[i].setText(list.sports.get(i).getShortText());
                                    facts = list.sports.toArray(facts);
                                    wasSelectedSports = true;
                                    break;
                                case "Animals":
                                    for (int i = 0; i < 10; i++)
                                        rs[i].setText(list.animals.get(i).getShortText());
                                    facts = list.animals.toArray(facts);
                                    wasSelectedAnimals = true;
                                    break;
                                case "Politics":
                                    for (int i = 0; i < 10; i++)
                                        rs[i].setText(list.politics.get(i).getShortText());
                                    facts = list.politics.toArray(facts);
                                    wasSelectedPolitics = true;
                                    break;
                                case "History":
                                    for (int i = 0; i < 10; i++)
                                        rs[i].setText(list.history.get(i).getShortText());
                                    facts = list.sports.toArray(facts);
                                    wasSelectedHistory = true;
                                    break;
                                case "IT":
                                    for (int i = 0; i < 10; i++)
                                        rs[i].setText(list.it.get(i).getShortText());
                                    facts = list.sports.toArray(facts);
                                    wasSelectedIt = true;
                                    break;
                            }
                            for (int i = 0; i < 10; i++)
                                setListeners(i);
                            selectedString += selected;
                        }
                        changeTop(selected);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });
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
                list.sortTopFacts(category);
                for (int i = 0; i < 10; i++)
                    rs[i].setText(list.sports.get(i).getShortText());
                facts = list.sports.toArray(facts);
                break;

            case "Animals":
                list.sortTopFacts(category);
                for (int i = 0; i < 10; i++)
                    rs[i].setText(list.animals.get(i).getShortText());
                facts = list.animals.toArray(facts);
                break;

            case "Politics":
                list.sortTopFacts(category);
                for (int i = 0; i < 10; i++)
                    rs[i].setText(list.politics.get(i).getShortText());
                facts = list.politics.toArray(facts);
                break;
            case "History":
                list.sortTopFacts(category);
                for (int i = 0; i < 10; i++)
                    rs[i].setText(list.history.get(i).getShortText());
                facts = list.history.toArray(facts);
                break;
            case "IT":
                list.sortTopFacts(category);
                for (int i = 0; i < 10; i++)
                    rs[i].setText(list.it.get(i).getShortText());
                facts = list.it.toArray(facts);
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
                if (!facts[x].opened) {
                    rs[i].setText(facts[i].getText());
                    facts[x].opened = true;
                } else {
                    rs[i].setText(facts[i].getShortText());
                    facts[x].opened = false;
                }
            }
        });
    }
}
