package com.example.ch8implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //버튼들을 클릭했을 때의 이벤트 리스너입니다.
    public void onClock(View view){
        Intent intent = null;//Intent로 화면이동과 데이터 전달을 합니다.

        switch (view.getId()){
            case R.id.web://웹브라우저 버튼 누르면 구글로 가도록
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com"));
                break;
            case R.id.call://전화걸기 누르면, 전화걸도록
                intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:(+82)12345678"));
                break;
            case R.id.map://지도보기 누르면 지도 나오도록
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:37.30,127.2?z=10"));
                break;
            case R.id.contact://연락처보기 누르면 연락처 나오도록
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("content://contacts/people/"));
                break;
        }

        //intent에 뭔가 저장되어 있으면, 그곳으로 이동하도록 해주었습니다.
        if(intent != null){
            startActivity(intent);
        }
    }
}
