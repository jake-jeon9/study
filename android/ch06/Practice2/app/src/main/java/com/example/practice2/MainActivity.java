package com.example.practice2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1,editText2;
    Button button1,button2;
    String id,pw,chkId,chkPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button1 :
                chkId = editText1.getText().toString();
                chkPw = editText2.getText().toString();
                String result="";
                if(editText1.getText().equals("")||editText2.getText().equals("")||chkId==null||chkPw==null){
                    System.out.println(editText2.getText().equals(""));
                    Toast.makeText(this,"아이디 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                }else if(chkId.equals(id)&&chkPw.equals(pw)){
                    Toast.makeText(this,"로그인 성공!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this,"로그인 실패.. 확인 후 다시 시도해주세요.",Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.button2 :
                Intent intent = new Intent(this,MemberActivity.class);
                startActivityForResult(intent,100);

                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100){
            if(resultCode==RESULT_OK){
                id = data.getStringExtra("id");
                pw = data.getStringExtra("pw");
                String hobby = data.getStringExtra("hobby");
                String age = data.getStringExtra("age");

                String result = "아이디 : "+ id +"\n pw : " + pw +"\n취미 : "+hobby+
                            "\n나이 : "+age ;

                Toast.makeText(this,result,Toast.LENGTH_SHORT).show();


            }
        }
    }
}