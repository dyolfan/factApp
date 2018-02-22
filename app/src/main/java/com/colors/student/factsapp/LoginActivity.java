package com.colors.student.factsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
/**
 + * Created by Helena on 14/02/18.
 + */

        public class LoginActivity extends AppCompatActivity {
    LoginButton loginBtn;
    TextView skip;
    TextView status;
    CallbackManager callbackManager;


            @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

            FacebookSdk.sdkInitialize(getApplicationContext());
            AppEventsLogger.activateApp(this);

            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.login_view);
            loginBtn = findViewById(R.id.login_button);
            Intents intents = new Intents(this);
            skip = findViewById(R.id.skipLogin);
            status = findViewById(R.id.status);
            callbackManager = CallbackManager.Factory.create();

            loginBtn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                    startActivity(intents.mainMenu);
                }

            @Override
            public void onCancel() {
                    status.setText("Login cancelled");
                }

            @Override
            public void onError(FacebookException error) {
                    status.setText("Login Error");
                }

                });

            skip.setOnClickListener((v)->{
                    startActivity(intents.mainMenu);
                });

        }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
                callbackManager.onActivityResult(requestCode, resultCode, data);
                super.onActivityResult(requestCode, resultCode, data);
            }
}