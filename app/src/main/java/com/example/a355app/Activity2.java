package com.example.a355app;

import android.content.Intent;

import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    public static final String Price_Text = "com.example.355App.Price_Text";
    public static final String Style_Text = "com.exaple.355App.Style_Text";
    public static final String Group_Text = "com.example.355App.Group_Text";
    public static final String Food_Text = "com.example.355App.Food_Text";

    String Price = "None Selected";
    String Style = "None Selected";
    String Group = "None Selected";
    String Food = "None Selected";

    //Restaurant object: reference Class java file to see arguments required
    Restaurant placeID = new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final Button Button$ = (Button) findViewById(R.id.button3);
        final Button Button$$ = (Button) findViewById(R.id.button4);
        final Button Button$$$ = (Button) findViewById(R.id.button5);

        Button$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$";
                Button$.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Button$$.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Button$$$.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        Button$$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$$";
                Button$$.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Button$.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Button$$$.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        Button$$$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$$$";
                Button$$$.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Button$.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Button$$.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        final Button Style1 = (Button) findViewById(R.id.button6);
        final Button Style2 = (Button) findViewById(R.id.button7);
        final Button Style3 = (Button) findViewById(R.id.button11);

        Style1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Delivery";
                Style1.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Style2.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Style3.setBackground(getResources().getDrawable(R.drawable.unselected_button));

            }
        });

        Style2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Takeout";
                Style2.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Style1.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Style3.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        Style3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Dine In";
                Style3.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Style1.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Style2.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        final Button Group1 = (Button) findViewById(R.id.button8);
        final Button Group2 = (Button) findViewById(R.id.button10);
        final Button Group3 = (Button) findViewById(R.id.button9);

        Group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Solo";
                Group1.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Group2.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Group3.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        Group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Pair";
                Group2.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Group1.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Group3.setBackground(getResources().getDrawable(R.drawable.unselected_button));
            }
        });

        Group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Group";
                Group3.setBackground(getResources().getDrawable(R.drawable.selected_buton));
                Group1.setBackground(getResources().getDrawable(R.drawable.unselected_button));
                Group2.setBackground(getResources().getDrawable(R.drawable.unselected_button));
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
        act4intent.putExtra(Food_Text, Food);
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