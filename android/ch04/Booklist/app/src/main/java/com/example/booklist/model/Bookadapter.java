package com.example.booklist.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.booklist.R;

import java.util.List;

public class Bookadapter extends ArrayAdapter<BookList> {
    Activity activity;
    int resource;

    public Bookadapter(@NonNull Context context, int resource, @NonNull List<BookList> objects) {
        super(context, resource, objects);
        activity = (Activity)context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("[TEST]", "position = " + position + ", convertView = " + convertView);
    if(convertView == null){
        convertView = activity.getLayoutInflater().inflate(resource,null);
    }

        BookList item = getItem(position);

        if(item !=null){
            ImageView imageView =convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            TextView textView3 = convertView.findViewById(R.id.textView3);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getSubject());
            textView2.setText(item.getWriter());
            textView3.setText(item.getPublisher());

        }
        return convertView;



    }


}
