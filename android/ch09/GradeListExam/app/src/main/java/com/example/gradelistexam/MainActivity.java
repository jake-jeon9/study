package com.example.gradelistexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gradelistexam.adapter.ListAdapter;
import com.example.gradelistexam.model.Score;
import com.example.gradelistexam.response.HttpResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    List<Score> list;
    HttpResponse response;
    ListAdapter adapter;
    ListView listView;
    AsyncHttpClient client;
    String uri = "http://192.168.0.180:8085/server_data/score.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new ListAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new HttpResponse(this,adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Score item = adapter.getItem(position);
        int total = +item.getKor() +item.getEng() +item.getMat();
        double avg = total/3.0;
        String result = "이름 : "+item.getName() + "\n국어 : " +item.getKor() + "\n영어 :  " +item.getEng()
                + " \n수학 : " +item.getMat()+"\n총점 : "+total+"\n평균 :" + String.format("%.2f",avg);

        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        client.get(uri,response);
    }
}