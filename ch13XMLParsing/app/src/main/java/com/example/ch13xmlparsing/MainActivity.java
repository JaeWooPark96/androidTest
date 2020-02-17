package com.example.ch13xmlparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@SuppressLint("NewApi")
public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editURL;
    Document doc = null;
    LinearLayout layout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView1);
        editURL = (EditText)findViewById(R.id.url);
    }

    public void onClick(View view){
        GetXMLTask task = new GetXMLTask(this);
        task.execute("https://m.kma.go.kr/m/obs/aws.jsp");//기상청 웹 사이트 연결
    }

    @SuppressLint("NewApi")
    private class GetXMLTask extends AsyncTask<String, Void, Document>{
        private Activity context;

        public GetXMLTask(Activity context){
            this.context = context;
        }

        @Override
        protected Document doInBackground(String...urls){
            URL url;
            try{
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db;

                db = dbf.newDocumentBuilder();//XML문서 빌더 객체를 생성
                doc = db.parse(new InputSource(url.openStream()));//XML문서를 파싱
                doc.getDocumentElement().normalize();
            }
            catch (Exception e){
                Toast.makeText(getBaseContext(), "Prasing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc){
            String s = "";
            NodeList nodeList = doc.getElementsByTagName("data");

            for (int i = 0; i < nodeList.getLength(); i++){
                s += "" + i + ": 날씨 정보: ";
                Node node = nodeList.item(i);
                Element fstElmnt = (Element)node;
                NodeList nameList = fstElmnt.getElementsByTagName("temp");//temp 태그를 가지는 노드를 찾는다. 계층적인 노드 구조를 반환한다.

                //온도 데이터를 추출한다.
                Element nameElement = (Element)nameList.item(0);
                nameList = nameElement.getChildNodes();

                s += "온도 = " + ((Node)nameList.item(0)).getNodeValue() + ".";

                //날씨 데이터를 추출한다.
                NodeList websiteList = fstElmnt.getElementsByTagName("wfKor");
                Element websiteElement = (Element)websiteList.item(0);
                websiteList = websiteElement.getChildNodes();
                s += "날씨 = " + ((Node)websiteList.item(0)).getNodeValue() + "\n";
            }
            textView.setText(s);
        }
    }
}
