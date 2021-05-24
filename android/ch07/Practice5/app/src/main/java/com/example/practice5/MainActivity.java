package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout[] layouts = new LinearLayout[3];
    Button buttonInsert, buttonList, buttonAdd, buttonBack1, buttonBack2;
    EditText editTextName, editTextEmail, editTextPhone, editTextAddr;
    TableRow row;
    TableLayout tableLayout;

    List<Member> list;

    String sql;
    String dbName = "memberList.db";
    String tableName = "memberlist";
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layouts[0] = findViewById(R.id.mainLayout);
        layouts[1] = findViewById(R.id.insertLayout);
        layouts[2] = findViewById(R.id.memberLayout);


        buttonInsert = findViewById(R.id.buttonInsert);
        buttonList = findViewById(R.id.buttonList);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonBack1 = findViewById(R.id.buttonBack);
        buttonBack2 = findViewById(R.id.buttonBack2);

        editTextAddr = findViewById(R.id.editTextAddr);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);

        tableLayout = findViewById(R.id.tableLayout);

        buttonInsert.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        list = new ArrayList<>();

        createDB();
        createTable();

        setLayout(R.id.mainLayout);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonInsert:
                setLayout(R.id.insertLayout);
                break;
            case R.id.buttonList:
                goToList();
                setLayout(R.id.memberLayout);
                break;
            case R.id.buttonAdd:
                addMember();
                break;
            case R.id.buttonBack:
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(editTextAddr.getWindowToken(), 0);
                setLayout(R.id.mainLayout);
                break;
            case R.id.buttonBack2:
                setLayout(R.id.mainLayout);
                break;

        }

    }

    private void goToList() {
        tableLayout.removeAllViews();

        if (database != null) {
            try {
                sql = "SELECT name,email,phone,address FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);
                TextView textViewName, textViewEmail, textViewPhone, textViewAddr;

                for (int i = 0; i < cursor.getCount(); i++) {
                  //  while(cursor.moveToNext()){

                   // }
                    cursor.moveToNext();
                    Member member = new Member(cursor.getString(0), cursor.getString(1),
                            cursor.getString(2), cursor.getString(3));

                    row = (TableRow) getLayoutInflater().inflate(R.layout.memberlist, null);
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
                cursor.close();
                Toast.makeText(this, "리스트 업 완료", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "불러올 항목이 없습니다.", Toast.LENGTH_SHORT).show();
        }

    }

    private void addMember() {

        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String addr = editTextAddr.getText().toString().trim();

        if (name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
            Toast.makeText(this, "정보를 입력해주세요", Toast.LENGTH_SHORT).show();
        } else if (database != null) {
            try {
                sql = "INSERT INTO " + tableName + "(name,email,phone,address) values('"
                        + name + "','" + email + "','" + phone + "','" + addr + "');";
                database.execSQL(sql);
                Toast.makeText(this, name + "님의 데이터가 저장되었습니다.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(this, "DB를 먼저 생성해주세요.", Toast.LENGTH_SHORT).show();
        }

        Member member = new Member(name, email, phone, addr);

        list.add(member);

        String msg1 = "저장성공";

        Toast.makeText(this, msg1, Toast.LENGTH_SHORT).show();

        editTextAddr.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextName.setText("");
        editTextName.requestFocus();
    }

    public void setLayout(int layout) {
        for (LinearLayout layoutSet : layouts) {
            layoutSet.setVisibility(View.GONE);
        }
        findViewById(layout).setVisibility(View.VISIBLE);
    }

    private void createTable() {
        try {
            if (database != null) {
                sql = "CREATE TABLE IF NOT EXISTS " + tableName + "( _id integer PRIMARY KEY autoincrement,"
                        + "name text,"
                        + "email text,"
                        + "phone text,"
                        + "address text);";

                database.execSQL(sql);
                Toast.makeText(this, tableName + "이 생성되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "DB를 먼저 생성해주세요.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDB() {
        try {
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, dbName + "를 열었습니다..", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, dbName + "로드 실패...", Toast.LENGTH_SHORT).show();
        }
    }
}