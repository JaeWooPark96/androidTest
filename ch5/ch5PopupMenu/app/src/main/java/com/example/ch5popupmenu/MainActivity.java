package com.example.ch5popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View button){
        PopupMenu popup = new PopupMenu(this, button);
        popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
        popup.setOnMenuItemClickListener(//팝업 메뉴 항목이 눌러지면 여기서 처리합니다.
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), "클릭된 팝업 메뉴:" + item.getTitle(),//해당 팝업에 대한 토스트 메세지를 출력합니다.
                                Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );

        popup.show();
    }
}
