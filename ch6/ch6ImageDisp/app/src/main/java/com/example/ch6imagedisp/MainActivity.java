package com.example.ch6imagedisp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

class  MyView extends View {
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        Bitmap b = BitmapFactory.decodeResource(getResources(),//이미지를 읽어서 비트맵으로 만든다.
                R.drawable.cat);
        canvas.drawBitmap(b, 0,0,null);//이미지를 canvas에 그린다.
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);//컨텐트뷰를 MyView객체로 해주었습니다.
    }
}
