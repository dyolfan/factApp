package com.colors.student.factsapp.databases;

import android.support.annotation.NonNull;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kirils on 14.02.18.
 */

public class Fact implements Comparable<Fact>{



    public int id;
    public String text;
    public String shortText;
    public int rating;
    public boolean oppened = false;



    public Fact(int id, String txt, int rating){
        this.id = id;
        this.text = txt;
        this.rating = rating;
        this.shortText = getShortText();
    }

    public String getText(){
        return this.text;
    }

    public String getShortText() {
        if (text.length()<15)
            return text;
       return  text.substring(0, 14)+ "... ";
    }


    @Override
    public int compareTo(@NonNull Fact o) {
        if (this.rating < o.rating)
            return -1;
        if (this.rating > o.rating)
            return 1;
        else return 0;
    }
}
