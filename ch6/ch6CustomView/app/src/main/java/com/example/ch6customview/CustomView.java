package com.example.ch6customview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    public CustomView(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    public CustomView(Context context, AttributeSet attrs){//XML에서 이 뷰를 참조하려면, 반드시 이 생성자를 구현하여 주어야 한다.
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.RED);//그릴 객체의 색을 RED로 해주었습니다.
        canvas.drawArc(new RectF(10, 10, 600, 600), 45, 320, true, paint);//호를 그려주었습니다.
    }
}
