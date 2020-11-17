package com.example.a355app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity2 extends AppCompatActivity {

    public static final String Price_Text = "com.example.355App.Price_Text";
    public static final String Style_Text = "com.exaple.355App.Style_Text";
    public static final String Group_Text = "com.example.355App.Group_Text";
    public static final String Zip_Text = "com.example.355App.Zip_Text";
    public static final String Final_Text = "com.example.355App.Final_Text";
    private static String cost;

    String Price = "None Selected";
    String Style = "None Selected";
    String Group = "None Selected";
    String Zip = "None Entered";
    String Final = "None Selected";

    //Restaurant object: reference Class java file to see arguments required
    Restaurant placeID = new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final EditText zip = (EditText) findViewById(R.id.ZipCode);
        final Button Button$ = (Button) findViewById(R.id.button3);
        final Button Button$$ = (Button) findViewById(R.id.button4);
        final Button Button$$$ = (Button) findViewById(R.id.button5);

        Button$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$";
                Button$.setBackground(getResources().getDrawable(R.drawable.selectedbricksolo));
                Button$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
                Button$$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
            }
        });

        Button$$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$$";
                Button$$.setBackground(getResources().getDrawable(R.drawable.selectedbricksolo));
                Button$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
                Button$$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
            }
        });

        Button$$$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$$$";
                Button$$$.setBackground(getResources().getDrawable(R.drawable.selectedbricksolo));
                Button$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
                Button$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
            }
        });


        final Button Style1 = (Button) findViewById(R.id.button6);
        final Button Style2 = (Button) findViewById(R.id.button7);
        final Button Style3 = (Button) findViewById(R.id.button11);

        Style1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Delivery";
                Style1.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Style2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Style3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));

            }
        });

        Style2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Takeout";
                Style2.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Style1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Style3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
            }
        });

        Style3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Dine In";
                Style3.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Style1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Style2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
            }
        });


        final Button Group1 = (Button) findViewById(R.id.button8);
        final Button Group2 = (Button) findViewById(R.id.button10);
        final Button Group3 = (Button) findViewById(R.id.button9);

        Group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Solo";
                Group1.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Group2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Group3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
            }
        });

        Group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Pair";
                Group2.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Group1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Group3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
            }
        });

        Group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Group";
                Group3.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Group1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Group2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
            }
        });




    }

    //this method opens up the Activity3 scene which is the tips page
    public void openActivity3(View view) {
        Intent act3intent = new Intent(this, Activity3.class);
        startActivity(act3intent);
    }

    //this method opens up the Activity4 scene which is the roll page
    public void openActivity4(View view) {
        Intent act4intent = new Intent(this, Activity4.class);
        act4intent.putExtra(Price_Text, Price);
        act4intent.putExtra(Style_Text, Style);
        act4intent.putExtra(Group_Text, Group);
        EditText zip = (EditText) findViewById(R.id.ZipCode);
        Zip = zip.getText().toString();
        act4intent.putExtra(Zip_Text, Zip);
        act4intent.putExtra(Final_Text, Final);
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