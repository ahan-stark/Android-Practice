package com.example.uidesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText edtTxtname, edtEmail, edtPassword, editPassrepeat;
    private Button btnpickimage, btnregister;
    private TextView txtwarnName, txtwarnEmail, txtwarnPassword, txtwarnPassRepeat;
    private Spinner countries;
    private RadioGroup rGender;
    private CheckBox agreementcheck;
    private ConstraintLayout parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initviews();
        btnpickimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "finish", Toast.LENGTH_SHORT).show();
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });
    }
    private void initRegister(){
        Log.d(TAG,"initRegister: Started");
        if (validateData()){
            if (agreementcheck.isChecked()){
                showsnackbar();
            }
            else {
                Toast.makeText(this, "you need to agree to the agreement", Toast.LENGTH_SHORT).show();
            }

        }
    }
    private void showsnackbar(){
        Log.d(TAG,"showsnackbar: started");
        txtwarnName.setVisibility(View.GONE);
        txtwarnEmail.setVisibility(View.GONE);
        txtwarnPassword.setVisibility(View.GONE);
        txtwarnPassRepeat.setVisibility(View.GONE);
        String name = edtTxtname.getText().toString();
        String email= edtEmail.getText().toString();
        String country = countries.getSelectedItem().toString();
        String gender = "";
        switch (rGender.getCheckedRadioButtonId()){
            case R.id.male:
                gender="male";
                break;
            case R.id.female:
                gender="female";
                break;
            case R.id.other:
                gender="other";
                break;
            default:
                gender="unknown";
                break;
        }
        String snacktext = "Name"+ name +"\n"+
                "Email"+ email +"\n"+
                "Gender"+ gender + "\n"+
                "Country"+ country;
        Log.d(TAG,"showsnackBar: Snack Bar Text: "+snacktext);
        Snackbar.make(parent,"user registered",Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtTxtname.setText("");
                        edtEmail.setText("");
                        edtPassword.setText("");
                        editPassrepeat.setText("");

                    }
                }).show();
    }

    private boolean validateData() {
        Log.d(TAG, "validateData: started");
        if (edtTxtname.getText().toString().equals("")) {
            txtwarnName.setVisibility(View.VISIBLE);
            txtwarnName.setText("enter your name");
            return false;
        }
        if (edtEmail.getText().toString().equals("")) {
            txtwarnEmail.setVisibility(View.VISIBLE);
            txtwarnEmail.setText("enter your email");
            return false;
        }
        if (edtPassword.getText().toString().equals("")) {
            txtwarnPassword.setVisibility(View.VISIBLE);
            txtwarnPassword.setText("enter the password");
            return false;
        }
        if (editPassrepeat.getText().toString().equals("")) {

            txtwarnPassRepeat.setVisibility(View.VISIBLE);
            txtwarnPassRepeat.setText("re-enter the password");
            return false;
        }
        if (!edtPassword.getText().toString().equals(editPassrepeat.getText().toString())){
            txtwarnPassRepeat.setVisibility(View.VISIBLE);
            txtwarnPassRepeat.setText("password doesn't match");
            return false;
        }
        return true;
    }

    private void initviews(){
        Log.d(TAG,"initviews:Started");
        edtTxtname=findViewById(R.id.editTextName);
        edtEmail= findViewById(R.id.edittextemail);
        edtPassword= findViewById(R.id.Password);
        editPassrepeat=findViewById(R.id.passwordrepeat);
        btnpickimage=findViewById(R.id.btnimage);
        btnregister= findViewById(R.id.btnregister);
        txtwarnName=findViewById(R.id.txtwarnName);
        txtwarnEmail=findViewById(R.id.txtwarnEmail);
        txtwarnPassword=findViewById(R.id.txtwarnPassword);
        txtwarnPassRepeat=findViewById(R.id.txtwarnPasswordrepeat);
        countries=findViewById(R.id.spinnercountry);
        rGender=findViewById(R.id.rgGender);
        agreementcheck=findViewById(R.id.agreementcheck);
        parent=findViewById(R.id.parent);


    }
}