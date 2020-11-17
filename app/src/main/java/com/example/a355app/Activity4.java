package com.example.a355app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;


public class Activity4 extends AppCompatActivity {

    private TextView FinalResult;
    private String FinalRestaurantName;
    private ArrayList<Restaurant> list = new ArrayList<>();
    private ArrayList<Integer> storedRandomInts = new ArrayList<>();
    private int lastNumber = -1;
    private String GlobalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        String PriceString = getString(Activity2.Price_Text);
        String StyleString = getString(Activity2.Style_Text);
        String GroupString = getString(Activity2.Group_Text);
        String ZipString = getString(Activity2.Zip_Text);


        TextView Price = (TextView) findViewById(R.id.PriceSelection);
        TextView Style = (TextView) findViewById(R.id.StyleSelection);
        TextView Group = (TextView) findViewById(R.id.GroupSelection);
        TextView Zip = (TextView) findViewById(R.id.ZipSelection);


        Price.setText(PriceString);
        Style.setText(StyleString);
        Group.setText(GroupString);
        //HARDCODED FOR AMERICAN IN FOODTYPE
        Zip.setText(ZipString);

        //calls the random food object cascade of methods calls
        FinalResult = (TextView) findViewById(R.id.FinalResult);
        GlobalPrice = PriceString;
        getBodyText();


        Button mapButton = (Button) findViewById(R.id.button16);
        Uri address = Uri.parse("geo:0,0 ?q=Raising_Canes+" + ZipString);
        final Intent openMaps = new Intent(Intent.ACTION_VIEW, address);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(openMaps);
            }
        });


        /*** TESTING **/
        //System.out.println("------> " + list.get(2).getName());
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


    public void getBodyText() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //converts our makeshift database into a String url
                String url="https://docs.google.com/document/d/e/2PACX-1vSSKMiZ9pAhMDyzzCu3U1v6SRjxd52SIlEZhy2kBZJLWYvtzPayWftNxZhpb5xVI2aDxa6lUx-VvSze/pub";

                // creates a Document object from the String url online
                // this is the Google Docs we created, the url present above is the published page NOT THE UPDATABLE VERSION
                Document onlineDoc = null;
                try {
                    onlineDoc = Jsoup.connect(url).get();
                } catch (IOException e) {
                    System.out.println("Something went wrong with the online document. Please address immediately!!!");
                }

                //takes the online Google Docs and turns the whole published page into a String Object
                String wholePublishedPage = onlineDoc.text();
                getLines(wholePublishedPage);
            }
        }).start();
    } // end getBodyText method


    public void getLines(String docBody){

        // dynamically sets the body to exactly the information needed; parsed from online
        docBody = docBody.substring(300, docBody.length()-38);

        String wholeLine = "";
        int i = 0;
        int arraySize = 0;

        for(i = 0; i < docBody.length(); i++){

            if(docBody.substring(i, i+1).equals(" ")){

                wholeLine = wholeLine.replaceAll("\\s", "");
                createArrayList(wholeLine);
                wholeLine = "";
                arraySize++;

            }
            wholeLine += docBody.substring(i,i+1);
        }// end for loop

        System.out.println("GLOBAL PRICE: ---->" + GlobalPrice);
        processRestaurants(GlobalPrice, arraySize);
    }// end getLines method


    public void createArrayList(String wholeLine){

        String[] tokens = wholeLine.split(",");

        Restaurant place = new Restaurant();
        place.setCost(tokens[0]);
        place.setName(tokens[1]);
        place.setTypeOfFood(tokens[2]);

        list.add(place);
    } // end createArrayList method


    public void processRestaurants(String cost, int arraySize){

        int breakValue = -1;
        int firstIndex = 0, lastIndex = 0;

        for(int i = 0 ; i < arraySize; i++){

            if(cost.equals(list.get(i).getCost()) && breakValue < 0){
                firstIndex = i;
                breakValue++;
                lastIndex = firstIndex;

                while(list.get(lastIndex).getCost().equals(cost)){
                    //System.out.println(list.get(lastIndex).getName());
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
        }// END FOR LOOP

        int randomRestaurant = (int) (Math.random() *(lastIndex - firstIndex) + firstIndex);
        checkRepeats(randomRestaurant, firstIndex, lastIndex);
    } // end processFile method

    public int randomRestaurant(int firstIndex, int lastIndex){
        return (int) (Math.random() *(lastIndex - firstIndex) + (firstIndex+1));
    }

    public void checkRepeats(int randomRestaurant, int firstIndex, int lastIndex){
        
        int i = 0;

        //System.out.println("WILL CLEAR AT SIZE: " + ((lastIndex - firstIndex) + 1));
        //System.out.println("LAST NUMBER STORED: "+ lastNumber);
        //System.out.println(firstIndex + " - " + lastIndex);
        if(storedRandomInts.size() == ((lastIndex - firstIndex)+1)){
            //System.out.println(" -------------------- CLEARED AT SIZE OF: ---> " + storedRandomInts.size());
            storedRandomInts.clear();
        }

        for(i = 0; i < storedRandomInts.size(); i++) {
            if (randomRestaurant == storedRandomInts.get(i) || randomRestaurant == lastNumber) {
                //System.out.println("ALREADY STORED:   --> " + storedRandomInts.get(i) + " " + list.get(randomRestaurant).getName() + "    ARRAY SIZE: "  + storedRandomInts.size());
                randomRestaurant = randomRestaurant(firstIndex, lastIndex);
                //System.out.println("reroll while loop: --> " + randomRestaurant + " " + list.get(randomRestaurant).getName());
                i = -1;
            }
        }
        
        //System.out.println("out while loop:   --> " + randomRestaurant + " " + list.get(randomRestaurant).getName());

        storedRandomInts.add(randomRestaurant);
        lastNumber = randomRestaurant;
        //System.out.println("ADDED THE NUMBER: --> " + randomRestaurant + " " + list.get(randomRestaurant).getName());
        FinalRestaurantName = list.get(randomRestaurant).getName();

        displayRestaurant();
    }

    public void displayRestaurant(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FinalResult.setText(FinalRestaurantName);
            }
        });

    }

}