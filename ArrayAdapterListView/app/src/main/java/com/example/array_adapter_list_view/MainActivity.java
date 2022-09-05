package com.example.array_adapter_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String listitem[] = {"hey there!","how are you?","hope you are doing great!"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        // using built in array adapter
        ArrayAdapter arr = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,listitem);
        listView.setAdapter(arr);
    }
}