package com.example.ch6graphcshape1;

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
        setBackgroundColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);

        canvas.drawColor(Color.BLUE);//도화지의 색깔을 정해줍니다.
        canvas.drawRoundRect(new RectF(30, 50, 330, 550), 15,15,paint);//RoundRect를 그려주었습니다.
        canvas.drawOval(new RectF(450, 50, 750, 550), paint);//타원을 그려주었습니다.
        paint.setColor(Color.RED);//그리는 paint색을 바꾸어 주었습니다.
        canvas.drawArc(new RectF(30, 600, 330, 1100), 360, 1000, true, paint);//호를 그려주었습니다.
        paint.setColor(Color.YELLOW);//그리는 색을 노랑으로 바꾸어주었습니다.
        float[] pts = {30, 1250, 300, 1350, 300, 1350, 60, 1450, 60, 1450, 360, 1500};//선을 그릴 때 필요한 점들을 저장해주었습니다.
        paint.setStrokeWidth(10);//선 두께를 정해주었습니다.
        canvas.drawLines(pts, paint);//선을 그려주었습니다.
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
