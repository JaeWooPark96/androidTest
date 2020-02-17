package com.example.ch5customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //@Override
    //로그인 버튼을 클릭하면, 로그인 대화상자가 뜨도록 해주었습니다.
    public void onClick(View v){
        final Dialog loginDialong = new Dialog(this);
        loginDialong.setContentView(R.layout.custom_dialog);//xml자체를 뷰로 받아주었습니다.
        loginDialong.setTitle("로그인 화면");//대화상자 제목

        Button login = (Button)loginDialong.findViewById(R.id.login);//해당 id의 버튼들을 가리키도록 했습니다.
        Button cancel = (Button)loginDialong.findViewById(R.id.cancel);

        final EditText username = (EditText)loginDialong.findViewById(R.id.username);//해당 id의 EditText를 가리키도록 했습니다.
        final EditText password = (EditText)loginDialong.findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener(){//대화상자에서 login 버튼이 클릭 되었을 때
            @Override
            public void onClick(View v){
                if (username.getText().toString().trim().length() > 0//아무거나 입력되어 있으면, "로그인" 성공 토스트 문자 출력
                && password.getText().toString().trim().length() > 0){
                    Toast.makeText(getApplicationContext(), "로그인 성공",
                            Toast.LENGTH_LONG).show();
                }
                else{//아무거나 입력 안 되 있으면, "다시 입력하시오" 토스트 문자 출력
                    Toast.makeText(getApplicationContext(), "다시 입력하시오",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){//대화상자에서 cancel 버튼이 클릭 되었을 때
            @Override
            public void onClick(View v){
                loginDialong.dismiss();
            }
        });

        loginDialong.show();
    }
}
