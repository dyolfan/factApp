package com.colors.student.factsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.colors.student.factsapp.databases.FactList;

/**
 * Created by Helena on 16/02/18.
 */

public class AddFact extends AppCompatActivity {
    String DBurl = "https://factsapp-19a2f.firebaseio.com/";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_fact);
        context = this.getApplicationContext();
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
                if (!newFact.equals("") && newFact != null) {
                    String selectedCat = mySpinner.getSelectedItem().toString();
                    Log.i("FACT", newFact);
                    Log.i("CATEGORY", selectedCat);
                    facts.userAddFact(newFact, selectedCat, DBurl);
                    startActivity(intents.mainMenu);
                } else {
                    Toast toast = Toast.makeText(context, "Please enter valid fact", Toast.LENGTH_SHORT);
                    toast.show();
                }
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
