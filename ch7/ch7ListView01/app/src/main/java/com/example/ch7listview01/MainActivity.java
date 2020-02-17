package com.example.ch7listview01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] values = {"Apple", "Apriot", "Avocado", "Banana", "Blackberry",//문자열 배열에 데이터 저장 (리스트로 쓸 것)
        "Blueberry", "Cherry", "Coconut", "Cranberry",
        "Grape Raisin", "Honeydew", "Jackfruit", "Lemon", "Lime",
        "Mango", "Watermelon"};

        //어뎁터 생성
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        //리스트 뷰에 어댑터 설정
        setListAdapter(adapter);
        //setContentView(R.layout.activity_main);
    }

    //아이템이 클릭되면, 해당 아이템을 토스트 메세지로 출력하도록 했습니다.
    @Override//item을 클릭하면 호출되는 함수입니다.
    protected void onListItemClick(ListView l, View v, int position, long id){
        String item = (String)getListAdapter().getItem(position);//클릭된 아이템의 문자열을 저장
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();//토스트 메세지로 출력
    }
}
