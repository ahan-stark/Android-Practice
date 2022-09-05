package com.example.sqlitedb_basicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DbHandler dbHandler = new DbHandler(this,"empdb",null,1);
        dbHandler.addEmployee(new Employee(1,"Ahan",33.33));
    //    dbHandler.getEmployee(1);
        dbHandler.close();

    }
}