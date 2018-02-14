package com.colors.student.factsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fact_view);
        Intents intents = new Intents(this);
        TextView category = findViewById(R.id.category);
        Intent intent = getIntent();
        String message = intent.getExtras().getString("category");
        category.setText(message);
        ImageButton share = findViewById(R.id.shareBtn);
        ImageButton toMenu = findViewById(R.id.backBtn);

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intents.mainMenu);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareText = "Your Body here";
                String shareSub = "Subtitle";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));

            }
        });

    }
}
