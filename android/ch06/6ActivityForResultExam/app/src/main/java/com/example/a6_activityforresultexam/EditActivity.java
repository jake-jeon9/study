package com.example.a6_activityforresultexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.editText);
        button1= findViewById(R.id.button1);
        button2= findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        String memo = getIntent().getStringExtra("memo");
        editText.setText(memo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1 :
                String memo = editText.getText().toString();
                //빈 인텐트 생성 : 수정내용을 전달하기 위함, 이동방향 설정 안함.
                Intent intent = new Intent();
                intent.putExtra("memo",memo);
                //성공되었다는 결과와 함꼐, 시스템에 인텐트를 전달함.
                setResult(RESULT_OK, intent);
                //현재 화면 종료
                finish();
                break;
            case R.id.button2 :
                //취소되었다는 결과를 시스템에 전달함
                setResult(RESULT_CANCELED);
                finish();
                break;
        }

    }
}