package com.colors.student.factsapp.databases;

import android.support.annotation.NonNull;

/**
 * Created by kirils on 14.02.18.
 */

public class Fact implements Comparable<Fact>{


    public String text;
    public String shortText;
    public int rating;
    public boolean oppened = false;

    public Fact(String txt, int rating){
        this.text = txt;
        this.rating = rating;
        this.shortText = getShortText();
        this.oppened = false;
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
