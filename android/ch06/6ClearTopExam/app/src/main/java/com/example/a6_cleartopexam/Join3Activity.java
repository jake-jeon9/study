package com.example.a6_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Join3Activity extends AppCompatActivity implements View.OnClickListener {
    String id, pw, hobby, age;
    Button button;
    EditText editText;

    boolean gotoback = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join3);

        button = findViewById(R.id.button4);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(this);

        id = getIntent().getStringExtra("id");
        pw = getIntent().getStringExtra("pw");
        hobby = getIntent().getStringExtra("hobby_result");
    }

    @Override
    public void onClick(View v) {
        if (!gotoback) {
            age = editText.getText().toString().trim();
            String result = "아이디 : " + id + "\n비밀번호 : " + pw + "\n취미 : " + hobby + "\n나이 : " + age;
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

            gotoback = true;
        } else {

            Intent intent = new Intent();
            intent.putExtra("id", id);
            intent.putExtra("pw", pw);
            //setResult(RESULT_OK, intent);
            //history stack내용을 지우라는 설정
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //새로 만들지 말고,기존 화면을 불러오는 설정
            //intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //startActivity(intent);
            finish();
        }

    }
}