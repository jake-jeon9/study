package com.example.a4_jsonlistexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a4_jsonlistexam.model.Device;
import com.example.a4_jsonlistexam.R;

import java.util.List;

public class DeviceAdapter extends ArrayAdapter<Device> {
    Activity activity;
    int resource;

    public DeviceAdapter(@NonNull Context context, int resource, @NonNull List<Device> objects) {
        super(context, resource, objects);
        activity = (Activity)context;
        this.resource = resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }

        Device item = getItem(position);
        if(item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            textView1.setText(item.getName());
            textView2.setText(item.getType());
        }
        return convertView;
    }
}
