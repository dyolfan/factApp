package com.colors.student.factsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

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


        Spinner spinner = this.findViewById(R.id.chooseCatgory);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.categoryList, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        submitFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


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
