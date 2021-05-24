package com.example.a1_jsonimagelistexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a1_jsonimagelistexam.adapter.ColumnAdapter;
import com.example.a1_jsonimagelistexam.model.Column;
import com.example.a1_jsonimagelistexam.response.ColumnResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener , View.OnClickListener {
    LinearLayout linearLayoutsub;
    List<Column> list;
    ColumnAdapter adapter;
    ColumnResponse response;
    ListView listView;
    AsyncHttpClient client;
    String url = "http://192.168.0.180:8085/server_data/column.json";

    //ImageLoader imageLoader;
    //DisplayImageOptions options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutsub = findViewById(R.id.detail);


        list = new ArrayList<>();
        adapter = new ColumnAdapter(this,R.layout.list_item,list);
        response = new ColumnResponse(this,adapter);

        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setVisibility(View.VISIBLE);
        linearLayoutsub.setVisibility(View.GONE);

        linearLayoutsub.setOnClickListener(this);

        //imageLoader = ImageLoader.getInstance();
        //options = adapter.getOptions();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //layout 화면 전환 방법으로 꽃이름,꽃말,꽃이미지를 출력하기
        Column item = adapter.getItem(position);

        TextView textViewsub = findViewById(R.id.textViewSub);
        TextView textViewcontent = findViewById(R.id.textViewCon);
        ImageView imageView = findViewById(R.id.imageViewBig);
        imageView.setImageBitmap(null);
        textViewsub.setText(item.getSubject());
        textViewcontent.setText(item.getContent());
       // imageLoader.displayImage(item.getImg(),imageView);
        ImageLoader.getInstance().displayImage(item.getImg(),imageView);
        listView.setVisibility(View.GONE);
        linearLayoutsub.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onResume() {
        super.onResume();
        client.get(url,response);
    }

    @Override
    public void onClick(View v) {
        listView.setVisibility(View.VISIBLE);
        linearLayoutsub.setVisibility(View.GONE);


    }
}