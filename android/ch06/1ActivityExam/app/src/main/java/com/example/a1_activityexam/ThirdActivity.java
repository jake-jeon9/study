package com.example.a1_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    EditText editText;

    SecondActivity secondActivity = (SecondActivity)SecondActivity.secondActivity;
    public static ThirdActivity thirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


        thirdActivity = ThirdActivity.this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button1 :
                secondActivity.finish();

                editText = findViewById(R.id.editTextAge);
                String name = getIntent().getStringExtra("name");
                //화면 이동을 위한 명시적 인텐트 설정
                Intent intent = new Intent(this,ResultActivity.class);
                //인텐트에 데이터 담기
                int age = Integer.parseInt(editText.getText().toString().trim());
                intent.putExtra("age",age);
                intent.putExtra("name",name);

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