package com.colors.student.factsapp;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ProgressBar;


public class LoadingActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2500;
    ProgressBar loading;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.loading_screen);
        loading = findViewById(R.id.progressBar);

        Intents intents = new Intents(this);


        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 10;
                    handler.post(new Runnable() {
                        public void run() {
                            loading.setProgress(progressStatus);
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intents.login);
                finish();
            }
        }, SPLASH_TIME_OUT);


    }

}
