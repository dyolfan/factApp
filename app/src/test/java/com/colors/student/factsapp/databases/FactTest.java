package com.colors.student.factsapp.databases;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 2/19/18.
 */
public class FactTest {
    @Test
    public void getText() throws Exception {
        String output;
        Fact fact = new Fact(4,"Wood is si doow",34);
        String expected = "Wood is si doow";
        output = fact.getText();
        assertEquals(output, expected);
    }

    @Test
    public void getShortText() throws Exception {
            String output;
            Fact fact = new Fact(4,"Wood is si doow Wood is si doow", 34);
            String expected = "Wood is si doo... ";
            output = fact.getShortText();
            assertEquals(output, expected);

    }

    @Test
    public void compareTo() throws Exception {
    }

}