package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  String[] questions = {"java is a person?","java was introduced in 1350?","java was created using python?","java has abstract classes?","java supports interface?"};
    private boolean[] answers = {false,false,false,true,true};
    private int score = 0;
    Button yes;
    Button no;
    TextView question;

    private int index =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.textView);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // if array goes out of bound
            if(index <= questions.length-1){
            // if you have given correct answer
                if(answers[index] == true){
                    score++;
                }
                 // go to next question
                index++;
                if(index <= questions.length-1){
                    question.setText(questions[index]);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "your score is "+score, Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
            }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // if array goes out of bound
                if(index <= questions.length-1){
            // if you have given correct answer
                    if(answers[index] == false){
                        score++;
                    }
                    // go to next question
                    index++;
                    if(index <= questions.length-1){
                        question.setText(questions[index]);
                    }
                    else 
                    {
                        Toast.makeText(MainActivity.this, "your score is "+score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}