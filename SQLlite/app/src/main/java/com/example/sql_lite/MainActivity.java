package com.example.sql_lite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase mydatabase = openOrCreateDatabase("exampleDatabase",MODE_PRIVATE,null);
        editText = findViewById(R.id.egData);
        String val = editText.getText().toString();
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS checkvalues(Username VARCHAR);");
        mydatabase.execSQL("INSERT INTO checkvalues VALUES('admin');");
        Cursor resultSet = mydatabase.rawQuery("Select * from TutorialsPoint",null);
        resultSet.moveToFirst();
        String username = resultSet.getString(0);
        Toast.makeText(this, ""+username, Toast.LENGTH_SHORT).show();


    }
}