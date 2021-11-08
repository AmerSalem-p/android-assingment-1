package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String NAME = "NAME";
    private static final String PASS = "PASS";
    private static final String FLAG = "FLAG";

    private EditText edtName;
    private EditText edtPass;
    private CheckBox box;
    private SharedPreferences pref;
    private SharedPreferences.Editor edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        setUpSharedPreference();
        checkPreference();

    }

    private void setUpSharedPreference(){
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        edt = pref.edit();
    }

    private void setUpViews(){

        edtName = findViewById(R.id.username);
        edtPass = findViewById(R.id.password);
        box = findViewById(R.id.checkbox);

    }


    private void checkPreference(){

        boolean flag = pref.getBoolean(FLAG,false);

        if(flag){
            String name = pref.getString(NAME,"");
            String password = pref.getString(PASS,"");
            edtName.setText(name);
            edtPass.setText(password);
            box.setChecked(true);
        }

    }

    public void onClick_login(View view){

        String name = edtName.getText().toString();
        String password = edtPass.getText().toString();

        if(box.isChecked()){

            edt.putString(NAME,name);
            edt.putString(PASS,password);
            edt.putBoolean(FLAG,true);
            edt.commit();

        }

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }




}