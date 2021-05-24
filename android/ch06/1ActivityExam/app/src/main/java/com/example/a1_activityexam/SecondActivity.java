package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    EditText editText;
    MainActivity main = (MainActivity) MainActivity.main;
    public  static SecondActivity secondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


        main.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button1 :
                secondActivity = SecondActivity.this;

                editText = findViewById(R.id.editTextName);

                //화면 이동을 위한 명시적 인텐트 설정
                Intent intent = new Intent(this,ThirdActivity.class);
                //인텐트에 데이터 담기
                intent.putExtra("name",editText.getText().toString().trim());
                //화면 이동요청
                startActivity(intent);

                break;
            case R.id.button2 :
                //현재 activity화면 종료 ->첫화면에선 앱 종료
                finish();
                break;
        }
    }
}