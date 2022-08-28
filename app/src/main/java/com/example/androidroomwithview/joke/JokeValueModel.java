package com.example.androidroomwithview.joke;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JokeValueModel {

    @SerializedName("id")
    private int id;

    @SerializedName("joke")
    private String joke;

    @SerializedName("catgories")
    private ArrayList<String> categories;

    public int getId() {
        return id;
    }

    public String getJoke() {
        return joke;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
}
