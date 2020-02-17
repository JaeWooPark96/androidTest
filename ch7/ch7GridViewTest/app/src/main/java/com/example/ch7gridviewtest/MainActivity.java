package com.example.ch7gridviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //그리드 뷰를 가리키도록 해주었습니다.
        GridView gridView = (GridView)findViewById(R.id.GridVew01);
        gridView.setAdapter(new ImageAdapter(this));

        //리스트중 어떤 아이템을 클릭하면 호출되는, 이벤트 리스너를 익명의 클래스로 구현해주었습니다.
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), ""+position, Toast.LENGTH_SHORT).show();//해당 아이템의 position을 토스트 메세지로 출력
            }
        });
    }
}
