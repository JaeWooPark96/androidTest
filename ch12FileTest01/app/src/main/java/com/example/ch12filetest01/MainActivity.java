package com.example.ch12filetest01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    String FILENAME = "text.txt";
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String state = Environment.getExternalStorageState();//미디어가 배출되는 동안 저장 상태를 받아주었습니다.
        if(state.equals(Environment.MEDIA_MOUNTED) == false){//외부 Storage 실패일 때
            Toast.makeText(this, "외부 스토리지 실패", Toast.LENGTH_SHORT).show();
        }

        edit = (EditText)findViewById(R.id.editText);
        Button readBtn = (Button)findViewById(R.id.read);
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null), FILENAME);//외부 공간으 파일 이름을 받아주었습니다.
                try{
                    InputStream is;
                    is = new FileInputStream(file);//외부 공간 파일을 읽기모드로 열어주었습니다.
                    byte[] buffer = new byte[is.available()];//버퍼
                    is.read(buffer);//버퍼에 입력 받아주었습니다.
                    edit.setText(new String(buffer));//버퍼 내용을 EditText에 저장해주었습니다.
                    is.close();//스트립을 닫아주었습니다.
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        Button writeBtn = (Button)findViewById(R.id.write);
        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = new File(getExternalFilesDir(null), FILENAME);//외부 공간으 파일 이름을 받아주었습니다.
                try{
                    OutputStream os = new FileOutputStream(file);//외부 공간 파일을 쓰기모드로 열어주었습니다.
                    os.write(edit.getText().toString().getBytes());//에딧 텍스트의 내용을 쓰기모드로 써주었습니다.
                    os.close();//스트림을 닫아주었습니다.
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
