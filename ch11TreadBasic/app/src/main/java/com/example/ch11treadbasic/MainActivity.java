package com.example.ch11treadbasic;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WorkerThread w;
    boolean running = true;

    class WorkerThread extends Thread{
        public void run() {//스레드에서 돌아갈 코드
            int i = 0;
            for (i = 0; i < 20 && running; i++) {//1초마다 정수를 증가
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                }
                Log.v("THREAD", "time=" + i);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStart(){//스레드 생성, 시작
        super.onStart();
        w = new WorkerThread();
        running = true;
        w.start();
    }

    @Override
    public void onStop(){//Activity가 사용자에게 더 이상 표시되지 않으면 중단됨 상태에 들어가고, 시스템은 onStop() 콜백을 호출합니다.
        // 이는 예를 들어 새로 시작된 Activity가 화면 전체를 차지할 경우에 적용됩니다.
        // 시스템은 Activity의 실행이 완료되어 종료될 시점에 onStop()을 호출할 수도 있습니다
        super.onStop();
        running = false;
    }

}
