package com.colors.student.factsapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Peteris on 18.22.2.
 */

public class SQLiteHelperTest {
    private SQLiteHelper mDb;

    @Before
    public void setUp() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = new SQLiteHelper(context);
        mDb.deleteAllRecords();
    }

    @After
    public void tearDown() throws Exception {
        mDb.deleteAllRecords();
        mDb.close();
    }

    @Test
    public void insertAndGetAllRecord() throws Exception {
        String fact;
        FavouritesModel model;
        for(int i=0; i<50; i++) {
            fact = "This is test fact nr."+i+" and it works.";
            model = new FavouritesModel(fact);
            mDb.insertRecord(model);
        }
        List<FavouritesModel> list = mDb.getAllRecords();
        int i=0;
        for(FavouritesModel tempModel: list){
            assertEquals("This is test fact nr."+i+" and it works.", tempModel.getFact());
            i++;
        }
    }

    @Test
    public void deleteRecord() throws Exception {
        String fact;
        FavouritesModel model;
        //Fill database with 50 different records
        for(int i=0; i<50; i++) {
            fact = "This is test fact nr."+i+" and it works.";
            model = new FavouritesModel(fact);
            mDb.insertRecord(model);
        }
        //Delete them on by one while asserting how many are left
        for(int i=50; i>0; i--){
            assertEquals(i, mDb.getAllRecords().size());
            fact = "This is test fact nr."+(i-1)+" and it works.";
            model = new FavouritesModel(fact);
            mDb.deleteRecord(model);
        }
        assertEquals(0, mDb.getAllRecords().size());
    }

    @Test
    public void factAlreadyAdded() throws Exception {
        String fact;
        FavouritesModel model;
        int size=0;
        mDb.deleteAllRecords();
        for(int i=0; i<50; i++) {
            if(i%2==0){
                fact = "This is test fact nr."+(i)+" and it works.";
                model = new FavouritesModel(fact);
                mDb.insertRecord(model);
                size++;//increase size by one because new record is added
                assertEquals(size, mDb.getAllRecords().size());
            }else{
                fact = "This is test fact nr."+(i-1)+" and it works.";
                model = new FavouritesModel(fact);
                mDb.insertRecord(model);
                //even tho we tried adding a record, the size wont change because the record already
                //exists in our database, so we don't need to increase expected size.
                assertEquals(size, mDb.getAllRecords().size());
            }

        }
    }

}