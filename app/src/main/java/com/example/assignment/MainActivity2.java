package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.assignment.model.Info;

public class MainActivity2 extends AppCompatActivity {
    private EditText weight;
    private EditText height;
    private EditText age;
    private Spinner gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        weight = findViewById(R.id.weight);
        height= findViewById(R.id.height);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
    }


    public void btn_Next(View view){



        String str1="";

        double temp1 = Double.parseDouble(weight.getText().toString());
        double temp2 = Double.parseDouble(height.getText().toString());
        double bmi = temp1/(Math.pow(temp2,2));

        String ageTemp = age.getText().toString();
        String genderTemp = gender.getSelectedItem().toString();


        String str2 = "";

        if(bmi < 18.5) {
            str1 = "You are under wight";
            str2= "BMI : "+String.format("%.2f", bmi)+"\ngoal : 18.5"+" \nSee weightGain workouts";
        }
        else if (bmi>=18.5 && bmi<24.9) {
            str1 = "your weight is normal";
            str2 = "BMI : "+String.format("%.2f", bmi)+"\nBMI good";
        }
        else {
            str1 = "you are overweight";
            str2 = "BMI : "+String.format("%.2f", bmi)+"\ngoal : 24.8\nSee WeightLost workouts";
        }

        String temp = "Your age : " +ageTemp+"  ,Your Gender : "+genderTemp;

        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("data1", str1);
        intent.putExtra("data2", str2);
        Info info = new Info(temp1,temp2,Integer.parseInt(age.getText().toString()),genderTemp);
        intent.putExtra("data3",info);


        startActivity(intent);
    }





}