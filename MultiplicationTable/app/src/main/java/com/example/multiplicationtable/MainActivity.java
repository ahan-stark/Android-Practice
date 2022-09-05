package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button btn;
    TextView txt;
    int ans=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edttext);
        btn = findViewById(R.id.btn);
        txt = findViewById(R.id.txtview);
        btn.setOnClickListener(this);
    }
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btn:
                StringBuffer buffer = new StringBuffer();
                int res;
                //take the input from the user
                String fs = editText.getText().toString();
                int n = Integer.parseInt(fs);
                for (int i = 1; i <= 10; i++) {
                    ans = (i * n);
                    buffer.append(n + " X " + i
                            + " = " + ans + "\n\n");
                }
                // set the buffer textview
                txt.setMovementMethod(new ScrollingMovementMethod());
                txt.setText(buffer);
                break;
        }
    }
}