package com.example.ch11progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.net.IpSecManager;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private static final int PROGRESS = 0x1;
    private ProgressBar mProgress;
    private int mProgressStatus = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar)findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {//작업 스레드가 무명의 클래스로 정의되었다.
                while(mProgressStatus < 100){
                    try{
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e){

                    }
                    mProgressStatus = i++;

                    mProgress.post(new Runnable() {//post메소드를 이용해서 스레드를 등록하였다.
                        //post함수는 DATA를 통신할 때, 사용하는 함수입니다.
                        //ui를 업데이트 하는 Runnable 객체를 전송합니다
                        @Override
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();
    }
}
