package com.example.a10_togglebuttonexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Button button;
    TextView textView1, textView2;
    ToggleButton toggleButton1, toggleButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        toggleButton1 = findViewById(R.id.toggleButton1);
        toggleButton2 = findViewById(R.id.toggleButton2);
        button = findViewById(R.id.button);

        //두번째 토글버튼을 on 상태로 설정
        toggleButton1.setChecked(true);

        toggleButton1.setOnCheckedChangeListener(this);
        toggleButton2.setOnCheckedChangeListener(this);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //각 toggle 값 받기
        boolean getToggleData1 = toggleButton1.isChecked();
        boolean getToggleData2 = toggleButton2.isChecked();
        String msg1 = "";
        String msg2 = "";

        if (getToggleData1) {
            msg1 = "켜져있다";
        } else {
            msg1 = "꺼져있다~";
        }
        if (getToggleData2) {
            msg2 = "켜져있다";
        } else {
            msg2 = "꺼져있다~";
        }

        Toast.makeText(this, "토글 1 : " + msg1 + "\n" + "토글 2 : " + msg2 + "\n", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.toggleButton1:
                if(isChecked){
                    textView1.setText(toggleButton1.getTextOn());
                }else{
                    textView1.setText(toggleButton1.getTextOff());
                }

                break;
            case R.id.toggleButton2:
                if(isChecked){
                    textView2.setText("눌러짐");
                }else{
                    textView2.setText("취소됨....");
                }
                break;
        }
    }
}