package com.example.ch8explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);//슈퍼클래스의 onCreate()호출
        setContentView(R.layout.layout1);//컨텐트 뷰를 R.layout.layout1로 해주었습니다.

        Button b = (Button)findViewById(R.id.Open);

        //버튼을 클릭하면, Activity2가 시작됩니다.
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //인텐트 객체 생성
                Intent intent = new Intent(Activity1.this, Activity2.class);
                startActivity(intent);//Activity 시작
            }
        });
    }
}
