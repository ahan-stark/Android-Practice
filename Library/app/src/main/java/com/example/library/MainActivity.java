package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnallbooks, btnalreadyRead, btnWantToread, btnCurrentlyreading, btnFav, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        btnallbooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initviews(){
        btnallbooks=findViewById(R.id.btnAllbooks);
        btnalreadyRead=findViewById(R.id.btnAlreadyRead);
        btnWantToread=findViewById((R.id.btnWantToRead));
        btnCurrentlyreading=findViewById(R.id.btnCurrentlyreading);
        btnFav=findViewById(R.id.btnfav);
        btnAbout=findViewById(R.id.btnAbout);
    }
}