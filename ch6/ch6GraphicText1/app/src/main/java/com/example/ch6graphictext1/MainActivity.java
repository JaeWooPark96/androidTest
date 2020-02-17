package com.example.ch6graphictext1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(100);

        //각 폰트별로 출력
        Typeface t;
        //셰리프 스타일 폰트 생성
        t = Typeface.create(Typeface.SERIF, Typeface.NORMAL);
        paint.setTypeface(t);

        paint.setTextAlign(Paint.Align.LEFT);//왼쪽 정렬
        canvas.drawText("This is a test!", 10, 200, paint);

        paint.setTextAlign(Paint.Align.CENTER);//가운데 정렬
        canvas.drawText("This is a test", 500, 300, paint);

        paint.setTextAlign(Paint.Align.RIGHT);//오른쪽 정렬
        canvas.drawText("This is a test", 800, 400, paint);

        paint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(Color.RED);

        paint.setUnderlineText(true);//밑줄
        canvas.drawText("This is a test", 10, 500, paint);
        paint.setUnderlineText(false);//이렇게 안하면 다음 줄들에서 밑줄 생김

        paint.setStrikeThruText(true);//가운데 줄
        canvas.drawText("This is a test", 10, 600, paint);
        paint.setStrikeThruText(false);//이렇게 안하면 다음 줄에서 가운데 줄 생김

        paint.setTextSkewX(-0.5f);//기울이기
        canvas.drawText("This is a test", 10, 700, paint);
        paint.reset();//다 썼으면, 리셋해줘야 됨.
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}