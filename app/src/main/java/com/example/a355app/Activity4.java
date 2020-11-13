package com.example.a355app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        String PriceString = getString(Activity2.Price_Text);
        String StyleString = getString(Activity2.Style_Text);
        String GroupString = getString(Activity2.Group_Text);
        String FoodString = getString(Activity2.Food_Text);


        TextView Price = (TextView) findViewById(R.id.PriceSelection);
        TextView Style = (TextView) findViewById(R.id.StyleSelection);
        TextView Group = (TextView) findViewById(R.id.GroupSelection);
        TextView Food = (TextView) findViewById(R.id.FoodSelection);


        Price.setText(PriceString);
        Style.setText(StyleString);
        Group.setText(GroupString);
        //HARDCODED FOR AMERICAN IN FOODTYPE
        Food.setText("AMERICAN");

        Button mapButton = (Button) findViewById(R.id.button16);
        Uri address = Uri.parse("geo:0,0 ?q=Canes+VCU");
        final Intent  openMaps = new Intent(Intent.ACTION_VIEW, address);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(openMaps);
            }
        });


        try{
            String FinalString = getString(processRestaurants(Activity2.Price_Text));
            
            /// PULL THESE TWO OUT AND HARD CODE TEXT IN FINAL.SETTEXT(); METHOD TO SEE WHERE ISSUES LIE ///
            TextView Final = (TextView) findViewById(R.id.FinalSelection);
            Final.setText(FinalString);
            ////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("RESTAURANTS WERE READ FROM LIST! <----");
        }
        catch(FileNotFoundException ex){
            System.out.println("THE RESTAURANTS.TXT FILE WAS NOT FOUND. PLEASE UPDATE THIS ISSUE <----");
        }



    }

    //////////// method made for Testing /////////////////////////
    public static String getPrice(){
        return Activity2.Price_Text;
    }
    //////////////////////////////////////////////////////////////

    private String getString(String price_text) {
        return getIntent().getStringExtra(price_text);
    }

    //this method opens up the Activity Main scene which is the main page
    public void openActivityMain(View view){
        Intent actMainintent = new Intent(this, MainActivity.class);
        startActivity(actMainintent);
    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivity2(View view){
        Intent act2intent = new Intent(this, Activity2.class);
        startActivity(act2intent);
    }

    //this method opens up the Activity3 scene which is the tips page
    public void openActivity3(View view){
        Intent act3intent = new Intent(this, Activity3.class);
        startActivity(act3intent);
    }



    public static String processRestaurants(String cost)throws FileNotFoundException {


        File text = new File("src/restaurants.txt");
        Scanner scandoc = new Scanner(text);
        ArrayList<Restaurant> list = new ArrayList<>();
        int arraySize = 0;


        while(scandoc.hasNext()){

            String wholeLine = scandoc.nextLine();
            String[] tokens = wholeLine.split(",");

            Restaurant place = new Restaurant();
            place.setCost(tokens[0]);
            place.setName(tokens[1]);
            place.setTypeOfFood(tokens[2]);

            list.add(place);

            arraySize++;


        }

        int breakValue = -1;
        int firstIndex = 0, lastIndex = 0;
        for(int i = 0 ; i < arraySize; i++){

            if(cost.equals(list.get(i).getCost()) && breakValue < 0){
                firstIndex = i;
                breakValue++;
                lastIndex = firstIndex;
                while(list.get(lastIndex).getCost().equals(cost)){
                    System.out.println(list.get(lastIndex).getName());
                    if(lastIndex == arraySize-1){
                        break;
                    }
                    lastIndex++;
                }
                if(!(cost.equals("$$$"))){
                    lastIndex--;
                }
                else{
                    lastIndex++;
                }

                break;
            }


        }

        System.out.println("Values of " + cost + " in list are from " + firstIndex + " and " + lastIndex);
        String nameOfPlace = (list.get(lastIndex/2).getName());

        return "nameOfPlace";

    }


}