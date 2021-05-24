package com.example.a6_cleartopexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Join2Activity extends AppCompatActivity implements View.OnClickListener {
    String id,pw;
    CheckBox checkBox1,checkBox2,checkBox3;
    String[] hobby;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        button = findViewById(R.id.button3);

        button.setOnClickListener(this);

        id = getIntent().getStringExtra("id");
        pw = getIntent().getStringExtra("pw");
        hobby = new String[]{"독서", "음악감상", "등산"};

    }

    @Override
    public void onClick(View v) {
        String hobby_result = "";
        if(checkBox1.isChecked()){
            hobby_result += hobby[0]+" ";
        }
        if(checkBox2.isChecked()){
            hobby_result += hobby[1]+" ";
        }
        if(checkBox3.isChecked()){
            hobby_result += hobby[2]+" ";
        }

        Intent intent = new Intent(this,Join3Activity.class);
        intent.putExtra("id",id);
        intent.putExtra("pw",pw);
        intent.putExtra("hobby_result",hobby_result);
//        setResult(RESULT_OK,intent);

        startActivity(intent);
        finish();


    }
}