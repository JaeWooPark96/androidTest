package com.example.ch6graphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.BLUE);//배경색을 파란색으로 해주었습니다.
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();//페인트 객체 생성
        paint.setColor(Color.YELLOW);//그리는 객체 색을 노랑을 해주었습니다.
        paint.setStrokeWidth(20);//선 두께를 20으로 해주었습니다.
        canvas.drawLine(100, 100, 700, 100, paint);//선
        canvas.drawRect(100, 300, 700, 700, paint);//직사각형
        canvas.drawCircle(300, 1200, 200, paint);//원
        paint.setTextSize(80);//글자 크기를 80으로
        canvas.drawText("This is a test.", 100, 900, paint);//글자를 써주었습니다.
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);//MyView 객체를 생성해주었습니다.
        setContentView(w);//컨텐트뷰를 MyView의 객체로 해주었습니다.
    }
}
