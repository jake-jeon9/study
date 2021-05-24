package com.example.a6_cleartopexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    EditText editText1,editText2;
    String id,pw;

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
                String chkId = editText1.getText().toString();
                String chkPw = editText2.getText().toString();
                String result="";
                if(editText1.getText().equals("")||editText2.getText().equals("")||chkId==null||chkPw==null){
                    System.out.println(editText2.getText().equals(""));
                    Toast.makeText(this,"아이디 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                }else{

                    if(chkId.equals(id)&&chkPw.equals(pw)){
                        result= "로그인 성공!\n아이디 : "+chkId +"\n 패스워드 : " + chkPw;
                        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
                    }else{
                        result= "로그인 실패..저장된 데이터\n아이디 : "+id +"\n 패스워드 : " + pw;
                        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.button2 :
                Intent intent = new Intent(this,Join1Activity.class);
                startActivityForResult(intent,100);

                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode==100){
        //System.out.println("리퀘스트 : "+requestCode);
        //System.out.println("리절트 :" + resultCode);
           if(resultCode==RESULT_OK){

                String result="";
                id =data.getStringExtra("id");
                pw =data.getStringExtra("pw");

                result= "아이디 : "+id +"\n 패스워드 : " + pw;
                Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"값 불러오기 실패함",Toast.LENGTH_SHORT).show();
            }
       }


    }
}