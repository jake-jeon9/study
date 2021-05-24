package com.example.a3_listadapterexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a3_listadapterexam.jobAdapter.JobAdapterForClick;
import com.example.a3_listadapterexam.model.Job;

import java.io.Serializable;
import java.util.List;

public class pageviewActivity extends AppCompatActivity  {

    JobAdapterForClick adapter;
    ViewPager viewPager;
    List<Job> list;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pageview);
        list = (List<Job>) getIntent().getSerializableExtra("list");

        position = getIntent().getIntExtra("position",0);
        adapter=new JobAdapterForClick(list,this);

        viewPager = findViewById(R.id.viewlayout);
        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(position);
    }
}