package com.colors.student.factsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.colors.student.factsapp.databases.DatabaseAccess;
import com.colors.student.factsapp.databases.Fact;
import com.colors.student.factsapp.databases.FactController;
import com.colors.student.factsapp.databases.FactList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;
    ArrayList<String> facts = new ArrayList<>();
    String input;
    String factText;
    String factId;
    String factRating;

    TextView category;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fact_view);
        category = findViewById(R.id.category);

        Intent intent = getIntent();
        String message = intent.getExtras().getString("category");
        category.setText(message);
        ImageButton share = findViewById(R.id.shareBtn);
        TextView factBox = this.findViewById(R.id.factBox);

        Button getFact = findViewById(R.id.getFact);


        getFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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