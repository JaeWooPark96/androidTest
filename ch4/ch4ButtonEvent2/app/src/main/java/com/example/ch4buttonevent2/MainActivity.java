package com.example.ch4buttonevent2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);//해당 아이디의 버튼을 찾아주었습니다.

        button.setOnClickListener(new View.OnClickListener() {//"익명의 클래스"로 리스너를 작성해주었습니다.
            public void onClick(View v){

                Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
