package com.example.fragmentexam6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RightFragment extends Fragment {

    String[] imageTitles = {"Dream 01","Dream 02","Dream 03"};
    int[] imageIds= {R.drawable.dream01,R.drawable.dream02,R.drawable.dream03};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right, container, false);
    }

    //선택된 이미지로 업데이트
    public void update(int index){
        TextView textView = getView().findViewById(R.id.textView);
        ImageView imageView = getView().findViewById(R.id.imageView);

        textView.setText(imageTitles[index]);
        imageView.setImageResource(imageIds[index]);
    }
}