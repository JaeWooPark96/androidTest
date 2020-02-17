package com.example.ch6transition2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button fadeButton, slideButton, explodeButton;
    private ImageView imageView, imageView2;
    boolean visable;//보이게 할지 말지를 정하는 필드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id로 이미지와 버튼들을 가리켜주었습니다.
        layout = (LinearLayout)findViewById(R.id.layout);
        fadeButton = (Button)findViewById(R.id.fade);
        slideButton = (Button)findViewById(R.id.slide);
        explodeButton = (Button)findViewById(R.id.explode);
        imageView = (ImageView)findViewById(R.id.imageView);

        fadeButton.setOnClickListener(new View.OnClickListener(){//fade 버튼의 리스너. fade효과로 사진을 넘기도록 합니다.
            @Override
            public void onClick(View view){
                TransitionManager.beginDelayedTransition(layout, new Fade());
                visable = !visable;
                imageView.setVisibility(visable ? View.VISIBLE : View.GONE);
            }
        });
        slideButton.setOnClickListener(new View.OnClickListener(){//slide 버튼의 리스너. slide효과로 사진을 넘기도록 합니다.
            @Override
            public void onClick(View view){
                TransitionManager.beginDelayedTransition(layout, new Slide());
                visable = !visable;
                imageView.setVisibility(visable ? View.VISIBLE : View.GONE);
            }
        });
        explodeButton.setOnClickListener(new View.OnClickListener(){//explode 버튼의 리스너. explode효과로 사진을 넘기도록 합니다.
            @Override
            public void onClick(View view){
                TransitionManager.beginDelayedTransition(layout, new Explode());
                visable = !visable;
                imageView.setVisibility(visable ? View.VISIBLE : View.GONE);
            }
        });
    }
}
