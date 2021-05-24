package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice1.helper.FileInOut;
import com.example.practice1.medel.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout[] layouts = new LinearLayout[3];
    Button buttonInsert, buttonList, buttonSave, buttonRead, buttonAdd, buttonBack1, buttonBack2;
    EditText editTextName, editTextEmail, editTextPhone, editTextAddr;
    TextView textViewGetList;

    List<Member> list;
    String fname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layouts[0] = findViewById(R.id.mainLayout);
        layouts[1] = findViewById(R.id.insertLayout);
        layouts[2] = findViewById(R.id.memberLayout);

        // linearLayoutMain = findViewById(R.id.mainLayout);
        //linearLayoutInsert = findViewById(R.id.insertLayout);
        //linearLayoutMember = findViewById(R.id.memberLayout);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonList = findViewById(R.id.buttonList);
        buttonSave = findViewById(R.id.buttonSave);
        buttonRead = findViewById(R.id.buttonRead);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonBack1 = findViewById(R.id.buttonBack);
        buttonBack2 = findViewById(R.id.buttonBack2);

        editTextAddr = findViewById(R.id.editTextAddr);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);

        textViewGetList = findViewById(R.id.textViewGetList);

        buttonInsert.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonSave.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        list = new ArrayList<>();

        setLayout(R.id.mainLayout);
    }

    @Override
    public void onClick(View v) {
        //파일 경로 설정 : 내 앱 폴더에 저장
        fname = getFilesDir().getAbsolutePath() + "/myMemberList.txt";

        switch (v.getId()) {
            case R.id.buttonInsert:
                setLayout(R.id.insertLayout);
                break;
            case R.id.buttonList:
                goToList();
                setLayout(R.id.memberLayout);
                break;
            case R.id.buttonSave:
                saveFile();
                break;
            case R.id.buttonRead:
                readFile();
                break;
            case R.id.buttonAdd:
                addMember();
                break;
            case R.id.buttonBack:
                setLayout(R.id.mainLayout);
                break;
            case R.id.buttonBack2:
                setLayout(R.id.mainLayout);
                break;

        }

    }

    private void goToList() {
        String getList = "";
        if (list.size() > 0) {
            for (Member member : list) {
                getList += member.getName() + ", " + member.getEmail()
                        + ", " + member.getPhone() + ", " + member.getAddr() + "\n";
            }
        } else {
            getList = "불러올 항목이 없습니다.";
        }
        textViewGetList.setText(getList);
    }

    private void saveFile() {
        boolean result1 = FileInOut.getInstance().write(fname, list);
        String msg = "저장성공";
        if (!result1) {
            msg = "파일 실패";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    private void readFile() {
        list.clear();
        list = FileInOut.getInstance().read(fname);

        String result4 = "불러오기 성공, 목록보기를 클릭해주세요.";
        if (list.size() < 1) {
            result4 = "불러오기 실패, 다시 시도해주세요.";
        }
        Toast.makeText(this, result4, Toast.LENGTH_SHORT).show();

    }

    private void addMember() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String addr = editTextAddr.getText().toString().trim();
        int beforeSize = list.size();
        Member member = new Member(name, email, phone, addr);
        list.add(member);
        int afterSize = list.size();
        String msg1 = "저장성공";
        if (afterSize == beforeSize) {
            msg1 = "파일 실패";
        }
        Toast.makeText(this, msg1, Toast.LENGTH_SHORT).show();

        editTextAddr.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextName.setText("");
        editTextName.requestFocus();
    }

    public void setLayout(int layout) {
        for(LinearLayout layoutSet : layouts){
            layoutSet.setVisibility(View.GONE);
        }
        findViewById(layout).setVisibility(View.VISIBLE);
    }
}