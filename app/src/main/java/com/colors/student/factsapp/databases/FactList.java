package com.colors.student.factsapp.databases;

import android.renderscript.Sampler;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static android.content.ContentValues.TAG;

/**
 * Created by kirils on 16.02.18.
 */

public class FactList {
    // TODO: get facts from base;
    public List<Fact> sports;
    public List<Fact> animals;
    public List<Fact> politics;
    public List<Fact> history;
    public List<Fact> it;
    public TreeSet<Fact> top = new TreeSet<>();
    int rating;
    boolean sorted = false;
    int previousRandom = 0;

    public FactList() {
        this.sports = new LinkedList<>();
        this.animals = new LinkedList<>();
        this.politics = new LinkedList<>();
        this.history = new LinkedList<>();
        this.it = new LinkedList<>();
    }
//    public void loadFacts(String category) {
//        switch (category) {
//            case "Sports":
//                // Code witch gets data
////            sports.addAll();
//                break;
//            case "Animals":
//                // Code witch gets data
////        animals.addAll();
//                break;
//            case "Politics":
//                // Code witch gets data
////         politics.addAll();
//                break;
//            case "History":
//                // Code witch gets data
////        history.addAll();
//                break;
//            case "IT":
//                // Code witch gets data
////        it.add(fact);
//                break;
//        }
//    }

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



//    public void setCategory(String text) {
//        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://factsapp-19a2f.firebaseio.com/").getReference().child(text);
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                for (DataSnapshot uniqueKeySnapshot : dataSnapshot.getChildren()){
//                    String text = uniqueKeySnapshot.child("text").getValue().toString();
//                    int rating = Integer.parseInt(uniqueKeySnapshot.child("rating").getValue().toString());
//                    Log.i("tag: ", text);
//                    Log.i("tag: ", Integer.toString(rating));
//
//                    Fact newFact = new Fact(text, rating);
//                    switch (text) {
//                        case "Sports":
//                            sports.add(newFact);
//                            break;
//                        case "Animals":
//                            animals.add(newFact);
//                            break;
//                        case "Politics":
//                            politics.add(newFact);
//                            break;
//                        case "History":
//                            history.add(newFact);
//                            break;
//                        case "IT":
//                            history.add(newFact);
//                            break;
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//    }

    public Fact getFact(String category) {
        Random rand = new Random();
        int randn = 0;
        switch (category) {
            case "Sports":
                do {
                    randn = rand.nextInt(sports.size()-1);
                } while (previousRandom == randn);
                return sports.get(randn);
            case "Animals":
                do {
                    randn = rand.nextInt(animals.size()-1);
                } while (previousRandom == randn);
                return animals.get(randn);
            case "Politics":
                do {
                    randn = rand.nextInt(politics.size()-1);
                } while (previousRandom == randn);
                return politics.get(randn);
            case "History":
                do {
                    randn = rand.nextInt(history.size()-1);
                } while (previousRandom == randn);
                return history.get(randn);
            case "IT":
                do {
                    randn = rand.nextInt(it.size()-1);
                } while (previousRandom == randn);
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