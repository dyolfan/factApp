package com.colors.student.factsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Peteris on 18.14.2.
 */

public class SQLiteHelper  extends SQLiteOpenHelper {
    private SQLiteDatabase database;
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabase.db";
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String TABLE_NAME = "Favourites";
    String COLUMN_AUTO_ID = "favId";
    String COLUMN_OG_ID = "id";
    String COLUMN_FACT = "favFact";
    String COLUMN_CATEGORY = "category";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_AUTO_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_OG_ID + " INTEGER, "+ COLUMN_FACT + " VARCHAR, " + COLUMN_CATEGORY + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



    //Inserts object (the "Fact" we just favourited) info into our database
    public void insertRecord(FavouritesModel contact) {
        database = this.getReadableDatabase();
        database.execSQL("INSERT INTO " + TABLE_NAME + "(" + COLUMN_FACT + "," + COLUMN_CATEGORY + "," + COLUMN_OG_ID + ") VALUES('" + contact.getFact() + "','" + contact.getCategory()+ "','" + contact.getID() + "')");
        database.close();
    }

    //Deletes column from DB where id is equal our given id, for example: id of the fact user just unfavourited
    public void deleteRecordAlternate(FavouritesModel contact) {
        database = this.getReadableDatabase();
        database.execSQL("delete from " + TABLE_NAME + " where " + COLUMN_OG_ID + " = '" + contact.getID() + "'");
        database.close();
    }

    //Selects favourite facts, I have tuned this so it returns all database objects with parameters: OriginalID, Fact text, Category number
    public ArrayList<FavouritesModel> getAllRecordsAlternate() {
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<FavouritesModel> contacts = new ArrayList<FavouritesModel>();
        FavouritesModel contactModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contactModel = new FavouritesModel();
                contactModel.setID(cursor.getInt(1));
                contactModel.setFact(cursor.getString(2));
                contactModel.setCategory(cursor.getInt(3));
                contacts.add(contactModel);
            }
        }
        cursor.close();
        database.close();
        return contacts;
    }
}
