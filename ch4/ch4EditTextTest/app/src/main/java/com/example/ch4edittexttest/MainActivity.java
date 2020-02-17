package com.example.ch4edittexttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText eText;//여기서 final로 처리하지 않으면 오류 뜸. 중간에 다른 걸 가리키거나 할 수 있기 때문입니다.
        Button btn;//버튼 레퍼런스입니다.
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        eText = (EditText)findViewById(R.id.editText);//해당 id의 EditText를 가리키도록 했습니다.
        btn = (Button)findViewById(R.id.button); //해당 id의 Button을 가리키도록 했습니다.
        btn.setOnClickListener(new View.OnClickListener(){//익명의 클래스로 OnClickListener를 구현해주었습니다.
            public void onClick(View v){
                String str = eText.getText().toString();
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
