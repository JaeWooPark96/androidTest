package com.example.ch11imagedownload;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.InputDevice;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDownload = (Button)findViewById(R.id.btn_download);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etUrl = (EditText)findViewById(R.id.et_url);
                final ImageView iView = (ImageView)findViewById(R.id.iv_image);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            //URL url = new URL(etUrl.getText().toString());
                            //HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                            URL url = new URL("http://www.gstatic.com/webp/gallery3/1.png");
                            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                            urlConnection.connect();
                            final Bitmap bitmap = BitmapFactory.decodeStream(urlConnection.getInputStream());
                            iView.post(new Runnable() {
                                @Override
                                public void run() {
                                    iView.setImageBitmap(bitmap);
                                }
                            });
                        }
                        catch (Exception e){
                            Toast.makeText(getBaseContext(), "Image download error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                t.start();
            }
        });
    }

    /*public void onClick(View v) {
        final EditText etUrl = (EditText)findViewById(R.id.et_url);
        final ImageView iView = (ImageView)findViewById(R.id.iv_image);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    URL url = new URL(etUrl.getText().toString());
                    HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                    urlConnection.connect();
                    InputStream istream = urlConnection.getInputStream();
                    final Bitmap bitmap = BitmapFactory.decodeStream(istream);
                    iView.post(new Runnable() {
                        @Override
                        public void run() {
                            iView.setImageBitmap(bitmap);
                        }
                    });
                }
                catch (Exception e){
                    Toast.makeText(getBaseContext(), "Image download error", Toast.LENGTH_SHORT).show();
                }
            }
        });
        t.start();
    }*/

}
