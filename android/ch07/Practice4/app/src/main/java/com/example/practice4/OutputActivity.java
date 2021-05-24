package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice4.medel.Member;

import java.util.ArrayList;
import java.util.List;

public class OutputActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonBack;
    TableRow row;

    TableLayout tableLayout;
    List<Member> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        tableLayout = findViewById(R.id.tableLayout);
        buttonBack = findViewById(R.id.buttonBack2);
        list = new ArrayList<>();
        buttonBack.setOnClickListener(this);

        setList();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonBack2){
            finish();

        }
    }

    public void setList() {
        Intent getIntent = getIntent();
        tableLayout.removeAllViews();
        if(list != null ){
            list = (List<Member>) getIntent.getSerializableExtra("list");

            if (list.size() > 0) {
                String name = list.get(0).getName();
                Toast.makeText(this,name+"을 가져옴",Toast.LENGTH_SHORT).show();
                TextView textViewName,textViewEmail,textViewPhone,textViewAddr;

                for (Member member : list) {
                    row = (TableRow) getLayoutInflater().inflate(R.layout.memberlist,null);
                    textViewName = row.findViewById(R.id.textViewName);
                    textViewEmail = row.findViewById(R.id.textViewEmail);
                    textViewPhone = row.findViewById(R.id.textViewPhone);
                    textViewAddr = row.findViewById(R.id.textViewAddr);

                    textViewName.setText(member.getName());
                    textViewEmail.setText(member.getEmail());
                    textViewPhone.setText(member.getPhone());
                    textViewAddr.setText(member.getAddr());

                    tableLayout.addView(row);
                }
            } else {
                Toast.makeText(this,"불러올 항목이 없습니다.",Toast.LENGTH_SHORT).show();
            }
        }

    }
}