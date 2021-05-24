package com.example.basic1exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(linearLayout);
    }

    private void init() {
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        textView = new TextView(this);
        textView.setText("hello, android");
        textView.setTextSize(30);
        linearLayout.addView(textView);

        //컴포넌트의 가로,세로 크기

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT
        );

        button = new Button(this);
        button.setText("확인");
        button.setTextSize(30);
        button.setLayoutParams(params);//가로 /세로 길이 설정
        linearLayout.addView(button);
    }



}