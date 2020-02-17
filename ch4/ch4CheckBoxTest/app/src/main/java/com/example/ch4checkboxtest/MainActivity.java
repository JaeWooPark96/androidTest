package com.example.ch4checkboxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCheckboxClicked(View view){//해당 체크 박스가 클릭되면, 여기 리스너로 와서 처리하도록 해주었습니다.
        boolean checked = ((CheckBox) view).isChecked();//해당 체크 박스가 체크된 상태인지 아닌지 확인해서 저장해주었습니다.

        switch(view.getId()){
            case R.id.checkBox_meat://고기 체크박스가 클릭 됬을 때
                if(checked) {//클릭해서 체크가 된 상태일 때
                    Toast.makeText(getApplicationContext(), "고기 선택",
                            Toast.LENGTH_SHORT).show();
                }
                else{//클릭해서 체크가 해제 됬을 때
                    Toast.makeText(getApplicationContext(), "고기 선택 해제",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox_cheese://치즈 체크박스가 클릭 됬을 때
                if(checked) {//클릭해서 체크가 된 상태일 때
                    Toast.makeText(getApplicationContext(), "치즈 선택",
                            Toast.LENGTH_SHORT).show();
                }
                else{//클릭해서 체크가 해제 됬을 때
                    Toast.makeText(getApplicationContext(), "치즈 선택 해제",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
