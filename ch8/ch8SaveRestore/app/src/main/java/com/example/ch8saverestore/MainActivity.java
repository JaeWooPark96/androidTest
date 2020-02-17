package com.example.ch8saverestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1, button2;
    TextView text;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.currentCount);

        //증가 버튼을 누르면, count가 증가하도록 해주었습니다.
        button1 = (Button)findViewById(R.id.increase);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                text.setText("현재 개수=" + count);
            }
        });

        //감소 버튼을 누르면, count가 감소하도록 해주었습니다.
        button2 = (Button)findViewById(R.id.decrease);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                text.setText("현재 개수=" + count);
            }
        });

        //savedInstanceState != null일 때, 저장된 값을 추출한 후에 텍스트 뷰의 내용을 이 값으로 변경합니다.
        if (savedInstanceState != null){
            count = savedInstanceState.getInt("count");
            text.setText("현재 개수=" + count);
        }
    }

    //Bundle객체 outState에, 정수 값인 count를 저장하였습니다.
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }
}
