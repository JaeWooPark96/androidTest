package com.example.ch7spinnertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner를 가리키도록 해주었습니다.
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //리소스로부터 Arrayadapter를 생성
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.planets_array, android.R.layout.simple_spinner_item
        );

        //사용자가 클릭하여서 항목이 오픈될 때에 항목을 표시하는 뷰의 모양을 정의한다.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);//spinner에 어댑터를 설정합니다.
        //이렇게해서 strings의 아이템들을 spinner에 설정해주었습니다.

        //spinner의 아이템을 클릭했을 때의 이벤트 리스너를 생성해주었습니다.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){//어떤 아이템이 클릭되면, 해당 아이템이 선택되었다고 토스트 메세지를 출력하도록 해주었습니다.
                Toast.makeText(parent.getContext(), "선택된 행성은 " + parent.getItemAtPosition(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }

            //어댑터 뷰에서 선택이 사라지는 경우에 호출되는 이벤트 리스너
            public void onNothingSelected(AdapterView<?> arg0){
                Toast.makeText(arg0.getContext(), "선택이 사라짐",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
