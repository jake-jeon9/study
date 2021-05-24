package com.example.practice.server;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.practice.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    Activity activity;

    public MemberDAO(Context context) {
        activity = (Activity) context;
        createDB();
        createTable();
    }


    //DB
    String dbName = "fragmentDB.db";
    String tableName = "fragmentTalbe";
    SQLiteDatabase database;
    String sql;

    private void createTable() {
        try {
            if (database != null) {
                sql = "CREATE TABLE IF NOT EXISTS " + tableName + "( _id integer PRIMARY KEY autoincrement,"
                        + "name text,"
                        + "email text,"
                        + "phone text,"
                        + "address text);";
                database.execSQL(sql);
                Toast.makeText(activity, tableName + "이 생성되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(activity, "DB를 먼저 생성해주세요.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDB() {
        try {
            database = activity.openOrCreateDatabase(dbName, activity.MODE_PRIVATE, null);
            Toast.makeText(activity, dbName + "이 열렸습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(activity, dbName + "로드 실패...", Toast.LENGTH_SHORT).show();
        }
    }

    public void addData(Member member) {
        if (database != null) {
            try {
                sql = "INSERT INTO " + tableName + "(name,email,phone,address) values('"
                        + member.getName() + "','" + member.getEmail() + "','" + member.getPhone() + "','" + member.getAddr() + "');";
                database.execSQL(sql);
                Toast.makeText(activity, member.getName() + "님의 데이터가 저장되었습니다.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(activity, "DB를 먼저 생성해주세요.", Toast.LENGTH_SHORT).show();
        }

    }

    public List<Member> goToList() {
        List<Member> list = new ArrayList<>();

        if (database != null) {
            try {
                sql = "SELECT name,email,phone,address FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);

             while(cursor.moveToNext()){
                    Member member = new Member(cursor.getString(0), cursor.getString(1),
                            cursor.getString(2), cursor.getString(3));
                    list.add(member);
                }

                cursor.close();
                Toast.makeText(activity, "리스트 업 완료", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(activity, "불러올 항목이 없습니다.", Toast.LENGTH_SHORT).show();
        }
        return list;
    }

}
