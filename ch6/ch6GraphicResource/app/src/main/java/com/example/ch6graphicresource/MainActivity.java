package com.example.ch6graphicresource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLinearLayout = new LinearLayout(this);
        ImageView i = new ImageView(this);
        i.setImageDrawable(getResources().getDrawable(R.drawable.oval));//ImageView에 드로워블 객체를 설정한다.
        i.setMinimumHeight(500);
        i.setMinimumWidth(500);

        mLinearLayout.addView(i);
        setContentView(mLinearLayout);
    }
}
