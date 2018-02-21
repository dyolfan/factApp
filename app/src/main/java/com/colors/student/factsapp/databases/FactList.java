package com.colors.student.factsapp.databases;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/**
 * Created by kirils on 16.02.18.
 */

public class FactList {



    // Write a message to the database

    // TODO: get facts from base;
    public List<Fact> sports;
    public List<Fact> animals;
    public List<Fact> politics;
    public List<Fact> history;
    public List<Fact> it;
    public TreeSet<Fact> top = new TreeSet<>();
    int rating;
    boolean sorted = false;

    public FactList() {
        this.sports = new LinkedList<>();
        this.animals = new LinkedList<>();
        this.politics = new LinkedList<>();
        this.history = new LinkedList<>();
        this.it = new LinkedList<>();
    }

    public void userAddFact(String factText, String category){
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        Fact newFact = new Fact(factText, 0);
        dbRef.child(category).push().setValue(newFact);
    }


    public Fact getFact(String category) {

        Random rand = new Random();
        int randn = rand.nextInt(19);
        switch (category) {
            case "Sports":
                return sports.get(randn);
            case "Animals":
                return animals.get(randn);
            case "Politics":
                return politics.get(randn);
            case "History":

                return history.get(randn);
            case "IT":
                randn = rand.nextInt(31);
                return it.get(randn);
        }
        return null;
    }

    public void sortTopFacts(String category) {
        List<Fact> topTen = new LinkedList<>();
        if(!sorted) {
            Collections.sort(sports);
            Collections.reverse(sports);
            Collections.sort(animals);
            Collections.reverse(animals);
            Collections.sort(politics);
            Collections.reverse(politics);
            Collections.sort(history);
            Collections.reverse(history);
            Collections.sort(it);
            Collections.reverse(it);
        }
        switch (category) {
            case "Sports":
                for(int i=0; i<10; i++)
                    topTen.add(sports.get(i));
                break;
            case "Animals":
                for(int i=0; i<10; i++)
                    topTen.add(animals.get(i));
                break;
            case "Politics":
                for(int i=0; i<10; i++)
                    topTen.add(politics.get(i));
                break;
            case "History":
                for(int i=0; i<10; i++)
                    topTen.add(politics.get(i));
                break;
            case "IT":
                for(int i=0; i<10; i++)
                    topTen.add(politics.get(i));
                break;
        }
    }

    public void randomRating()
    {
        int range = (50 + 50) + 1;
        rating = (int)(Math.random() * range) - 50;
    }



}