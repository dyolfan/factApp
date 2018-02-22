package com.colors.student.factsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peteris on 18.14.2.
 */

public class SQLiteHelper  extends SQLiteOpenHelper {

    private static SQLiteDatabase database;
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    String TABLE_NAME = "Favourites";
    String COLUMN_AUTO_ID = "favId";
    String COLUMN_FACT = "favFact";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_AUTO_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FACT + " VARCHAR);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



    //Inserts object (the "Fact" we just favourited) info into our database,
    // contact is the newly created fact aka Class FavouritesModel object
    public void insertRecord(FavouritesModel contact) {
        if(FactAlreadyAdded(contact.getFact())){
            Log.d("Fact '", contact.getFact()+"' is already added\n");
            return;
        }
        database = this.getWritableDatabase();
        database.execSQL("INSERT INTO " + TABLE_NAME + "(" + COLUMN_FACT + ") VALUES('" + contact.getFact() +"')");
        Log.d("InsertedFact", contact.getFact()+"\n");
        database.close();
    }

    //Deletes column from DB where id is equal our given id, for example: id of the fact user just unfavourited
    public void deleteRecord(FavouritesModel contact) {
        database = this.getWritableDatabase();
        database.execSQL("delete from " + TABLE_NAME + " where " + COLUMN_FACT + " = '" + contact.getFact() + "';");
        database.close();
    }

    public void remakeTable(){
        database = this.getWritableDatabase();
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        //onCreate(database);
    }

    //Selects favourite facts, I have tuned this so it returns all database objects with parameters:
    // OriginalID, Fact text, Category number
    public List<FavouritesModel> getAllRecords() {
        database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        List<FavouritesModel> facts = new ArrayList<FavouritesModel>();
        FavouritesModel contactModel;
        if (cursor.moveToFirst()) {
            do {
                contactModel = new FavouritesModel();
                contactModel.setID(cursor.getInt(0));
                Log.d("FactID:", cursor.getInt(0)+"  ");
                contactModel.setFact(cursor.getString(1));
                Log.d("Fact:", cursor.getString(1)+"\n");
                facts.add(contactModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        //database.close();
        return facts;
    }

    public boolean FactAlreadyAdded(String fact) {
        database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_FACT + " = '" + fact + "';", null);
        List<FavouritesModel> facts = new ArrayList<FavouritesModel>();
        FavouritesModel contactModel;
        if (cursor.moveToFirst()) {
            do {
                contactModel = new FavouritesModel();
                contactModel.setID(cursor.getInt(0));
                Log.d("FactID:", cursor.getInt(0)+"  ");
                contactModel.setFact(cursor.getString(1));
                Log.d("Fact:", cursor.getString(1)+"\n");
                facts.add(contactModel);
            } while (cursor.moveToNext());
        }
        cursor.close();
        //database.close();
        if(facts.isEmpty())return false;
        return true;

    }

}