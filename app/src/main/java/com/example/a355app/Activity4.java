package com.example.a355app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;


public class Activity4 extends AppCompatActivity {

    private TextView FinalResult;
    private String FinalRestaurantName;
    private ArrayList<Restaurant> list = new ArrayList<>();
    private ArrayList<Integer> storedRandomInts = new ArrayList<>();
    private int lastNumber = -1;
    private String GlobalPrice;
    private String GlobalZip;
    private Button mapButton;

    //for the reflip button to rerun the flipping gif
    GifImageView flippingGif;
    Button reflip;
    int flag = 0;

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
        Zip.setText(ZipString);

        //calls the random food object cascade of methods calls
        FinalResult = (TextView) findViewById(R.id.FinalResult);
        GlobalPrice = PriceString;
        GlobalZip = ZipString;
        getBodyText();

        mapButton = (Button) findViewById(R.id.button16);


        //For the reflip button to rerun flipping gif
        flippingGif = (GifImageView) findViewById(R.id.gifCoin2);
        reflip = (Button) findViewById(R.id.button15);

        reflip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){

                //call to reroll
                reroll(v);

                if (flag == 0) {
                    flippingGif.setImageResource(R.drawable.flippinggif_loop_once);
                    flag = 1;
                } else if (flag == 1) {
                    flippingGif.setImageResource(R.drawable.flippinggif_loop_once);
                    flag = 2;
                } else if (flag == 2) {
                    flippingGif.setImageResource(R.drawable.flippinggif_loop_once);
                    flag = 0;
                }
            }
        });
        //end the onClick for reflip gif
    }

    //this code is for the reflip button, it does not effect the functionality but I am going to keep it here for now to revisit later and do more research of its importance
    //Methods to reflip gif onClick
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    //end methods for reflip

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

        processRestaurants(GlobalPrice, arraySize);
    }// end getLines method


    public void createArrayList(String wholeLine){

        String[] tokens = wholeLine.split(",");

        Restaurant place = new Restaurant();
        place.setCost(tokens[0]);
        place.setName(tokens[1].replaceAll("_", " "));
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

        if(storedRandomInts.size() == ((lastIndex - firstIndex)+1)){
            storedRandomInts.clear();
        }

        for(i = 0; i < storedRandomInts.size(); i++) {
            if (randomRestaurant == storedRandomInts.get(i) || randomRestaurant == lastNumber) {
                randomRestaurant = randomRestaurant(firstIndex, lastIndex);
                i = -1;
            }
        }
        
        storedRandomInts.add(randomRestaurant);
        lastNumber = randomRestaurant;
        FinalRestaurantName = list.get(randomRestaurant).getName();

        displayRestaurant();
    }

    public void displayRestaurant(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FinalResult.setText(FinalRestaurantName);

                Uri address = Uri.parse("geo:0,0 ?q="+ FinalRestaurantName + "+" + GlobalZip);
                final Intent openMaps = new Intent(Intent.ACTION_VIEW, address);

                mapButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(openMaps);
                    }
                });

            }
        });
    }

    public void reroll(View view){
        getBodyText();
        System.out.println(list.get(1).getName());
    }

}