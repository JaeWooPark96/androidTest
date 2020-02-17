package com.example.ch5optionmenu1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //메뉴를 추가해 주었습니다. 메뉴의 아이디는 1입니다.
        MenuItem item1 = menu.add(0, 1, 0, "사과");
        item1.setIcon(R.drawable.apple);//아이콘을 설정해주었습니다.
        item1.setAlphabeticShortcut('a');//단축키 지정 잘 사용 안함.

        menu.add(0,2,0, "포도").setIcon(R.drawable.grape);//메뉴에 추가. 이렇게 할 수 있는 건 반환 값을 이용하기 때문.
        menu.add(0,3,0, "바나나").setIcon(R.drawable.banana);

        return true;
    }
}
