package com.example.a2_parametersenderexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.HttpClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    EditText editText1,editText2;
    TextView textView;
    AsyncHttpClient client;
    String uri_get = "http://192.168.0.180:8085/server_data/send_get.jsp";
    String uri_post = "http://192.168.0.180:8085/server_data/send_post.jsp";
    httpResponese responese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);

        client = new AsyncHttpClient();
        responese = new httpResponese();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String user_id = editText1.getText().toString().trim();
        String user_pw = editText2.getText().toString().trim();

        //parameter management
        RequestParams params = new RequestParams();
        params.put("user_id",user_id);
        params.put("user_pw",user_pw);

        switch (v.getId()){
            case R.id.button :  //get type
                client.get(uri_get,params,responese);
                break;

            case R.id.button2 : //post type
                client.post(uri_post,params,responese);
                break;
        }
    }

    class httpResponese extends AsyncHttpResponseHandler {
        ProgressDialog dialog;

        //when connection is started
        @Override
        public void onStart() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("plz, wait a moment");
            dialog.setCancelable(false);
            dialog.show();

            Log.d("[test]","요청 : "+getRequestURI());
        }
        //when connection is fail
        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog=null;

        }

        //call when success code is 200
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String result = new String(responseBody);
        textView.setText(result);
        }

        //call when success code isn't 200
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this,"fail connection",Toast.LENGTH_SHORT).show();
        }
    }
}