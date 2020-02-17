package com.example.ch7pip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PictureInPictureParams;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import javax.crypto.Cipher;

public class MainActivity extends AppCompatActivity {
    private Button button;
    protected FrameLayout player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = findViewById(R.id.player);//FrameLayout을  가리키도록 해주었습니다.
        button = findViewById(R.id.pip);//버튼을 가리키도록 해주었습니다.

        //버튼을 클릭했을 때, PIP모드로 보이도록 해주었습니다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= 26){//SDK 26이상 일 때,
                    try {
                        Rational rational = new Rational(player.getWidth(), player.getHeight());

                        //PIP 모드에서 활동을 초기화하고 업데이트하는 데 사용되는 매개 변수 세트를 나타냅니다.
                        PictureInPictureParams mParams = new PictureInPictureParams.Builder().setAspectRatio(rational).build();

                        enterPictureInPictureMode(mParams);//PIP모드로 들어갔습니다.
                    }catch (IllegalStateException e){
                        e.printStackTrace();//에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
                    }
                }
                else{//SDK 25 이하일 때
                    Toast.makeText(getApplicationContext(), "API 26가 필요합니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureMode){//PIP모드가 바뀔 때의 이벤트 리스너
        super.onPictureInPictureModeChanged(isInPictureMode);
        if(!isInPictureMode){//현재 PIP가 아닐 때
            button.setVisibility(View.VISIBLE);//버튼이 보이도록 해주었습니다.
        }
        else{//현재 PIP가 일 때, 버튼이 안 보이도록 해주었습니다.
            button.setVisibility(View.GONE);
        }
    }
}
