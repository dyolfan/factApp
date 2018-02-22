package com.colors.student.factsapp.databases;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;


public class FactListTest {
//    @Test
//    public void userAddFact() throws Exception {
//        String DBurlTest = "https://factapptest.firebaseio.com/";
//        Fact fact = new Fact( "Wood is si doow, bla bla bla", "ww");
//        FactList factlist = new FactList();
//        int size1 = factlist.animals.size();
//        factlist.userAddFact("Kittens are cute!","Animals",DBurlTest);
//        int size2 = factlist.animals.size();
//        assertNotEquals(size1,size2);
//    }
    @Test
    public void getFact() throws Exception{
        FactList factlist = new FactList();
        Fact fact = new Fact("Ball is round");
        Fact fact1 = new Fact("Ball is rounder");
        Fact fact2 = new Fact("Ball is rounderer");
        factlist.sports.add(fact);
        factlist.sports.add(fact1);
        factlist.sports.add(fact2);
        assertNotNull(factlist.getFact("Sports"));

    }
    @Test
    public void sortTopFacts() throws Exception {

    }

    @Test
    public void randomRating() throws Exception {
        FactList factList = new FactList();
        Assert.assertNotNull(factList.rating);
    }

}