package com.example.ch4button1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class MyListenerClass implements View.OnClickListener {//MyListenerClass 내부 클래스를 정의해주었습니다.
        public void onClick(View v){//OnClickListener 인터페이스를 구현하는 클래스로서,
            // 클릭 이벤트가 발생하면, 호출되는 onClick()함수만 가지고 있다.
            Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);//해당 아이디의 버튼을 찾아주었습니다.

        MyListenerClass buttonListener = new MyListenerClass();//해당 리스너 클래스의 객체를 생성
        button.setOnClickListener(buttonListener);//해당 리스너를 등록해주었습니다.
    }
}
