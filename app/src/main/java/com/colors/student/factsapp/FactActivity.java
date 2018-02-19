package com.colors.student.factsapp;

import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;
import com.facebook.share.widget.ShareDialog;
import com.colors.student.factsapp.databases.FactController;
import java.util.ArrayList;


/**
 * Created by Helena on 14/02/18.
 */

public class FactActivity extends AppCompatActivity {
    private ShareActionProvider mShareActionProvider;
    TextView category;
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
        TextView factBox = this.findViewById(R.id.factBox);

        Button getFact = findViewById(R.id.getFact);
        FactController fc = new FactController();
        fc.setList();
        factBox.setText(fc.factList.getFact(message).getText());

        getFact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                factBox.setText(fc.factList.getFact(message).getText());
            }
        });

        ImageButton toMenu = findViewById(R.id.backBtn);
        ShareDialog shareDialog = new ShareDialog(this);
        LinearLayout thisAction = findViewById(R.id.thisFact);

        Log.d("message", message);

        TextView fact = findViewById(R.id.factBox);


        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareText = "Your Body here";
                String shareSub = "Subtitle";
                myIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(myIntent, "Share using"));
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
