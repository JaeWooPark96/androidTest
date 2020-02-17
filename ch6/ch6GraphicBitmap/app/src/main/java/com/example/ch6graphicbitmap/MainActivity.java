package com.example.ch6graphicbitmap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
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

        Matrix m = new Matrix();//상하 반전 변환행렬
        m.preScale(1, -1);

        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.house);//이미지를 읽어서 비트맵으로 만듦
        Bitmap mb = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, false);//비트맵을 b객체 원본 크기로 만듦
        Bitmap sb = Bitmap.createScaledBitmap(b, 600, 600, false);//비트맵을 600x600사이즈로 만듦. 크기가 변환됩니다.
        canvas.drawBitmap(mb, 0, 0, null);//비트맵을 그려주었습니다.
        canvas.drawBitmap(sb, 100, 100, null);//비트맵을 그려주었습니다.
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
