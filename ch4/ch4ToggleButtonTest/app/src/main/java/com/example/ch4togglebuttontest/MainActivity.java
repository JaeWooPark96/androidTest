package com.example.ch4togglebuttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onToggleClicked(View view){//토글 버튼 이벤트 핸들러입니다.
        boolean on = ((ToggleButton) view).isChecked();//토글 버튼의 상태를 받아주었습니다.

        if (on){//클릭 후 체크된 상태일 때
            Toast.makeText(getApplicationContext(), "Checked",
                    Toast.LENGTH_SHORT).show();
        }
        else{//클릭 후 체크가 안된 상태일 때
            Toast.makeText(getApplicationContext(), "Not checked",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
