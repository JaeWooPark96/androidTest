package com.example.ch5optionmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.MemoryFile;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);//각 메뉴항목이 눌러지면 토스트 메세지를 표시한다.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){//메뉴 mymenu.xml을 팽창하여 메뉴 객체를 만든다.
        switch (item.getItemId()){
            case R.id.apple:
                Toast.makeText(this, "사과", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.grape:
                Toast.makeText(this, "포도", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.banana:
                Toast.makeText(this, "바나나", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }
}
