package com.example.fragmentexam5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SampleViewerFragment extends Fragment {

    String[] imageTitles = {"Dream 01","Dream 02","Dream 03"};
    int[] imageIds= {R.drawable.dream01,R.drawable.dream02,R.drawable.dream03};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_image_viwer,container,false);
    }

    //선택된 이미지로 업데이트
    public void update(int index){
        TextView textView = getView().findViewById(R.id.textView);
        ImageView imageView = getView().findViewById(R.id.imageView);

        textView.setText(imageTitles[index]);
        imageView.setImageResource(imageIds[index]);
    }

}
