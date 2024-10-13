package com.example.fetchapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter to convert data to RecyclerView
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private final Context mContext;
    private final List<User> usersList;

    public UserAdapter(Context mContext, List<User> usersList) {
        this.mContext = mContext;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.data_item, parent, false);
        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText("Id: " + usersList.get(position).getId());
        holder.listId.setText("List id: " + usersList.get(position).getListId());
        holder.name.setText("Name: " + usersList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView listId;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            listId = itemView.findViewById(R.id.listId);
            name = itemView.findViewById(R.id.name);
        }
    }
}
