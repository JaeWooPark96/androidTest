package com.example.ch7ratingbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private TextView value;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetupRatingBar();
       // SetupButton();
    }

    public void SetupRatingBar(){
        //ratingBar를 가리키도록 해주었습니다.
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        //id로 TextView를 가리키도록 해주었습니다.
        value = (TextView)findViewById(R.id.value);

        //ratingBar가 바뀔 때 호출되는 이벤트 헨들러입니다.
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText(String.valueOf(rating));
            }
        });
    }

    //버튼이 눌렸을 때, 호출되는 이벤트 핸들러입니다.
    public void onClick(View v) {//버튼이 클릭될 때의 이벤트 헨들러를 구현해주었스빈다.
        Toast.makeText(getBaseContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
    }

   /* public void SetupButton(){
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        button = (Button)findViewById(R.id.bottom);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
            }
        });
    }*/
}
