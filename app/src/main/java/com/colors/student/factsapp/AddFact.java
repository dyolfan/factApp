package com.colors.student.factsapp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.colors.student.factsapp.databases.FactList;

/**
 * Created by Helena on 16/02/18.
 */

public class AddFact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_fact);
        ImageButton toMenu = findViewById(R.id.toMainMenu);
        Button submitFact = findViewById(R.id.submitFact);
        Intents intents = new Intents(this);
        Spinner mySpinner = findViewById(R.id.chooseCatgory);



        Spinner spinner = this.findViewById(R.id.chooseCatgory);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.categoryList, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        submitFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FactList facts = new FactList();
                TextInputEditText fact = findViewById(R.id.newFactText);
                String newFact = fact.getText().toString();
                String selectedCat = mySpinner.getSelectedItem().toString();
                Log.i("FACT", newFact);
                Log.i("CATEGORY", selectedCat);
             //   facts.userAddFact(newFact, selectedCat);

                startActivity(intents.mainMenu);
            }
        });
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intents.mainMenu);
            }
        });


    }
}
