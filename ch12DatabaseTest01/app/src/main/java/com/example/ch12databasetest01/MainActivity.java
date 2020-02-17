package com.example.ch12databasetest01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

//데이터 베이스 파일 이름은 mycontacts.db 이고. 데이터 베이스 버전은 1이다.
//데이터 베이스를 요청했는데 데이터 베이스가 없으면, onCreate에서 데이터베이스 파일을 생성해주도록 해주었습니다.
class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION= 2;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        //데이터 베이스 테이블을 생성해주었습니다.
        db.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY" + " AUTOINCREMENT, name TEXT, tel TEXT);");
    }

    //데이터베이스 버전이 증가되었을 때, 호출되는 함수입니다.
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS contacts");//기존 테이블을 버립니다.
        onCreate(db);//다시 테이블을 만듭니다.
    }
}

public class MainActivity extends AppCompatActivity {
    DBHelper helper;
    SQLiteDatabase db;
    EditText edit_name, edit_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DBHelper(this);

        try{
            db = helper.getWritableDatabase();//데이터베이스 객체를 얻어주었습니다.
        }
        catch (SQLiteException ex){
            db = helper.getReadableDatabase();
        }

        //EditText들을 가리켜주었습니다.
        edit_name = (EditText)findViewById(R.id.name);
        edit_tel = (EditText)findViewById(R.id.tel);
    }

    //추가버튼의 이벤트 리스너
    public void insert(View target){
        //EditText의 내용들을 String 객체에 저장
        String name = edit_name.getText().toString();
        String tel = edit_tel.getText().toString();

        //데이터베이스에 해당 내용 추가
        db.execSQL("INSERT INTO contacts VALUES (null,'" + name + "','" + tel + "');");
        Toast.makeText(getApplicationContext(), "성공적으로 추가되었음", Toast.LENGTH_SHORT).show();

        //EditText를 비워주었습니다.
        edit_name.setText("");
        edit_tel.setText("");
    }

    //탐색버튼의 이벤트 리스너
    public void search(View target){
        String name = edit_name.getText().toString();////EditText의 이름을 저장

        Cursor cursor;//Cursor: 퀴리의 결과로 생성되는 레코드의 집합을 순회하면서 데이터를 가져올 수 있는 클래스

        //탐색
        cursor = db.rawQuery("SELECT name, tel FROM contacts WHERE name='" + name + "';", null);
        while(cursor.moveToNext()){//cursor객체에 있는 레코드 중에서 해당 내용을 탐색합니다.
            String tel   = cursor.getString(1);
            edit_tel.setText(tel);
        }
    }
}
