package com.example.androidroomwithview;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @ColumnInfo
    private String language;

    public Word(@NonNull String word) {
        this.mWord = word;
        this.language = "ENGLISH";
    }

    public String getWord(){return this.mWord;}
}
