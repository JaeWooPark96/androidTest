package com.example.ch6drawanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView rocketImage = (ImageView)findViewById(R.id.rocket_image);
        rocketImage.setBackgroundResource(R.drawable.rocket);
        rocketAnimation = (AnimationDrawable)rocketImage.getBackground();
    }


    public boolean onTouchEvent(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            rocketAnimation.start();
            return true;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //if (event.getAction() == MotionEvent.ACTION_DOWN){
            rocketAnimation.start();
           // return true;
       // }
    }
}
