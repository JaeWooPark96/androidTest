package com.example.ch4myviewevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View {//View를 상속 받는 클래스를 정의해주었습니다.
    int key;
    String str;
    int x, y;

    public MyView(Context context){//생성자
        super(context);
        setBackgroundColor(Color.YELLOW);//배경을 노랑으로 해주었습니다.
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){//터치 했을 때, 위치를 받아주었습니다.
        x = (int) event.getX(0);//터치 했을 때, event 객체에 저장되는 정보중에 위치를 저장받아주었습니다.
        y = (int) event.getY(0);
        invalidate();//화면을 갱신해주었습니다.
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas){//화면이 갱신될 때 자동적으로 호출
        Paint paint = new Paint();
        paint.setTextSize(50);
        canvas.drawCircle(x,y,30,paint);
        canvas.drawText("(" + x + ", " + y + ") 에서 터치 이벤트가 발생하였음", x, y + 100, paint);
    }
}
public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView w = new MyView(this);
        setContentView(w);//커스텀 뷰를 엑티비티의 화면으로 설정합니다.
    }
}
