package com.example.ch11asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    private int mProgressStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgress = (ProgressBar)findViewById(R.id.progressBar);
        Button button = (Button)findViewById(R.id.counterTrigger);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Async 스레드를 시작한다.
                new CounterTask().execute(0);//CounterTask 실행
            }
        });
    }

    class CounterTask extends AsyncTask<Integer,Integer,Integer>{
        protected void onPreExecute(){//Background 작업 시작전에 UI 작업을 진행 한다.

        }

        //Background 작업을 진행 한다.
        protected Integer doInBackground(Integer...value){//Integer...value는,가변 인수를 의미한다.

            //백그라운드에서 실행된다.
            while(mProgressStatus < 100){
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                }
                mProgressStatus++;
                publishProgress(mProgressStatus);
            }

            return mProgressStatus;
        }

        protected void onProgressUpdate(Integer...value){//프로그레스 바를 업데이트 한다.
            mProgress.setProgress(mProgressStatus);
        }

        protected void onPostExecute(Integer result){//Background 작업이 끝난 후 UI 작업을 진행 한다.
            mProgress.setProgress(mProgressStatus);
        }
    }
}
