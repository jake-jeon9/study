package com.example.practice1.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.practice1.R;

import java.util.List;

public class JobAdapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;

    public JobAdapter(@NonNull Context context, int resource, @NonNull List<Job> objects) {
        super(context, resource, objects);
        activity = (Activity)context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView ==null){
            convertView = activity.getLayoutInflater().inflate(resource,null);

        }
        Job item = getItem(position);

        if(item !=null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            ImageView imageView =convertView.findViewById(R.id.imageView);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getJob());
            textView2.setText(item.getDescription());

        }


        return convertView;
    }
}
