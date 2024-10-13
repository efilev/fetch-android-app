package com.example.fetchapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {
    // Basic request of JSON
    @GET("hiring.json")
    Call<List<User>> getUsers();
}
