package com.colors.student.factsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

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
        ShareDialog shareDialog = new ShareDialog(this);

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intents.mainMenu);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
//            public void onClick(View view) {
//                Intent shareIntent = new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_TEXT, "http://www.google.com");
//                shareIntent.setType("text/plain");
//                startActivity(shareIntent);
//
//            }
            public void onClick(View view) {

                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setQuote("Your message")
                            .setContentUrl(Uri.parse(""))
                            .build();

                    shareDialog.show(linkContent);  // Show facebook ShareDialog
                }

//                Intent shareIntent = new Intent();
//                shareIntent.setAction(Intent.ACTION_SEND);
//                shareIntent.putExtra(Intent.EXTRA_REPLACEMENT_EXTRAS, "Your text here");
//                shareIntent.setType("text/plain");
//                startActivity(shareIntent);

            }
        });

    }
}
