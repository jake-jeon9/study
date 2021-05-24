package com.example.a4_listitemcheckexam.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a4_listitemcheckexam.R;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<Flower> {
    Activity activity;
    int resource;


    public FlowerAdapter(@NonNull Context context, int resource, @NonNull List<Flower> objects) {
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

        final Flower item = getItem(position);

        if(item != null) {
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);
            CheckBox checkBox = convertView.findViewById(R.id.checkBox);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDescription());

            //체크박스의 이벤트처리
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    item.setCheck(isChecked);
                }
            });

            //자바 빈즈의 객체가 갖고 있는 상태값으로, 체크박스의 상태를 강제로 재설정
            checkBox.setChecked(item.isCheck());
        }

        return convertView;
    }
}
