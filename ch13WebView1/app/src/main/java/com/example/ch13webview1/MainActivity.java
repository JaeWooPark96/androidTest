package com.example.ch13webview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

//꼭 휴대폰에서 실행시키기!!!!!!!!!!!!!!!!!!!!!!!!
public class MainActivity extends AppCompatActivity {
    private EditText field;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field = (EditText)findViewById(R.id.url);
        webView = (WebView)findViewById(R.id.webView);
        webView.setWebViewClient(new TestBrowser());//WebViewClient로 설정
    }

    //웹페이지 열기 버튼의 이벤트 리스너
    //버튼이 클릭되면, 웹뷰에 URL 을 로딩한다.
    public void open(View view){
        String url = field.getText().toString();
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

    private class TestBrowser extends WebViewClient{
        //화면을 그릴 때, 이벤트가 발생하면, 호출된다.
        @SuppressWarnings("deprecation")
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
