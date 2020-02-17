package com.example.ch8lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    //onCreate함수는 반드시 있어야 됨. 초기화를 해줘야 하기 때문.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//사용자 인터페이스 화면을 설정
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.i("LifeCycle", "onStart() 호출");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("LifeCycle", "onResume() 호출");
    }

    @Override
    public void onPause(){//사용자가 액티비티를 떠날 때 호출, 액티비티를 떠나도 저장해야 되는 것이 있다면, 저장하고 처리하기 위해서 사용한다.
        super.onPause();
        Log.i("LifeCycle", "onPause() 호출");
    }

    @Override
    public void onStop(){//액티비티가 정지되기 직전에 호출되는 함수
        super.onStop();
        Log.i("LifeCycle", "onStop() 호출");
    }

    @Override
    public void onDestroy(){//액티비티가 제거되기 직전에 호출되는 함수
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy() 호출");
    }
}
