package com.example.ch5contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.TextView01);
        registerForContextMenu(text);//텍스트 뷰에 컨텍스트 메뉴를 등록한다.
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){//코드로 메뉴를 생성해주었습니다.
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("컨테스트 메뉴");//메뉴 제목
        menu.add(0,1,0,"배경색: RED");//메뉴를 추가해주었습니다. 1이 메뉴 아이디입니다.
        menu.add(0,2,0,"배경색: GREEN");
        menu.add(0,3,0,"배경색: BLUE");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){//컨택스트 메뉴가 클릭될 때 이 함수 호출
        switch (item.getItemId()){//선택된 메뉴에 따라 다르게 처리하도록 해주었습니다.
            case 1:
                text.setBackgroundColor(Color.RED);
                return true;
            case 2:
                text.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                text.setBackgroundColor(Color.BLUE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
