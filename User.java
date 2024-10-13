package com.example.fetchapplication;

import com.google.gson.annotations.SerializedName;

public class User {
    // data to parse
    private int id;
    private int listId;
    private String name;

    // Getters
    public int getId() {
        return id;
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }
}
