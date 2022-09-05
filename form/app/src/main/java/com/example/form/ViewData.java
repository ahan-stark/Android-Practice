package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.form.database.AppDatabase;
import com.example.form.entity.User;

import java.util.List;

public class ViewData extends AppCompatActivity {
    TextView textViewToDis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        textViewToDis = findViewById(R.id.disData);
        AsyncTask.execute(() -> {
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "user-database").build();
           List<User> contents =  db.userDao().getAll();
            String finalVal = "";
            for (User user:
                 contents) {
                Log.d("checking",user.name+user.age);
                finalVal= finalVal + user.age + user.name;

            }
            textViewToDis.setText(finalVal);
        });

    }
}