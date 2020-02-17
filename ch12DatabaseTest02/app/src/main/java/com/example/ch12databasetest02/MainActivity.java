package com.example.ch12databasetest02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "mycontacts.db";
    private static final int DATABASE_VERSION= 2;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        //데이터 베이스 테이블을 생성해주었습니다.
        db.execSQL("CREATE TABLE contacts (_id INTEGER PRIMARY KEY" + " AUTOINCREMENT, name TEXT, tel TEXT);");

        //데이터 베이스에 샘플 코드들을 저장하도록 해주었습니다.
        //레코드 10개 저장
        for (int i = 0; i < 10; i++){
            db.execSQL("INSERT INTO contacts VALUES (null, " + "'김철수 " + i + "'" + ", '010-1234-100" + i + "');");
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new DBHelper(this);
        db = helper.getWritableDatabase();
        //테이블의 모든 레코드를 커서 객체로 가져와주었습니다.
        Cursor cursor = db.rawQuery("SELECT * FROM contacts", null);

        startManagingCursor(cursor);//액티비티 생애 주기와, 커서의 생애 주기를 일치시켜주었습니다.

        //리스트로 표시
        String[] from = {"name", "tel"};
        int[] to = {android.R.id.text1,android.R.id.text2 };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.id.layout.simple_list_item_2, cursor, from, to);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}
