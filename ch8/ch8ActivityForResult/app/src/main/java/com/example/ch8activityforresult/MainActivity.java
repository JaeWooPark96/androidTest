package com.example.ch8activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    static final int GET_STRING = 1;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button button = (Button)findViewById(R.id.receiveString);
        text = (TextView)findViewById(R.id.text);
        button.setOnClickListener(new View.OnClickListener() {

        });*/
    }

    public void onClickReceiveString(View arg0) {
        Intent in = new Intent(MainActivity.this, SubActivity.class);
        startActivityForResult(in, GET_STRING);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GET_STRING) {
            if (resultCode == RESULT_OK) {
                text.setText(data.getStringExtra("INPUT_TEXT"));
            }
        }
    }


}
