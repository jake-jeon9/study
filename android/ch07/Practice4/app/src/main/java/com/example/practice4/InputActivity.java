package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice4.medel.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonadd,buttonBack;
    EditText editTextName,editTextEmail,editTextPhone,editTextAddr;
    List<Member> list;
    MainActivity mainActivity;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        editTextAddr = findViewById(R.id.editTextAddr);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);

        buttonadd = findViewById(R.id.buttonAdd);
        buttonBack = findViewById(R.id.buttonBack);

        buttonadd.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        //일방적으로 데이터를 보내게 되면 이것도 필요없음.
        if(getIntent().getSerializableExtra("list") !=null){
            list = (List<Member>) getIntent().getSerializableExtra("list");
        }else{
            list = new ArrayList<>();
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonAdd){
            addNewMember();
        }else if(v.getId()==R.id.buttonBack){
            Intent intent = new Intent();
            //데이터 전체 공유 작업
            intent.putExtra("list", (Serializable) list);
            //아래는 데이터만 받아서 보내는 작업
            //intent.putExtra("member", (Serializable) member);
            setResult(RESULT_OK,intent);
            finish();
        }

    }

    private void addNewMember() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String addr = editTextAddr.getText().toString().trim();

        int beforeSize = list.size();
        member = new Member(name, email, phone, addr);
        //리스트를 보낼떄
        list.add(member);
        int afterSize = list.size();
        String msg1 = "저장성공";
        if (afterSize == beforeSize) {
            msg1 = "파일 실패";
        }
        
        //일방적으로 데이터만 쏴줄 때.
        //member =new Member(name, email, phone, addr);

        Toast.makeText(this, msg1, Toast.LENGTH_SHORT).show();

        editTextAddr.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextName.setText("");
        editTextName.requestFocus();
    }
}