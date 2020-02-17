package com.example.ch4imagescae;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class MyImageView extends View {
    private Drawable image;
    private ScaleGestureDetector gestureDetector;
    private float scale = 1.0f;

    public MyImageView(Context context){//생성자
        super(context);
        image = context.getResources().getDrawable(R.drawable.lion);//사자 그림을 image에 저장
        setFocusable(true);//포커스를 찹아주었습니다.
        image.setBounds(0,0,image.getIntrinsicWidth(), image.getIntrinsicHeight());//절대 위치로 배치해주었습니다.
        gestureDetector = new ScaleGestureDetector(context, new ScaleListener());//ScaleGestureDetector객체를 생성해주었습니다.
        //제스처 인식기 객체 생성
    }

    @Override
    protected void onDraw(Canvas canvas){//화면갱싱할 때마다 호출되는 함수
        super.onDraw(canvas);
        canvas.save();//저장
        canvas.scale(scale, scale);//캔버스의 신축 연산을 적용한다.
        image.draw(canvas);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);//제스처 인식기의 터치 이벤트 처리 메소드를 호출해준다.
        invalidate();//화면 갱신
        return true;
    }

    //onScale함수만을 정의하기 위한 클래스입니다.
    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector detector){//신축 연산이 감지 되었으면 호출됩니다.
            scale *= detector.getScaleFactor();

            if (scale < 0.1f){
                scale = 0.1f;
            }
            if (scale > 10.0f){
                scale = 10.0f;
            }

            invalidate();
            return true;
        }
    }

}
