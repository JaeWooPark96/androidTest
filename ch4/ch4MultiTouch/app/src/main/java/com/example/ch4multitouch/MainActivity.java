package com.example.ch4multitouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MultiTouchView(this, null));//우리가 만들어준 MultiTouchView를 ContentView로 해주었습니다.
    }
}
