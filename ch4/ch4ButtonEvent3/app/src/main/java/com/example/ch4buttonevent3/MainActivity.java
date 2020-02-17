package com.example.ch4buttonevent3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {//MainActivity클래스에 View.OnClickListener 인터페이스를 구현하겠다.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);//OnClickListener를 현제 MainActivity가 처리하겠다고 등록한 것
    }

    public void onClick(View v){//버튼이 클릭되면, 이 메소드가 호출됩니다.
        Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
    }
}
