package com.example.simpleinserttodb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.takeinputNum);
        button = findViewById(R.id.button);
        dbHandler = new DBHandler(MainActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numfromUser = (editText.getText().toString());
                int numfromuserinINT = Integer.parseInt(numfromUser);
                if(numfromUser==""){
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
                dbHandler.addNumbers(numfromuserinINT);
                Toast.makeText(MainActivity.this, "Successfully Inserted to Database", Toast.LENGTH_SHORT).show();
                editText.setText("");
            }

        });
    }
}