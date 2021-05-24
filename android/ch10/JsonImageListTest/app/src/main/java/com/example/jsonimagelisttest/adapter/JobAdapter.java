package com.example.jsonimagelisttest.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jsonimagelisttest.R;
import com.example.jsonimagelisttest.model.Job;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class JobAdapter extends ArrayAdapter<Job> {


    Activity activity;
    int resource;

    ImageLoader imageLoader;
    DisplayImageOptions options;

    public JobAdapter(@NonNull Context context, int resource, @NonNull List<Job> objects) {
        super(context, resource, objects);
        Log.d("[test]","JobAdapter 생성됨");
        activity = (Activity)context;
        this.resource = resource;

        imageLoaderInit();

    }

    private void imageLoaderInit() {
        imageLoader = ImageLoader.getInstance();
        Log.d("[test]","imageLoaderInit 생성됨");

        if(!imageLoader.isInited()){
            ImageLoaderConfiguration configuration =ImageLoaderConfiguration.createDefault(activity);
            imageLoader.init(configuration);
        }

    DisplayImageOptions.Builder builder =new DisplayImageOptions.Builder();

        builder.showImageOnLoading(R.drawable.ic_stub);
        builder.showImageOnFail(R.drawable.ic_error);
        builder.showImageForEmptyUri(R.drawable.ic_empty);
        options = builder.build();

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("[test]","getView 생성됨");
        if(convertView ==null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Job item = getItem(position);

        if(item != null){
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            ImageView imageView = convertView.findViewById(R.id.imageView);

            textView1.setText(item.getJob());
            textView2.setText(item.getContent());
            imageLoader.displayImage(item.getImg(),imageView,options);




        }

        return convertView;
    }
}
