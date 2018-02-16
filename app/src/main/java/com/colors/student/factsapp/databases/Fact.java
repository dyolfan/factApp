package com.colors.student.factsapp.databases;

/**
 * Created by kirils on 14.02.18.
 */

public class Fact {
    public int id;
    public String txt;
    public String shortText;
    public int rating;

    public Fact(int id, String txt, int rating){
        this.id = id;
        this.txt = txt;
        this.rating = rating;
        this.shortText = getShortText(txt);
    }

    public String getText(){
        return this.txt;
    }

    public String getShortText(String text) {
       return shortText = text.substring(0, 5);
    }
}
