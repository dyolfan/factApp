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



    public void addFact(String category, Fact fact) {
        randomRating();
        fact.rating= rating;
                switch (category) {
            case "Sports":
                sports.add(fact);
                break;
            case "Animals":
                animals.add(fact);
                break;
            case "Politics":
                politics.add(fact);
                break;
            case "History":
                history.add(fact);
                break;
            case "IT":
                it.add(fact);
                break;
        }
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

//    public void write(String category, Fact fact) throws IOException {
//        List<Fact> writeList = null;
//        String fileName = "";
//        switch (category) {
//            case "Sports":
//                sports.add(fact);
//                writeList = sports;
//                fileName = "sports.txt";
//                break;
//            case "Animals":
//                animals.add(fact);
//                writeList = animals;
//                fileName = "/animals.dat";
//                break;
//            case "Politics":
//                politics.add(fact);
//                writeList = politics;
//                fileName = "/politics.dat";
//                break;
//            case "History":
//                history.add(fact);
//                writeList = history;
//                fileName = "/history.dat";
//                break;
//            case "IT":
//                it.add(fact);
//                writeList = it;
//                fileName = "/it.dat";
//                break;
//        }
//
//
//        FileOutputStream f = new FileOutputStream(new File("sdcard/" + fileName));
//        ObjectOutputStream o = new ObjectOutputStream(f);
//
//        // Write objects to file
//        o.writeObject(fact);
//
//        o.close();
//        f.close();
//
////        FileOutputStream outStream = null;
////        try {
////            File f = new File(Environment.getExternalStorageDirectory(), fileName);
////            outStream = new FileOutputStream(f);
////            ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
////            objectOutStream.writeObject(writeList);
////            objectOutStream.close();
////        } catch (FileNotFoundException e1) {
////            e1.printStackTrace();
////        } catch (IOException e1) {
////            e1.printStackTrace();
////        }
//    }
//
//    public void loadState(String category) {
//        List<Fact> s =null;
//        FileInputStream inStream = null;
//        try {
//            File f = new File(Environment.getExternalStorageDirectory(), "sdcard/sports.txt");
//            inStream = new FileInputStream(f);
//            ObjectInputStream objectInStream = new ObjectInputStream(inStream);
//
//            s = ((List<Fact>) objectInStream.readObject());
//            objectInStream.close();
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (OptionalDataException e1) {
//            e1.printStackTrace();
//        } catch (StreamCorruptedException e1) {
//            e1.printStackTrace();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//
//        switch (category) {
//            case "Sports":
//                sports = s;
//                break;
//            case "Animals":
//                animals = s;
//                break;
//            case "Politics":
//                politics = s;
//                break;
//            case "History":
//                history = s;
//                break;
//            case "IT":
//                it = s;
//                break;
//        }
//
//    }

}