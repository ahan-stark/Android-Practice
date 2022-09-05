package com.example.form;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.form.database.AppDatabase;
import com.example.form.entity.User;

public class MainActivity extends AppCompatActivity {
    EditText name, age;
    Button button, viewData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        button = findViewById(R.id.button);
        viewData = findViewById(R.id.viewAll);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                int userage = Integer.parseInt(age.getText().toString());

                AsyncTask.execute(() -> {
                    AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                            AppDatabase.class, "user-database").build();
                    db.userDao().insertAll(new User(username, userage));
                });

            }
        });
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewData.class);
                startActivity(intent);
            }
        });

    }
}