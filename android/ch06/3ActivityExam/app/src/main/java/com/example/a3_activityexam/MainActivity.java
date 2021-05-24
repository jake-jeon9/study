package com.example.a3_activityexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a3_activityexam.model.Answer;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextId,editTextEmail,editTextPw;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextId = findViewById(R.id.editTextId);
        editTextPw = findViewById(R.id.editTextPw);
        button = findViewById(R.id.button);


        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            String id = editTextId.getText().toString().trim();
            String pw = editTextPw.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();

            Answer answer = new Answer(id,pw,email);

            //인텐트
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra("answer", answer);
            startActivity(intent);
    }
}