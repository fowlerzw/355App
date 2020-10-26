package com.example.a355app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    //this method opens up the MainActivity scene which is the main page
    public void openMainActivity(View view){
        Intent Mainintent = new Intent(this, MainActivity.class);
        startActivity(Mainintent);
    }

    //this method opens up the Activity3 scene which is the tips page
    public void openActivity3(View view){
        Intent act3intent = new Intent(this, Activity3.class);
        startActivity(act3intent);
    }

    //this method opens up the Activity4 scene which is the roll page
    public void openActivity4(View view){
        Intent act4intent = new Intent(this, Activity4.class);
        startActivity(act4intent);
    }



//    /*** MADE BY JESUS ON 10/06/2020 ********************************************/
//    /**** NEED TO FIX THIS BUTTON; DOES NOT CALL ACT3, GOES BACK TO MAIN ACT ****/
//    //opens tips menu from Activity2 (TIPS MENU = ACTIVITY3
//    public void openActivity3(View view) {
//        Intent tipsIntent = new Intent(this, Activity3.class);
//        startActivity(tipsIntent);
//    }
//    /*** IF DELETED, NEED TO DELETE TIPS BUTTON ON ACT2.XML; ALL THE WAY AT THE BOTTOM *****/


}