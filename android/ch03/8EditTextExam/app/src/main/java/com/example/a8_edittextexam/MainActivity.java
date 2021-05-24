package com.example.a8_edittextexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String id = editText1.getText().toString().trim();
        String pw = editText2.getText().toString().trim();

        if (id.equals("") || pw.equals("")) {
            Toast.makeText(this, "아이디나 비밀번호가 입력되지 않았습니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, id + " / " + pw, Toast.LENGTH_SHORT).show();
    }
}