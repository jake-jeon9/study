package com.example.jsonimagelisttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jsonimagelisttest.model.Job;
import com.nostra13.universalimageloader.core.ImageLoader;

public class Item_detailActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    TextView textView1,textView2,textView3;
    LinearLayout linearLayout;

    String url2 = "http://192.168.0.180:8085/server_data/originalimage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Log.d("[test]","onCreateSub 생성됨");
        imageView=findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        linearLayout = findViewById(R.id.list);
        Job item = (Job) getIntent().getSerializableExtra("item");

        textView1.setText(item.getJob());
        textView2.setText(item.getContent());
        textView3.setText("no."+item.getNum());
        String makeUrl = url2+ item.getImg().substring(item.getImg().lastIndexOf("/"));
        ImageLoader.getInstance().displayImage(item.getImg().replace("images2","orignalImage"),imageView);

        linearLayout.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        Log.d("[test]","onClickSub 생성됨");
        finish();
    }
}