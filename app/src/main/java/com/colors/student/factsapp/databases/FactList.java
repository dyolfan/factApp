package com.colors.student.factsapp.databases;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Switch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kirils on 16.02.18.
 */

public class FactList {
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

    Fact fact1 = new Fact(1, "TRAINED PIGEONS CAN TELL THE DIFFERENCE BETWEEN THE PAINTINGS OF PABLO PICASSO AND CLAUDE MONET.", rating);
    Fact fact2 = new Fact(2, "STUDIES HAVE SHOWN THAT WILD CHIMPS IN GUINEA DRINK FERMENTED PALM SAP, WHICH CONTAINS ABOUT 3 PERCENT ALCOHOL BY VOLUME.", rating);
    Fact fact3 = new Fact(3, "CAPUCHIN MONKEYS PEE ON THEIR HANDS TO WASH THEIR FEET.", rating);
    Fact fact4 = new Fact(4, "TIGERS HAVE STRIPED SKIN AS WELL. EACH PATTERN IS AS UNIQUE AS A FINGERPRINT.", rating);
    Fact fact5 = new Fact(5, "SEA OTTERS HOLD HANDS WHILE THEY'RE SLEEPING SO THEY DON'T DRIFT APART.", rating);
    Fact fact6 = new Fact(6, "CATS DON'T MEOW AS A WAY TO COMMUNICATE WITH EACH OTHER. THEY USE IT FOR GETTING ATTENTION FROM HUMANS.", rating);
    Fact fact7 = new Fact(7, "FLAMINGOS ARE NATURALLY WHITE—THEIR DIET OF BRINE SHRIMP AND ALGAE TURNS THEM PINK.", rating);
    Fact fact8 = new Fact(8, "ALBERTA, CANADA IS THE LARGEST RAT-FREE POPULATED AREA IN THE WORLD.", rating);
    Fact fact9 = new Fact(9, "IN THE UK, THE BRITISH MONARCH LEGALLY OWNS ALL UNMARKED MUTE SWANS IN OPEN WATER.", rating);
    Fact fact10 = new Fact(10, "ANTEATERS DON’T HAVE TEETH.", rating);
    Fact fact11 = new Fact(11, "MALE RING-TAILED LEMURS WILL \"STINK FIGHT\" BY WAFTING SCENT AT EACH OTHER.", rating);
    Fact fact12= new Fact(12, "IN 1924, A LABRADOR RETRIEVER WAS SENTENCED TO LIFE WITHOUT PAROLE AT EASTERN STATE PENITENTIARY FOR KILLING THE GOVERNOR'S CAT.", rating);
    Fact fact13 = new Fact(13, "NINE-BANDED ARMADILLOS ALWAYS GIVE BIRTH TO IDENTICAL QUADRUPLETS.", rating);
    Fact fact14 = new Fact(14, "CATS CAN'T TASTE SUGAR. THEY DON'T HAVE SWEET TASTE BUDS.", rating);
    Fact fact15= new Fact(15, "DUCKS LIKE TO SURF. THEY HAVE BEEN OBSERVED RIDING TIDES AND SWIMMING BACK TO RIDE THEM AGAIN.", rating);
    Fact fact16= new Fact(16, "BIRDS ARE IMMUNE TO THE HEAT OF CHILI PEPPERS.", rating);
    Fact fact17= new Fact(17, "CARIBBEAN SPERM WHALES HAVE THEIR OWN REGIONAL ACCENT.", rating);
    Fact fact18= new Fact(18, "WOMBAT POOP IS CUBE-SHAPED.", rating);
    Fact fact19= new Fact(17, "LIONS INHABITED MANY AREAS OF EUROPE UNTIL THEY WERE HUNTED TO EXTINCTION IN THE REGION AROUND 100 BCE.", rating);
    Fact fact20= new Fact(18, "THE OTTOMAN EMPIRE'S SULTAN IBRAHIM I HAD 280 OF HIS CONCUBINES DROWNED IN THE OCEAN AFTER ONE OF THEM SLEPT WITH ANOTHER MAN.", rating);


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