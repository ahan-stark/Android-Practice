package com.example.recylerview_contact;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Contact o1 = new Contact(1, "8521479", "Arya Stark");
    Contact o2 = new Contact(1, "7412563", "Sansa Stark");
    Contact o3 = new Contact(1, "9874562", "Jon Snow");
    Contact o4 = new Contact(1, "8794651", "Daenerys Targaryen ");
    Contact o5 = new Contact(1, "9856324", "Robb Stark");
    Contact o6 = new Contact(1, "8794562", "Bran Stark");
    Contact o7 = new Contact(1, "7894562", "Khal Drogo");
    Contact o8 = new Contact(1, "8523697", "Tyrion Lannister");
    Contact o9 = new Contact(1, "7894562", "Jorah Mormont");

    Contact [] contacts = {o1, o2, o3, o4, o5, o6, o7, o8, o9};
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapter ad = new CustomAdapter(contacts);
        recyclerView.setAdapter(ad);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}