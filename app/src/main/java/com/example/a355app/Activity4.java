package com.example.a355app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        String PriceString = getString(Activity2.Price_Text);
        String StyleString = getString(Activity2.Style_Text);

        TextView Price = (TextView) findViewById(R.id.PriceSelection);
        TextView Style = (TextView) findViewById(R.id.StyleSelection);

        Price.setText(PriceString);
        Style.setText(StyleString);
    }

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
}