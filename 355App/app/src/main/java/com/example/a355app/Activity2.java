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

    //this method opens up the MainActivity scene which is the filters page
    public void openMainActivity(View view){
        Intent Mainintent = new Intent(this, MainActivity.class);
        startActivity(Mainintent);
    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivity3(View view){
        Intent act3intent = new Intent(this, Activity3.class);
        startActivity(act3intent);
    }
}