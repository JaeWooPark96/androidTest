package com.example.ch12innersavedspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String FILENAME = "text.txt";
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = (EditText)findViewById(R.id.editText);//editText를 가리키도록 해주었습니다.
        Button readBtn = (Button)findViewById(R.id.read);//읽기 버튼을 가리키도록 해주었습니다.
        readBtn.setOnClickListener(new View.OnClickListener() {//읽기 버튼 클릭 이벤트 리스너
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput(FILENAME);//읽기모드로 파일을 열어주었다.
                    byte[] buffer = new byte[fis.available()];//버퍼
                    fis.read(buffer);//읽은 바이트를 버퍼에 저장해주었습니다.
                    edit.setText(new String(buffer));//읽은 바이트를 에딧 텍스트에 저장해주었습니다.

                    /*String saveStr = new String();
                    while (fis.read(buffer) != -1) {
                        saveStr = saveStr + new String(buffer);
                    }

                    edit.setText(saveStr);//읽은 바이트를 에딧 텍스트에 저장해주었습니다.*/
                    fis.close();//스트림을 닫아주었습니다.
                }
                catch (IOException e){

                }
            }
        });

        Button writeBtn = (Button)findViewById(R.id.write);
        writeBtn.setOnClickListener(new View.OnClickListener() {//쓰기 버튼을 누를 때
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);//파일을 쓰기모드로 열어주었습니다.
                    fos.write(edit.getText().toString().getBytes());//edit텍스트의 내용을 내부 저장소에 저장해주었습니다.
                    fos.close();//스트림을 닫아주었습니다.
                }
                catch (IOException e){

                }
            }
        });
    }


}
