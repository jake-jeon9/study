package com.example.a3_simplejsonexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button;
    AsyncHttpClient httpClient;
    String uri = "http://192.168.0.180:8085/server_data/simple.json";
    HttpResponse response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        httpClient = new AsyncHttpClient();
        response = new HttpResponse();

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        httpClient.get(uri,response);
    }


    public class HttpResponse extends AsyncHttpResponseHandler {

        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
        String result = new String(bytes);
        String name = null;
        String type = null;
            try {
                JSONObject json = new JSONObject(result); // 첫번째 {} 를 나타냄
                JSONObject device = json.getJSONObject("device");
                name = device.getString("name");
                type = device.getString("type");

            } catch (JSONException e) {
                e.printStackTrace();
            }
            textView.setText("이름은 : "+name+", 종류 : "+type);
        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            Toast.makeText(MainActivity.this,"통신 실패",Toast.LENGTH_SHORT).show();
        }
    }
}