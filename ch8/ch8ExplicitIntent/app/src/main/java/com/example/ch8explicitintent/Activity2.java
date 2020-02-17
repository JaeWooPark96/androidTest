package com.example.ch8explicitintent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);//컨텐트 뷰를 layout2로 해주었습니다.
        Button b = (Button)findViewById(R.id.Close);

        //버튼이 클릭되면, 현재 Activity를 종료하도록 해주었습니다.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
