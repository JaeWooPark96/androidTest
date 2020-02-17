package com.example.ch13webdownload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.temporal.TemporalQueries;

//꼭 휴대폰에서 실행시키기!!!!!!!!!!!!!!!!!!!!!!!!
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDownload = (Button)findViewById(R.id.download);
        final View.OnClickListener downloadListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNetworkAvailable()){
                    EditText url = (EditText)findViewById(R.id.url);
                    DownloadTask downloadTask = new DownloadTask();//다운로드하는 작업을 새로운 스레드로 생성한다.
                    downloadTask.execute(url.getText().toString());
                }
                else{
                    Toast.makeText(getBaseContext(), "Network is net Available", Toast.LENGTH_SHORT).show();
                }
            }
        };
        btnDownload.setOnClickListener(downloadListener);
    }

    private boolean isNetworkAvailable(){//네트워크가 사용 가능한지를 체크한다.
        boolean available = false;
        ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isAvailable()){
            available =true;
        }
        return available;
    }

    private String downloadUrl(String strUrl) throws IOException{//URL 주소를 받아서 웹페이지 내용을 문자열 형태로 반환한다.
        String s = null;
        byte[] buffer = new byte[1000];
        InputStream iStream = null;
        try{
            URL url = new URL(strUrl);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

            urlConnection.connect();//URL에 접속한다.

            iStream = urlConnection.getInputStream();//URL로부터 최대 1000바이트의 데이터를 읽는다.
            iStream.read(buffer);
            s = new String(buffer);
        }
        catch (Exception e) {
            Log.d("Exception while download url", e.toString());
        }
        finally {
            iStream.close();
        }

        return s;
    }

    private class DownloadTask extends AsyncTask<String, Integer, String>{//새로운 스레드를 생성하는 방법 중의 하나가 AsyncTask클래스를 이용하는 것이다.
        String s = null;

        @Override
        protected String doInBackground(String ... url){//새로운 스레드에 의하여 배경에서 실행된다.
            try{
                s = downloadUrl(url[0]);
            }
            catch (Exception e){
                Log.d("Backgroun Task", e.toString());
            }

            return s;
        }

        @Override
        protected void onPostExecute(String result){//다운로드가 끝나면 실행된다. 여기서는 다운로드된 문자열로 텍스트뷰를 채운다.
            TextView tView = (TextView)findViewById(R.id.textView);
            tView.setText(result);
            Toast.makeText(getBaseContext(), "Web page download successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
