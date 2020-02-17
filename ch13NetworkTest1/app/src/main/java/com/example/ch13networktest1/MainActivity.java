package com.example.ch13networktest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button get = (Button)findViewById(R.id.get);
        display = (EditText)findViewById(R.id.display);

        //버튼을 누르면, EditText에
        //현재 네트워크 상태 출력
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo info1 = manager.getActiveNetworkInfo();

                    if (info1 != null){
                        //현재 네트워크 상태 출력
                        if (info1.getType() == ConnectivityManager.TYPE_WIFI){
                            display.setText(info1.toString());
                        }
                        else if (info1.getType() == ConnectivityManager.TYPE_MOBILE){
                            display.setText(info1.toString());
                        }
                    }
                }
                catch (Exception e){

                }
            }
        });
    }
}
