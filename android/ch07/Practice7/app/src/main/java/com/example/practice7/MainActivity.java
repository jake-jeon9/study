package com.example.practice7;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.practice7.model.Member;
import com.example.practice7.server.MemberDAO;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonInsert, buttonList, buttonEdit, buttonDelete;
    LinearLayout linearLayoutmain, linearLayoutContaniner;

    EditText editTextSearchName;
    String subject;
    InputFragment inputFragment;
    OutputFragment outputFragment;
    DeleteFragment deleteFragment;
    ModifyFragment modifyFragment;

    String resultSearchName;
    MemberDAO memberDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonList = findViewById(R.id.buttonList);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonEdit = findViewById(R.id.buttonEdit);

        linearLayoutContaniner = findViewById(R.id.container);
        linearLayoutmain = findViewById(R.id.main);

        buttonList.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);

        Intent intent = new Intent(this, LodaingActivity.class);
        startActivity(intent);

        linearLayoutmain.setVisibility(View.VISIBLE);

        outputFragment = new OutputFragment();
        inputFragment = new InputFragment();
        modifyFragment = new ModifyFragment();
        deleteFragment = new DeleteFragment();


        memberDAO = new MemberDAO(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInsert:
                linearLayoutmain.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, inputFragment, null).commit();
                break;

            case R.id.buttonList:
                linearLayoutmain.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, outputFragment, null).commit();
                break;

            case R.id.buttonEdit:
                subject = "수정";
                showDialog(subject, modifyFragment);
                break;

            case R.id.buttonDelete:
                subject = "삭제";
                showDialog(subject, deleteFragment);

                break;
        }
    }

    private void showDialog(String subject, final Fragment fragment) {
        final View searchName = getLayoutInflater().inflate(R.layout.dialog_layout, null);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(subject + "할 이름 검색");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);

        builder.setView(searchName);
        editTextSearchName = searchName.findViewById(R.id.editTextSearch);

        //긍정버튼추가
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resultSearchName = editTextSearchName.getText().toString().trim();

                boolean result = memberDAO.searchName(resultSearchName);
                if (result) {
                    linearLayoutmain.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, null).commit();
                } else {
                    Toast.makeText(getApplicationContext(), "검색한 이름이 없습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        //부정버튼추가
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linearLayoutmain.setVisibility(View.VISIBLE);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}