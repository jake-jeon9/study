package com.example.jsonimagelisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.example.jsonimagelisttest.model.Job;
import com.example.jsonimagelisttest.reponse.JobResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    List<Job> list;
    AsyncHttpClient client;
    JobAdapter adapter;
    JobResponse response;
    boolean renew = false;

    String url = "http://192.168.0.180:8085/server_data/job.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("[test]","MainonCreate 생성됨");
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();

        adapter = new JobAdapter(this,R.layout.list_item,list);
        client = new AsyncHttpClient();
        response = new JobResponse(this,adapter);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("[test]","Main-onItemClick 생성됨");
        Intent intent = new Intent(this,Item_detailActivity.class);
        intent.putExtra("item",adapter.getItem(position));
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("[test]","Main-onResume 생성됨");
        if(!renew){
            client.get(url,response);
            renew  =true;
        }

    }
}