package com.example.a355app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable coinGlareAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //This code controls the glare animation
//        ImageView coinGlare = (ImageView) findViewById(R.id.coinGlare);
//        coinGlare.setBackgroundResource(R.drawable.coin8bit_final);
//        coinGlareAnimation = (AnimationDrawable) coinGlare.getBackground();

    }

//    //This method starts the animation upon opening
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus){
//        super.onWindowFocusChanged(hasFocus);
//        coinGlareAnimation.start();
//
//    }

    //this method opens up the Activity2 scene which is the filters page
    public void openActivity2(View view){
        Intent act2intent = new Intent(this, Activity2.class);
        startActivity(act2intent);
    }

    //this method opens up the Activity3 scene which is the filters page
    public void openActivity3(View view){
        Intent act3intent = new Intent(this, Activity3.class);
        startActivity(act3intent);
    }

}