package com.example.ch4ratingbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RatingBar ratingBar = (RatingBar)//해당 RatingBar를 id로 찾아주었습니다.
                findViewById(R.id.ratingBar);

        //새로 점수를 입력했을 때 출력되는 리스너를 만들어 주었습니다. 여기 있는 건 익명의 클래스로 만들어주었습니다.
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(), "New Rating: " + rating,//변화된 점수를 토스트 메세지로 출력하도록 해주었습니다.
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
