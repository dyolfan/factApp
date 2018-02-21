package com.colors.student.factsapp.databases;

import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

/**
 * Created by student on 2/19/18.
 */
public class FactListTest {
    @Test
    public void addFact() throws Exception {
    Fact fact = new Fact(4, "Wood is si doow, bla bla bla",15);

    }

    @Test
    public void getFact() throws Exception {

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