package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.practice.model.Member;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonInsert, buttonList;
    LinearLayout linearLayoutmain, linearLayoutContaniner;

    /*
    String dbName = "fragmentDB.db";
    String tableName = "fragmentTalbe";
    SQLiteDatabase db;
    String sql;
     */

    InputFragment inputFragment;
    OutputFragment outputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsert = findViewById(R.id.buttonInsert);
        buttonList = findViewById(R.id.buttonList);

        linearLayoutContaniner = findViewById(R.id.container);
        linearLayoutmain = findViewById(R.id.main);

        buttonList.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);

        if (savedInstanceState == null) linearLayoutmain.setVisibility(View.VISIBLE);
        //createDB();
        //createTable();

        //inputFragment = new InputFragment(db,tableName);
        //outputFragment = new OutputFragment(db,tableName);

        outputFragment = new OutputFragment();
        inputFragment = new InputFragment();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonInsert) {
            linearLayoutmain.setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, inputFragment, null).commit();
        } else if (v.getId() == R.id.buttonList) {
            linearLayoutmain.setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, outputFragment, null).commit();
        }
    }
    /*
    private void createTable() {
        try {
            if (db != null) {
                sql = "CREATE TABLE IF NOT EXISTS " + tableName + "( _id integer PRIMARY KEY autoincrement,"
                        + "name text,"
                        + "email text,"
                        + "phone text,"
                        + "address text);";
                db.execSQL(sql);
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
            db = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, dbName + "이 열렸습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, dbName + "로드 실패...", Toast.LENGTH_SHORT).show();
        }
    }
    */
}