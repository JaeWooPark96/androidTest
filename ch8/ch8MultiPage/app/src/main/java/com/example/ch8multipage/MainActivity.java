package com.example.ch8multipage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //introduce버튼이 눌릴 때의 리스너
    public void introduceListner(View target){
        Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
        startActivity(intent);
    }

    //setting버튼이 눌릴 때의 리스너
    public void settingListner(View target){
        Intent intent = new Intent(getApplicationContext(), SetupActivity.class);
        startActivity(intent);
    }

    //start버튼이 눌릴 때의 리스너
    public void startListner(View target){
        Intent intent = new Intent(getApplicationContext(), StartActivity.class);
        startActivity(intent);
    }
}
