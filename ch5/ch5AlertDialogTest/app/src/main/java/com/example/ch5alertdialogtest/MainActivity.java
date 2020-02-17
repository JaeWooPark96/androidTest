package com.example.ch5alertdialogtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //버튼이 클릭되면 호출되도록 해주었습니다.
    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);//대화상자 빌더 객체 생성
        alertDialogBuilder.setMessage("결제하시겠습니까?");//대화상자 메세지
        alertDialogBuilder.setPositiveButton("yes",//yes클릭 했을 때
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//해당 토스트 메세지 출력
                        Toast.makeText(MainActivity.this, "결제가 완료되었습니다.",
                                Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No",//No클릭 했을 때
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//해당 토스트 메세지 출력
                        Toast.makeText(MainActivity.this, "결제가 취소되었습니다.",
                                Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();//대화상자를 생성해주었습니다.
        alertDialog.show();//대화상자를 보여주었습니다.
    }
}
