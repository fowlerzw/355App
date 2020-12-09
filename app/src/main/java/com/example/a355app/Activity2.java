package com.example.a355app;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import pl.droidsonroids.gif.GifImageView;

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
    Boolean selectedPrice = false, selectedStyle = false, selectedNumPeople = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


        final Button greyButton = findViewById(R.id.button14);
        final GifImageView gifCoin = findViewById(R.id.gifCoin);
        gifCoin.setVisibility(View.INVISIBLE);

        final EditText zip = (EditText) findViewById(R.id.ZipCode);

        final Button Button$ = (Button) findViewById(R.id.button3);
        final Button Button$$ = (Button) findViewById(R.id.button4);
        final Button Button$$$ = (Button) findViewById(R.id.button5);

        Button$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$";
                selectedPrice = true;
                Button$.setBackground(getResources().getDrawable(R.drawable.selectedbricksolo));
                Button$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
                Button$$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        Button$$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$$";
                selectedPrice = true;
                Button$$.setBackground(getResources().getDrawable(R.drawable.selectedbricksolo));
                Button$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
                Button$$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        Button$$$.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Price = "$$$";
                selectedPrice = true;
                Button$$$.setBackground(getResources().getDrawable(R.drawable.selectedbricksolo));
                Button$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));
                Button$$.setBackground(getResources().getDrawable(R.drawable.unselectedbricksolo));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });


        final Button Style1 = (Button) findViewById(R.id.button6);
        final Button Style2 = (Button) findViewById(R.id.button7);
        final Button Style3 = (Button) findViewById(R.id.button11);

        Style1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Delivery";
                selectedStyle = true;
                Style1.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Style2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Style3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        Style2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Takeout";
                selectedStyle = true;
                Style2.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Style1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Style3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        Style3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Style = "Dine In";
                selectedStyle = true;
                Style3.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Style1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Style2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });


        final Button Group1 = (Button) findViewById(R.id.button8);
        final Button Group2 = (Button) findViewById(R.id.button10);
        final Button Group3 = (Button) findViewById(R.id.button9);

        Group1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Solo";
                selectedNumPeople = true;
                Group1.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Group2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Group3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        Group2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Pair";
                selectedNumPeople = true;
                Group2.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Group1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Group3.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));

                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() ==5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        Group3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Group = "Group";
                selectedNumPeople = true;
                Group3.setBackground(getResources().getDrawable(R.drawable.selectedbrickpair));
                Group1.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));
                Group2.setBackground(getResources().getDrawable(R.drawable.unselectedbrickpair));


                if(selectedNumPeople && selectedPrice && selectedStyle && (zip.getText().toString().length() == 5)) {
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }
        });

        EditText ZipCode = (EditText) findViewById(R.id.ZipCode);
        ZipCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(selectedNumPeople && selectedPrice && selectedStyle && (s.length() == 4)){
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(selectedNumPeople && selectedPrice && selectedStyle && (s.length() == 5)){
                    greyButton.setVisibility(View.INVISIBLE);
                    gifCoin.setVisibility(View.VISIBLE);
                }
                else{
                    greyButton.setVisibility(View.VISIBLE);
                    gifCoin.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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

        if(selectedNumPeople && selectedPrice && selectedStyle && Zip.length() == 5){
            startActivity(act4intent);
        }
        else{
            System.out.println("TOAST GOES HERE BUT WORT WORK FOR SOME REASON");
            System.out.println("PLEASE SELECT ALL BLOCKS AND/OR ENTER A 5-DIGIT ZIP");
        }

    }

    //This method opens up popup for type of food button
//    public void openPopUpFoodBtn(View view) {
//        Intent TypeFoodBtn = new Intent(getApplicationContext(), PopUpFoodBtnActivity.class);
//        startActivity(TypeFoodBtn);
//    }

    //junit test required for 10/30/2020 deliverable.
    // needs some tweaking
    public static String costOfRestaurant(){
        String cost = "$";
        return cost;
    }

}