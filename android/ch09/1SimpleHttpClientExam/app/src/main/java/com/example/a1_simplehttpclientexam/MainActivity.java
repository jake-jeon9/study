package com.example.a1_simplehttpclientexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    AsyncHttpClient asyncHttpClient;    //요청객체
    HttpResponse httpResponse;          //응답객체

    String url = "http://192.168.0.180:8085/server_data/simple_text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        httpResponse = new HttpResponse();
        asyncHttpClient = new AsyncHttpClient();
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    asyncHttpClient.get(url,httpResponse); //서버에 요청

    }


    public class HttpResponse extends AsyncHttpResponseHandler {
        //서버로 부터 200코드가 오면 호출
        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
            String result = null;
            try {
                result = new String(bytes,"ASCII");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String result_utf=null;
            try {
                result_utf =  URLEncoder.encode(result, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            textView.setText(result_utf);
        }


        //서버로 부터 200코드가 아닌 코드가 오면 호출
        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        String result = new String(bytes);
            Toast.makeText(MainActivity.this,"통신 실패 : "+ result,Toast.LENGTH_SHORT).show();
        }
    }
}