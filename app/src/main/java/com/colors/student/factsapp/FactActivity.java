package com.colors.student.factsapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import android.content.Context;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        View rootView = getWindow().getDecorView().findViewById(android.R.id.content);

        setContentView(R.layout.fact_view);
        Intents intents = new Intents(this);
        TextView category = findViewById(R.id.category);
        Intent intent = getIntent();
        String message = intent.getExtras().getString("category");
        category.setText(message);
        ImageButton share = findViewById(R.id.shareBtn);
        ImageButton toMenu = findViewById(R.id.backBtn);
        ShareDialog shareDialog = new ShareDialog(this);
        LinearLayout thisAction = findViewById(R.id.thisFact);

        Log.d("message", message);

        TextView fact = findViewById(R.id.factBox);


        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intents.mainMenu);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://post/HelloWorld"));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(intent);
//                String message = fact.getText().toString();
//                Intent shareIntent = new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_TEXT, message);
//                shareIntent.setType("text/plain");
//                startActivity(shareIntent);

                LinearLayout thisAction = findViewById(R.id.thisFact);

            }
//            public void onClick(View view) {

//                if (ShareDialog.canShow(ShareLinkContent.class)) {
//                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
//                            .setQuote("Your message")
//                            .setContentUrl(Uri.parse("http://www.google.com"))
//                            .build();
//
//                    shareDialog.show(linkContent);  // Show facebook ShareDialog
//                }
//            }

        });
    }




}
