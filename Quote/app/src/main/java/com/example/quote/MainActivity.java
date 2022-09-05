package com.example.quote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //to generate random number
    Random random = new Random();
    TextView txt;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txtvw);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disquote();
            }
        });
        disquote();
    }
    public void disquote(){
    int randNum = random.nextInt((8+1)-1)+1;
    String randQuote = "";
    switch (randNum){
        case 1:
            randQuote = getString(R.string.quote1);
            break;
        case 2:
            randQuote = getString(R.string.quote2);
            break;
        case 3:
            randQuote = getString(R.string.quote3);
            break;
        case 4:
            randQuote = getString(R.string.quote4);
            break;
        case 5:
            randQuote = getString(R.string.quote5);
            break;
        case 6:
            randQuote = getString(R.string.quote6);
            break;
        case 7:
            randQuote = getString(R.string.quote7);
            break;
        case 8:
            randQuote = getString(R.string.quote8);
            break;

    }
    txt.setText(randQuote);
    }
}