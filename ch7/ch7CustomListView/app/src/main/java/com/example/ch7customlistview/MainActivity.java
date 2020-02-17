package com.example.ch7customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] titles = {//제목 리스트
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10"
    };

    Integer[] images = {//이미지 리스트
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1,
            R.drawable.movie1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //어댑터 생성
        CustomList adapter = new CustomList(MainActivity.this);//우리가 만든 CustomList객체를 생성해주었습니다.

        list=(ListView)findViewById(R.id.list);//리스트뷰를 가리키도록 해주었습니다.
        list.setAdapter(adapter);//리스트 뷰에 어댑터를 설정해주었습니다.

        //아이템을 클릭하면, 여기 리스터가 호출되서 제목을 토스트 메세지로 출력하도록 해주었습니다.
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), titles[+position],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    //어댑터 클래스를 만들어주었습니다.
    public class CustomList extends ArrayAdapter<String>{
        private final Activity context;
        public CustomList(Activity context){//생성자
            super(context, R.layout.listitem, titles);
            this.context = context;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            //안드로이드에서 inflate 를 사용하면 xml 에 씌여져 있는 view 의 정의를 실제 view 객체로 만드는 역할을 합니다.
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem, null, true);

            //ListView의 각 객체를 가리키도록 해주었습니다. 수정하면, 해당 객체도 수정됩니다.
            ImageView imageView = (ImageView)rowView.findViewById(R.id.image);
            TextView title = (TextView)rowView.findViewById(R.id.title);
            TextView rating = (TextView)rowView.findViewById(R.id.rating);
            TextView genre = (TextView)rowView.findViewById(R.id.genre);
            TextView year = (TextView)rowView.findViewById(R.id.releaseYear);

            //배열에서 해당 내용들을 position인덱스에 맞게 꺼내서 ListView의 각 객체에 저장해주었습니다.
            title.setText(titles[position]);
            imageView.setImageResource(images[position]);
            rating.setText("9.0"+position);
            genre.setText("DRAMA");
            year.setText(1930+position+"");

            return rowView;
        }
    }
}
