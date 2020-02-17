package com.example.ch4customcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        VolumeControlView view = (VolumeControlView) findViewById(R.id.volume);
        view.setKnobListener(new VolumeControlView.KnobListener() {
            @Override
            public void onChanged(double angle) {
                float rating = ratingBar.getRating();
                if (angle > 0 && rating < 7.0){//오른쪽으로 회전
                    ratingBar.setRating(rating+1.0f);
                }
                else{//왼쪽으로 회전
                    ratingBar.setRating(rating-1.0f);
                }
            }
        });
    }
}