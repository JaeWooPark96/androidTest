package com.example.ch7progressbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.drm.ProcessedData;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = new ProgressDialog(this);//ProgressDialog 생성, progress가 가리키도록 해주었습니다.
    }

    public void start(View view){
        progress.setCancelable(true);// Dialog 생성시 배경화면 어둡게 하지 않기 mDialog.
        progress.setMessage("네트워크에서 다운로드 중입니다.");//메세지 출력
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// ProgressDialog의 Style를 수평으로 설정합니다.
        progress.setProgress(0);//메소드는 정수값을 받아 프로그레스바의 현재값으로 설정합니다.
        progress.setMax(100);//progress bar의 최대치를 설정
        progress.show();//progress bar 를 보여주었습니다.

        //하나의 스레드에서 ui를 참조하려면 핸들러가 필요합니다.
        final Thread t = new Thread(){
            @Override
            public void run(){
                //처음 시간을 0으로 하고,
                //점차 time을 증가시켜 점점 100에 가까이 가도록 해주었습니다.
                //ex) 0% -> 5% -> 10% .... -> 95% -> 100%
                int time = 0;
                while(time < 100){
                    try{
                        sleep(200);
                        time += 5;
                        progress.setProgress(time);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
