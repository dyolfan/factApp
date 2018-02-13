package com.colors.student.factsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_menu);

        Button topFactsBtn = this.findViewById(R.id.topfactsBtn);
        final Intent topFacts = new Intent(this, TopFacts.class);


        topFactsBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(topFacts);
            }
        });
    }
}
