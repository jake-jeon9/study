package com.example.practice4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.practice4.helper.FileInOut;
import com.example.practice4.medel.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout mainLayout, insertLayout, memberLayout;
    Button buttoninsert, buttonlist, buttonsave, buttonread;
    List<Member> list;
    String fname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainLayout);
        insertLayout = findViewById(R.id.insertLayout);
        memberLayout = findViewById(R.id.memberLayout);

        buttoninsert = findViewById(R.id.buttonInsert);
        buttonlist = findViewById(R.id.buttonList);
        buttonsave = findViewById(R.id.buttonSave);
        buttonread = findViewById(R.id.buttonRead);

        buttoninsert.setOnClickListener(this);
        buttonlist.setOnClickListener(this);
        buttonsave.setOnClickListener(this);
        buttonread.setOnClickListener(this);

        fname = getFilesDir().getAbsolutePath() + "/myNewMemberList.txt";

        list = new ArrayList<>();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInsert:
                Intent intentIp = new Intent(this, InputActivity.class);
                intentIp.putExtra("list", (Serializable) list);
                //이거 없어도 됨.
                startActivityForResult(intentIp, 100);
                break;
            case R.id.buttonList:
                Intent intentOp = new Intent(this, OutputActivity.class);
                intentOp.putExtra("list", (Serializable) list);
                startActivity(intentOp);
                break;
            case R.id.buttonRead:
                readFile();
                break;
            case R.id.buttonSave:
                saveFile();
                break;
        }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                //list.add((Member)data.getSerializableExtra("member");
                list = (List<Member>) data.getSerializableExtra("list");
            }
        }
    }
}