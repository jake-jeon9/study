package com.example.practice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice.model.Member;
import com.example.practice.server.MemberDAO;

import java.util.ArrayList;
import java.util.List;


public class OutputFragment extends Fragment implements View.OnClickListener {
    SQLiteDatabase database;
    String tableName;
    Button buttonBack;

    public OutputFragment( SQLiteDatabase database,String tableName) {
        this.database = database;
        this.tableName = tableName;
    }

    public OutputFragment() {
    }

    TableLayout tableLayout;
    TableRow row;
    TextView textViewName,textViewEmail,textViewPhone,textViewAddr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.fragment_output, container, false);

        buttonBack = rootView.findViewById(R.id.buttonBack2);
        tableLayout = rootView.findViewById(R.id.tableLayout);

        buttonBack.setOnClickListener(this);
        goToList();
        return  rootView;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonBack2){
            this.getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
        getActivity().findViewById(R.id.main).setVisibility(View.VISIBLE);
        }
    }

    private void goToList() {
        tableLayout.removeAllViews();
    /*
        if (database != null) {
            try {
                sql = "SELECT name,email,phone,address FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);
                TextView textViewName, textViewEmail, textViewPhone, textViewAddr;

                for (int i = 0; i < cursor.getCount(); i++) {

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
                Toast.makeText(getContext(), "리스트 업 완료", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getContext(), "불러올 항목이 없습니다.", Toast.LENGTH_SHORT).show();
        }

     */
        MemberDAO memberDAO = new MemberDAO(getActivity());
        List<Member> list = memberDAO.goToList();
    for (Member member : list){
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
    }
}