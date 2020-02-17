package com.example.ch5datepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Button btnSelectData, btnSelectTime;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSelectData=(Button)findViewById(R.id.buttonDate);
        btnSelectTime=(Button)findViewById(R.id.buttonTime);
    }

    public void onClick(View v){//해당 버튼이 클릭될 때 호출되도록 해주었습니다.
        if (v == btnSelectData){//누른 버튼이 날짜 변경일 때
            final Calendar c = Calendar.getInstance();//날자 정보르르 받아주었습니다.
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);

            //달력에서 날자를 바꾸면, 해당 날자를 버튼에 출력하도록 해주었습니다.
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    btnSelectData.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);//버튼의 텍스트 변경
                }
            }, mYear, mMonth, mDay);//참고로 달력은 현재 날짜로 설정되도록 했습니다.
            datePickerDialog.show();
        }


        if (v == btnSelectTime){//누른 버튼이 시간 변경일 때
            final Calendar c = Calendar.getInstance();//시간 정보를 받아주었습니다.
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);


            //시간 정보를 시계에서 바꾸면 그 정보를 버튼에 출력하도록 해주었습니다.
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    btnSelectTime.setText(hourOfDay + ":" + minute);//버튼의 텍스트 변경
                }
            }, mHour, mMinute, false);//참고로 시계는 현제 시간으로 설정되도록 했습니다.
            timePickerDialog.show();
        }
    }
}
