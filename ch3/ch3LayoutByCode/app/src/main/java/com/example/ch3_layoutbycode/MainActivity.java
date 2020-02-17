package com.example.ch3_layoutbycode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout manager = (LinearLayout)findViewById(R.id.LayoutManager);//여기서 특정 뷰를 찾아서 해당 뷰를 변경해주었습니다.
        manager.setOrientation(LinearLayout.HORIZONTAL);//실제 실행해 보면, 수평으로 배치되어 있습니다.
    }
}
