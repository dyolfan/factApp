package com.colors.student.factsapp.databases;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
    int rating;

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