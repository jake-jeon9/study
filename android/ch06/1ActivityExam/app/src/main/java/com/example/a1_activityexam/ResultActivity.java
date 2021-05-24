package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    //이전화면에서 넘어온 데이터저장
    String name;
    int age;

    ThirdActivity thirdActivity = (ThirdActivity)ThirdActivity.thirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        age = intent.getIntExtra("age",0);
        String result ="이름 : <font color='blue'>"+name+"</font>님\n나이 <font color='red'>: "+age+"살"+"</font>입니다만;";
        textView.setText(Html.fromHtml(result));


        thirdActivity.finish();
    }
}