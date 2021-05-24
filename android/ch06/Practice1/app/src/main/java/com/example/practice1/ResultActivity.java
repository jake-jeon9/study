package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.practice1.model.Job;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    Job job;
    TextView textView1,textView2;
    ImageView imageView;
    LinearLayout linearLayout;
    //MainActivity mainActivity = (MainActivity) MainActivity.mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        imageView = findViewById(R.id.imageView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        linearLayout = findViewById(R.id.layout);
        //인텐트에서 데이터 꺼내기
        job = (Job)getIntent().getSerializableExtra("job");
        //데이터 셋팅
        imageView.setImageResource(job.getImage());
        textView1.setText(job.getJob());
        textView2.setText(job.getDescription());

        linearLayout.setOnClickListener(this);

        //mainActivity.finish();
    }

    @Override
    public void onClick(View v) {
        finish();;

    }
}