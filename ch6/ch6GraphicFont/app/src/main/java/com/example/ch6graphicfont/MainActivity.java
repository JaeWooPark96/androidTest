package com.example.ch6graphicfont;

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
        Typeface myFont;
        Paint paint = new Paint();//페인트 객체 생성
        paint.setAntiAlias(true);//색상차가 뚜렷한 경계 부근에 중간색을 삽입하여 도형이나 글꼴이 주변 배경과 부드럽게 잘 어울리도록 하는 기법.
        myFont = Typeface.createFromAsset(getContext().getAssets(),//assets폴더에 있는 외부폰트를 적용해줍니다.Regular.ttf
                "Regular.ttf");
        paint.setTypeface(myFont);//해당 폰트를 적용해줍니다.
        paint.setTextSize(80);//텍스트 사이즈 설정
        canvas.drawText("This is a New Font!!!", 10, 400, paint);//글을 드려주었습니다.
        canvas.drawText("Have Fun!!!", 10, 800, paint);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));//컨텐트 뷰를 MyView로 설정해주었습니다.
    }
}