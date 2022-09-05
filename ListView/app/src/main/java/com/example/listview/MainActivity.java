package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

        ListView listView;
        String content[]={"Virajpet","Gonikoppa","Madikeri","Kushalnagar","Mysore"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View lstvw = findViewById(R.id.list);
        ArrayAdapter<String> a;
        a = new ArrayAdapter<String>(this, R.layout.activity_main, content);
        listView.setAdapter(a);

    }
}