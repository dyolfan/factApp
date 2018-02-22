package com.colors.student.factsapp.databases;



import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;


public class FactListTest {
    @Test
    public void userAddFact() throws Exception {
    Fact fact = new Fact( "Wood is si doow, bla bla bla",15, "ww");

    }
    @Test
    public void getFact() throws Exception{
        FactList factlist = new FactList();
        Fact fact = new Fact("Ball is round", 7,"tt");
        Fact fact1 = new Fact("Ball is rounder", 8,"rr");
        Fact fact2 = new Fact("Ball is rounderer", 9,"ee");
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