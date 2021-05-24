package com.example.practice3.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.practice3.R;
import com.example.practice3.model.Job;

import java.util.List;

public class JobAdapter extends PagerAdapter {
    private  List<Job> list;
    private Activity activity;


    public JobAdapter(List<Job> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    public void add(Job job){
        list.add(job);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_list,null);

        final Job job = list.get(position);

        TextView textView1 = itemView.findViewById(R.id.textView1);
        TextView textView2 = itemView.findViewById(R.id.textView2);
        ImageView imageView = itemView.findViewById(R.id.imageView);

        textView1.setText(job.getJob());
        textView2.setText(job.getDescription());
        imageView.setImageResource(job.getImage());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,job.getDescription(),Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(itemView,0);

        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
