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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_menu);

        Intents intents = new Intents(this);
        Button topFactsBtn = this.findViewById(R.id.topfactsBtn);


        topFactsBtn.setOnClickListener((v) -> {
            startActivity(intents.topFact);
        });
    }
}
