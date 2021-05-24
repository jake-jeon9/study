package com.example.fragmentexam7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class RightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView =inflater.inflate(R.layout.fragment_right, container, false);
        return rootView;
    }

    public void updata(Job job){
        TextView textView1 = getView().findViewById(R.id.textView1);
        TextView textView2 = getView().findViewById(R.id.textView2);
        ImageView imageView = getView().findViewById(R.id.imageView);

        textView1.setText(job.getJob());
        textView2.setText(job.getDescription());
        imageView.setImageResource(job.getImage());
    }

}