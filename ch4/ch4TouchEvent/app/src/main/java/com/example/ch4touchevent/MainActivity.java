package com.example.ch4touchevent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    protected class MyView extends View {
        int x = 100, y = 100;
        String str;

        public MyView(Context context){
            super(context);
            setBackgroundColor(Color.YELLOW);//배경을 노란색으로
        }

        @Override
        protected void onDraw(Canvas canvas){//화면을 갱신할 때마다 호출되어 다시그리는 함수
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            canvas.drawCircle(x,y,100,paint);//원을 그리도록
            paint.setTextSize(50);//출력되는 글자 크기를 정해주었습니다.
            canvas.drawText("액션의 종류: " + str, 0, 100, paint);//글자를 그려주었습니다.
        }

        @Override
        public boolean onTouchEvent(MotionEvent event){//이벤트 핸들러
            x = (int) event.getX();
            y = (int) event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN){//터치 다운일 때
                str = "ACTION_DOWN";
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE){//터치하고 움직일 때
                str = "ACTION_MOVE";
            }
            if (event.getAction() == MotionEvent.ACTION_UP){//터치를 안할 때
                str = "ACTION_UP";
            }
            invalidate();
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);//컴스텀 뷰를 엑티비티의 화면을 설정
    }
}
