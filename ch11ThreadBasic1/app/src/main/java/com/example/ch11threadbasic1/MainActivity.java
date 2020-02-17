package com.example.ch11threadbasic1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CursorTreeAdapter;

public class MainActivity extends AppCompatActivity {
    Thread w;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){
        super.onStart();
        w = new Thread(new Runnable() {//익명의 클래스를 이용해서 만들어 주었습니다.
            @Override
            public void run() {
                int i = 0;
                for (i = 0; i < 20 && running; i++) {//1초마다 정수를 증가
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    Log.v("THREAD", "time=" + i);
                }
            }
        });
        running = true;
        w.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        running = false;
    }
}
