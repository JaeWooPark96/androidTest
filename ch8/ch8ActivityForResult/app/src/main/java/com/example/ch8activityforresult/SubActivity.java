package com.example.ch8activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edit;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub);

       /* edit = (EditText)findViewById(R.id.edit);
        Button button_ok = (Button)findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override

        });

        Button button_cancel = (Button)findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override

        });*/
    }

    public void onClickOk(View v) {
        edit = (EditText)findViewById(R.id.edit);

        Intent intent = new Intent();
        intent.putExtra("INPUT_TEXT", edit.getText().toString());
        setResult(RESULT_OK, intent);

        finish();
    }

    public void onClickCancel(View v) {
        edit = (EditText)findViewById(R.id.edit);

        setResult(RESULT_CANCELED);
        finish();
    }
}
