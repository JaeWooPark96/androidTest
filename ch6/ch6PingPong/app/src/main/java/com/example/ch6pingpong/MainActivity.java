package com.example.ch6pingpong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MySurfaceView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = new MySurfaceView(this);
        setContentView(view);
    }

    //Activity 버튼 같은 거
    @Override
    protected void onPause(){//onPause() 함수는 Activity 위에 다른 Activity 가 올라오거나 하여 focus 를 잃었을 때 호출됨
        super.onPause();
    }

    protected void onSaveInstanceState(Bundle outState){// 메소드를 이용하면 Activity가 종료될 때 데이터를 저장할 수 있습니다.
        super.onSaveInstanceState(outState);
    }
}
