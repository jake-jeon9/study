package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MemberActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2,button3,button4;
    EditText editText1,editText2,editText;
    CheckBox checkBox1,checkBox2,checkBox3;
    String id,pw,age;
    String[] hobby;
    LinearLayout frameLayout1,frameLayout2,frameLayout3;
    String hobby_result = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        button1 = findViewById(R.id.buttonFirst);
        button2 = findViewById(R.id.buttonSecond);
        button3 = findViewById(R.id.buttonThird);
        button4 = findViewById(R.id.buttonCancel);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText = findViewById(R.id.editText);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        frameLayout1 = findViewById(R.id.fream1);
        frameLayout2 = findViewById(R.id.fream2);
        frameLayout3 = findViewById(R.id.fream3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        frameLayout1.setVisibility(View.VISIBLE);
        frameLayout2.setVisibility(View.GONE);
        frameLayout3.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonFirst :

                id = editText1.getText().toString().trim();
                pw = editText2.getText().toString().trim();

                if(id.equals("")||id == null){
                    Toast.makeText(this,"아이디를 입력하세요.",Toast.LENGTH_SHORT).show();
                }else if(pw.equals("")||pw==null){
                    Toast.makeText(this,"패스워드 입력하세요.",Toast.LENGTH_SHORT).show();
                }else{
                    frameLayout1.setVisibility(View.GONE);
                    frameLayout2.setVisibility(View.VISIBLE);
                    frameLayout3.setVisibility(View.GONE);
                }
                break;

            case R.id.buttonSecond :
                hobby = new String[]{checkBox1.getText().toString(),checkBox2.getText().toString(),checkBox3.getText().toString()};

                if(checkBox1.isChecked()){
                    hobby_result += hobby[0]+" ";

                }
                if(checkBox2.isChecked()){
                    hobby_result += hobby[1]+" ";
                }
                if(checkBox3.isChecked()){
                    hobby_result += hobby[2]+" ";
                }

                if(!checkBox1.isChecked()&&!checkBox2.isChecked()&&!checkBox3.isChecked()){
                    Toast.makeText(this,"취미를 1개 이상 체크해주세요.",Toast.LENGTH_SHORT).show();
                }else{
                    frameLayout1.setVisibility(View.GONE);
                    frameLayout2.setVisibility(View.GONE);
                    frameLayout3.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.buttonThird :
                age = editText.getText().toString();

                if(age.equals("")||age ==null){
                    Toast.makeText(this,"나이를 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(this,MainActivity.class);

                    intent.putExtra("id",id);
                    intent.putExtra("pw",pw);
                    intent.putExtra("hobby",hobby_result);
                    intent.putExtra("age",age);
                    setResult(RESULT_OK,intent);
                    finish();
                }

                break;
            case R.id.buttonCancel :
                finish();
                break;
        }


    }
}