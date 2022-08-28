package com.example.androidroomwithview.joke;

import com.google.gson.annotations.SerializedName;

public class JokeResponseModel {

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private JokeValueModel value;

    public String getType() {
        return type;
    }

    public JokeValueModel getValue() {
        return value;
    }
}
