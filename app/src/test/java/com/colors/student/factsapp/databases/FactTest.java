package com.colors.student.factsapp.databases;

import org.junit.Test;

import static org.junit.Assert.*;


public class FactTest {
    @Test
    public void getKey() throws Exception {
        Fact fact = new Fact("This is fact.","ooo");
        String output;
        String expected = "ooo";
        output = fact.getKey();
        assertEquals(output,expected);
    }

    @Test
    public void getText() throws Exception {
        String output;
        Fact fact = new Fact("Wood is si doow");
        String expected = "Wood is si doow";
        output = fact.getText();
        assertEquals(output, expected);
    }

    @Test
    public void getShortText() throws Exception {
            String output;
            Fact fact = new Fact("Wood is si doow Wood is si doow");
            String expected = "Wood is si doo... ";
            output = fact.getShortText();
            assertEquals(output, expected);

    }

    @Test
    public void compareTo() throws Exception {
            int output1 = -1;
            int output2 = 1;
            int output3 = 0;
            Fact fact = new Fact("Wood is si doow wood is si dooW", 5);
            Fact fact1 = new Fact("Bla bla bla bla bla", 6);
            Fact fact2 = new Fact("Bla bla bla bla bla", 4);
            Fact fact3 = new Fact("Bla bla bla bla bla", 5);
            int result1 = fact.compareTo(fact1);
            int result2 = fact.compareTo(fact2);
            int result3 = fact.compareTo(fact3);
            assertEquals(output1,result1);
            assertEquals(output2,result2);
            assertEquals(output3,result3);
    }

}