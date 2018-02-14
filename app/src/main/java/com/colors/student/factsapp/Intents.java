package com.colors.student.factsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kirils on 14.02.18.
 */
public class Intents extends AppCompatActivity {
    Intent mainMenu;
    Intent loading;
    Intent login;
    Intent topFact;
    Intent rating;
    Intent favourites;
    Intent factView;


    Intents(Context thisContext){
        this.mainMenu = new Intent(thisContext, MainActivity.class);
        this.loading = new Intent(thisContext, LoadingActivity.class);
        this.login = new Intent(thisContext, LoginActivity.class);
        this.topFact = new Intent(thisContext, TopFacts.class);
        this.favourites = new Intent(thisContext, FavouritesActivity.class);
        this.factView = new Intent(thisContext, FactActivity.class);
    }

}
