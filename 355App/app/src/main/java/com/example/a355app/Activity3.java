package com.example.a355app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivityMain(View view){
        Intent Mainintent = new Intent(this, MainActivity.class);
        startActivity(Mainintent);
    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivity2(View view){
        Intent act2intent = new Intent(this, Activity2.class);
        startActivity(act2intent);
    }
}