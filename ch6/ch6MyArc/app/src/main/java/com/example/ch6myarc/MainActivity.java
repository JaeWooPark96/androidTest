package com.example.ch6myarc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

class MyView extends View {
    private Paint mPaints, mFramePaint;
    private RectF mBigOval;
    private float mStart, mSweep;

    private static final float SWEEP_INC = 2;
    private static final float START_INC = 15;

    public MyView(Context context){
        super(context);

        //시간이 많이 걸리는 작업은 생성자에서 미리 해둡니다.

        //도형의 색을 설정해주었습니다.
        mPaints = new Paint();
        mPaints.setAntiAlias(true);
        mPaints.setStyle(Paint.Style.FILL);
        mPaints.setColor(0x88FF0000);

        //주변의 획 선(직사각형)의 색을 설정해주었습니다.
        mFramePaint = new Paint();
        mFramePaint.setAntiAlias(true);
        mFramePaint.setStyle(Paint.Style.STROKE);
        mFramePaint.setStrokeWidth(3);
        mFramePaint.setColor(0x8800FF00);
        mBigOval = new RectF(40, 10, 900, 1000);//직사각형 객체를 저장합니다.
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.YELLOW);
        canvas.drawRect(mBigOval, mFramePaint);//직사각형을 그림
        canvas.drawArc(mBigOval, mStart, mSweep, false, mPaints);//직사각형 안에 들어가는 호를 그립니다.
        //그리고 useCenter를 false로 해서, 바깥을 기준으로 그립니다.(중심이 아닌)

        //mStart각도에서 mSweep만큼의 원호를 그립니다.
        mSweep += SWEEP_INC;//그리는 각도를 증가시킵니다.
        if (mSweep > 360){//mSweep각도가 360을 이상이면 360을 빼주도록 했습니다.
            mSweep -= 360;
            mStart += START_INC;//그리는 각도를 증가시킵니다.
            if (mStart >= 360){//mStart각도가 360을 이상이면 360을 빼주도록 했습니다.
                mStart -= 360;
            }
        }
        invalidate();
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
}
