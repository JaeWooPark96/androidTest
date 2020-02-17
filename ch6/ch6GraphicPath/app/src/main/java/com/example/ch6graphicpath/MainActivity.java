package com.example.ch6graphicpath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import android.graphics.Path;

class MyView extends View {
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Path path = new Path();
        Paint paint = new Paint();

        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(20, 400);//path의 시작점을 지정
        path.lineTo(300, 800);//선을 그림
        path.cubicTo(450, 120, 600, 1200, 900,800);//베지어 곡선을 그림

        paint.setColor(Color.BLUE);//색을 파란색으로 함
        canvas.drawPath(path, paint);//path를 그려줌

        paint.setStyle(Paint.Style.FILL);//채우기만 하며 외곽선은 그리지 않는다.   (디폴트)
        paint.setTextSize(200);
        canvas.drawTextOnPath("This is a test!!", path, 0, 0, paint);//path위에 텍스트를 그려주었습니다.
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));//컨텐트 뷰를 MyView로 설정해주었습니다.
    }
}
