package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button;
    AsyncHttpClient client;
    String url ="http://192.168.0.180:8085/server_data/simple_score.json";
    HttpResponse response ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        client = new AsyncHttpClient();
        response = new HttpResponse();

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        client.get(url,response);
    }

    class HttpResponse extends AsyncHttpResponseHandler{

        @Override
        public void onSuccess(int i, Header[] headers, byte[] bytes) {
        String result = new String(bytes);

            try {
                JSONObject json = new JSONObject(result);
                JSONObject student1 = json.getJSONObject("student1");

                /*
                JSONArray array = student1.getJSONArray("name");
                JSONArray array = new JSONArray(student1);
                JSONArray name = array.getJSONArray("name");
                JSONArray kor = student1.getJSONArray("kor");
                JSONArray eng = student1.getJSONArray("eng");
                JSONArray mat = student1.getJSONArray("mat");
                String[] getname = new String[student1.length()];
                int[] getKor = new int[student1.length()];
                int[] getEng = new int[student1.length()];
                int[] getMat = new int[student1.length()];

                String fi_result = "";
                for(int k = 0;k<student1.length();k++){
                    getname[k] = array.getString(k);
                    getKor[k] = array.getInt(k);
                    getEng[k] = array.getInt(k);
                    getMat[k] = array.getInt(k);
                    fi_result +=  getname[k]+", "+getKor[k]+", "+ getEng[k]+", "+getMat[k]+"\n";
                }
                 textView.setText(fi_result);
                 */


                String name = student1.getString("name");
                int kor = student1.getInt("kor");
                int eng = student1.getInt("eng");
                int mat = student1.getInt("mat");
                int tot =kor+eng+mat;
                double avg = tot/3.0;
                textView.setText("이름 : "+name+"\n국어 : "+kor+"\n영어 : " + eng+"\n수학 : "+mat+"\n합계 : "+tot+"\n평균 : "+avg);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
            Toast.makeText(MainActivity.this,"통신 실패",Toast.LENGTH_SHORT).show();
        }
    }

}