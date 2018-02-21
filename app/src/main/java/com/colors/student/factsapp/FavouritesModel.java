package com.colors.student.factsapp;

/**
 * Created by Peteris on 18.14.2.
 */
//Object where we store a fact and its details(id,category)
public class FavouritesModel {

    private int id;
    int category;
    String fact;

    FavouritesModel(){

    }

    FavouritesModel(String fact){
        this.fact = fact;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

}
