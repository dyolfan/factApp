package com.colors.student.factsapp.databases;

import android.support.annotation.NonNull;

/**
 * Created by kirils on 14.02.18.
 */

public class Fact implements Comparable<Fact> {

    public String key;
    public String text;
    public String shortText;
    public int rating;
    public boolean oppened = false;

    public Fact(String txt, int rating, String key) {
        this.key = key;
        this.text = txt;
        this.rating = rating;
        this.shortText = getShortText();
        this.oppened = false;
    }

    public Fact(String txt) {
        this.text = txt;
        this.rating = 0;
        this.shortText = getShortText();
        this.oppened = false;
    }

    public String getText() {
        return this.text;
    }

    public String getShortText() {
        if (text.length() < 15)
            return text;
        return text.substring(0, 14) + "... ";
    }

    public String getKey() {
        return this.key;
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
