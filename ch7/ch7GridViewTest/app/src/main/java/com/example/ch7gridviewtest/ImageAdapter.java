package com.example.ch7gridviewtest;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    private Integer[] mThumbIds = {//drawable리소스의 사진의 위치를 배열에 저장해 놓았습니다.
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4,
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4,
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4,
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4,
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4,
            R.drawable.sample_1, R.drawable.sample_2,
            R.drawable.sample_3, R.drawable.sample_4
    };

    public ImageAdapter(Context c){//생성자
        mContext = c;
    }

    //BaseAdapter로부터 상속된 몇가지의 꼭 필요한 메소드들을 구현하여야 한다.
    public int getCount(){
        return mThumbIds.length;
    }


    public Object getItem(int position){//실제 아이템을 반환해야 하지만, 구현하진 않았다.
        return null;
    }

    public long getItemId(int position){//실제 ID을 반환해야 하지만, 구현하진 않았다.
        return 0;
    }

    //ImageAdapter에 추가된 각각의 이미지를 표시하는 VIew객체를 반환한다.
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if (convertView == null){//convertView는 기존 View객체이다. convertView == null일 때, 새로운 ImageView객체를 생성해야 한다.
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));//뷰 객체의 높이와 너비를 설정한다.
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//필요하다면, 이미지가 중심을 향하여 크롭되어야 함을 설정한다.
            imageView.setPadding(8,8,8,8);//동서남북 방향에 대하여 패딩을 설정한다.
        }
        else{//convertView != null일 때, ImageView타입으로 형변환을 한다.
            imageView = (ImageView)convertView;
        }

        imageView.setImageResource(mThumbIds[position]);//imageView의 이미지 리소스를 mThumbIds[position]이미지로 선택한다.
        return imageView;//imageView반환
    }
}
