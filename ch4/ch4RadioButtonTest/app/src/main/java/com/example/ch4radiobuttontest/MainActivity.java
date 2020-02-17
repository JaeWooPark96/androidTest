package com.example.ch4radiobuttontest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view){//라디오 버튼의 이벤트 핸들러입니다.
        boolean checked = ((RadioButton)view).isChecked();//라디오 버튼 체크 상태를 얻어주었습니다.

        switch(view.getId()){
            case R.id.radio_red://red버튼 일 때
                if(checked){//해당 라디오 버튼이 체크됬을 때, 해당 라디오버튼 텍스트 출력
                    Toast.makeText(getApplicationContext(),
                            ((RadioButton)view).getText(),
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.radio_blue://blue버튼 일 때
                if(checked){//해당 라디오 버튼이 체크됬을 때, 해당 라디오버튼 텍스트 출력
                    Toast.makeText(getApplicationContext(),
                            ((RadioButton)view).getText(),
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
