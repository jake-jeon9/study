package com.example.a4_jsonlistexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a4_jsonlistexam.adapter.DeviceAdapter;
import com.example.a4_jsonlistexam.model.Device;
import com.example.a4_jsonlistexam.response.DeviceResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //객체
    List<Device> list;
    DeviceAdapter adapter;
    ListView listView;
    AsyncHttpClient client;
    DeviceResponse response;
    String url = "http://192.168.0.180:8085/server_data/list.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //초기화
        list = new ArrayList<>();
        adapter = new DeviceAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new DeviceResponse(this,adapter);

        ///listview 설정
        listView.setAdapter(adapter);


        //listview event 설정
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Device item = adapter.getItem(position);
        String result = item.getName() + " / " +item.getType();
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get(url,response);
    }
}