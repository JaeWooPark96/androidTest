package com.example.ch4multitouch;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MultiTouchView extends View {
    private  static final int SIZE = 60;

    final int MAX_POINTS = 10;//최대 10개 포인터의 위치와 상태를 저장할 수 있다
    float[] x = new float[MAX_POINTS];
    float[] y = new float[MAX_POINTS];
    boolean[] touching = new boolean[MAX_POINTS];

    private Paint mPaint;
    public MultiTouchView(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
    }

    private void initView(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int index = event.getActionIndex();
        int id = event.getPointerId(index);//index로 부터 포인터(점)의 아이디를 구한다.
        int action = event.getActionMasked();

        switch (action){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN://터치될 때
                x[id] = (int)event.getX(index);//터치된 위치를 배열에 저장
                y[id] = (int)event.getY(index);
                touching[id] = true;//현재 id 인덱스가 터치되어 있음을 true로 표시
                break;
            case MotionEvent.ACTION_MOVE://움직일 때는 그냥 break하도록 해주었습니다.
                break;
            case MotionEvent.ACTION_UP://터치를 때었거나
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL://취소 되었을 때
                touching[id] = false;//처리가 종료되었음을 저장합니다.
                break;
        }

        invalidate();//화면 갱신
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas){//화면 갱신될 때마다 호출되는 onDraw()함수입니다.
        super.onDraw(canvas);
        for (int i = 0; i < MAX_POINTS; i++){//터치되어 있는 포인터 위치에 그린다.
            if (touching[i]){
                canvas.drawCircle(x[i], y[i], SIZE, mPaint);
            }
        }
    }
}
