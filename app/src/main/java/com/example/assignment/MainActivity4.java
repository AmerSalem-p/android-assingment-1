package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.assignment.model.athlete;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.nio.channels.GatheringByteChannel;

public class MainActivity4 extends AppCompatActivity {

    private TextView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        list = findViewById(R.id.view);

        Gson gson = new Gson();
        String temp = getIntent().getStringExtra("athletes");
        athlete[] obj = gson.fromJson(temp, athlete[].class);

        String str = "";

        for(int i =0;i<obj.length;i++){

            str += " * " + obj[i].getFirstName() +" "+obj[i].getLastName() + ".\n";
        }

            list.setText(str);


    }
}