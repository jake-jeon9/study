package com.example.fragmentexam7;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterList extends ArrayAdapter<Job> {

    Activity activity;
    int resource;

    public AdapterList(@NonNull Context context, int resource, List<Job> objects) {
        super(context, resource);
        activity = (Activity)context;
        this.resource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Job item  =getItem(position);

        if(item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            ImageView imageView = convertView.findViewById(R.id.imageView);

            textView1.setText(item.getJob());
            textView2.setText(item.getDescription());
            imageView.setImageResource(item.getImage());

        }

        return convertView;
    }
}
