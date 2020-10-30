package com.example.a355app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    //Restaurant object: reference Class java file to see arguments required
    Restaurant placeID = new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    //this method opens up the Activity3 scene which is the tips page
    public void openActivity3(View view) {
        Intent act3intent = new Intent(this, Activity3.class);
        startActivity(act3intent);
    }

    //this method opens up the Activity4 scene which is the roll page
    public void openActivity4(View view) {
        Intent act4intent = new Intent(this, Activity4.class);
        startActivity(act4intent);
    }

    //This method opens up popup for type of food button
    public void openPopUpFoodBtn(View view) {
        Intent TypeFoodBtn = new Intent(getApplicationContext(), PopUpFoodBtnActivity.class);
        startActivity(TypeFoodBtn);
    }

    //junit test required for 10/30/2020 deliverable.
    // needs some tweaking
    public static String costOfRestaurant(){
        String cost = "$";
        return cost;
    }

}