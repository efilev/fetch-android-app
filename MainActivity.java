package com.example.fetchapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        userList = new ArrayList<>();

        // Retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // instance for interface
        APICall apiCall = retrofit.create(APICall.class);
        Call<List<User>> call = apiCall.getUsers();

        // Send request to web server
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(getApplicationContext(), "Successful response!", Toast.LENGTH_LONG).show();

                // Converts response data into List
                List<User> users = response.body();

                // Filter out null and blank names, add to new ArrayList
                for (User user : users) {
                    if (user.getName() != null && !user.getName().isEmpty()) {
                        userList.add(user);
                    } else {
                        continue;
                    }
                }

                sortIds(userList);
                DataIntoRecycler(userList);
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable throwable) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    // Sort by listId, then by name
    private void sortIds(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int res = Integer.valueOf(o1.getListId()).compareTo(o2.getListId());
                if (res != 0)
                    return res;
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    // Puts values into RecyclerView
    private void DataIntoRecycler(List<User> userList) {
        UserAdapter userAdapter = new UserAdapter(this, userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);
    }

}