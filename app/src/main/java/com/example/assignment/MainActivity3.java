package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment.model.athlete;
import com.google.gson.Gson;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.assignment.model.Info;

public class MainActivity3 extends AppCompatActivity {
    private TextView str1;
    private TextView str2;
    private TextView str3;
    private int sec = 0;
    private boolean runTime = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        checkInstance(savedInstanceState);
        Thread thread = new Thread(runTimer());
        thread.start();
        Intent intent = getIntent();

        str1 = findViewById(R.id.str1);
        str2 = findViewById(R.id.str2);
        str3 = findViewById(R.id.str3);
        String msg1 =  intent.getStringExtra("data1");
        String msg2 =  intent.getStringExtra("data2");
        Info info =  (Info)intent.getSerializableExtra("data3");

        str1.setText(msg1);
        str2.setText(msg2);
        str3.setText("Weight : "+info.getWeight()+" ,Height : "+info.getHeight()+" ,age :"+info.getAge()+" ,Gender :"+info.getGender());





    }

    public void btn_OnClickChest(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/fitness-exercise/best-chest-exercises"));
        startActivity(browser);

    }
    public void btn_OnClickBack(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/fitness/back-strengthening-muscles-posture#The-moves"));
        startActivity(browser);

    }
    public void btn_OnClickShoulders(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coachmag.co.uk/fitness/workouts/shoulder-workouts"));
        startActivity(browser);

    }
    public void btn_OnClickLegs(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/fitness/leg-workout"));
        startActivity(browser);

    }
    public void btn_OnClickAbs(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coachmag.co.uk/workouts/abs-workouts"));
        startActivity(browser);

    }
    public void btn_OnClickArms(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.menshealth.com/uk/building-muscle/a754655/16-best-exercises-for-bigger-arms/"));
        startActivity(browser);

    }
    public void btn_OnClickWeightLost(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/nutrition/best-exercise-for-weight-loss#TOC_TITLE_HDR_3"));
        startActivity(browser);

    }
    public void btn_OnClickWightGain(View view){

        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.healthline.com/health/exercise-to-gain-weight#exercises-for-women-and-men"));
        startActivity(browser);


    }
    public void onClick_athlete(View view){

        athlete[] a = new athlete[10];
        a[0] = new athlete("Arnold","Schwarzenegger");
        a[1] = new athlete("Flex","Wheeler");
        a[2] = new athlete("Ronnie","Coleman");
        a[3] = new athlete("Phil","Heath");
        a[4] = new athlete("Frank","Zane");
        a[5] = new athlete("Jay","Cutler");
        a[6] = new athlete("Lee","Haney");
        a[7] = new athlete("Franco","Columbu");
        a[8] = new athlete("Dexter","Jackson");
        a[9] = new athlete("Amer","Salem");



        Gson gson = new Gson();
        String temp = gson.toJson(a);

        Intent intent = new Intent(this, MainActivity4.class);
        intent.putExtra("athletes",temp);
        startActivity(intent);


    }

    private void checkInstance(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            sec = savedInstanceState.getInt("SECONDS");
            runTime = savedInstanceState.getBoolean("RUNNING");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("SECONDS", sec);
        outState.putBoolean("RUNNING", runTime);


    }
    public void Start(View view) {
        runTime = true;
    }

    public void Stop(View view) {
        runTime = false;
    }

    public void Reset(View view) {
        runTime = false;
        sec = 0;
    }

    public Runnable runTimer() {
        final TextView txtTime = findViewById(R.id.txtTime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = sec / 3600;
                int minutes = (sec % 3600) / 60;
                int secs = sec % 60;
                String time = hours + " : " + minutes + " : " + secs;
                txtTime.setText(time);
                if (runTime) {
                    sec++;
                }
                handler.postDelayed(this, 1000);

            }
        });
        return null;
    }




}