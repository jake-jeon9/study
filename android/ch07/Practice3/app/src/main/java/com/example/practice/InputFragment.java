package com.example.practice;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.practice.model.Member;
import com.example.practice.server.MemberDAO;


public class InputFragment extends Fragment implements View.OnClickListener {
    Button buttonAdd,buttonBack1;
    EditText editTextName,editTextEmail, editTextPhone, editTextAddr;
    LinearLayout linearLayout;

    SQLiteDatabase database;
    String tableName;

    //생성자를 통한 객체 얻기
    public InputFragment(SQLiteDatabase database,String tableName) {
        this.tableName = tableName;
        this.database = database;
    }

    public InputFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_input, container, false);

        linearLayout = rootView.findViewById(R.id.main);
        editTextAddr = rootView.findViewById(R.id.editTextAddr);
        editTextEmail = rootView.findViewById(R.id.editTextEmail);
        editTextName = rootView.findViewById(R.id.editTextName);
        editTextPhone = rootView.findViewById(R.id.editTextPhone);

        buttonAdd = rootView.findViewById(R.id.buttonAdd);
        buttonBack1= rootView.findViewById(R.id.buttonBack);

        buttonBack1.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);

        database = null;
        //메인액비티티에서 얻어옴
        //database = ((MainActivity) getActivity()).db;
        return rootView;
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.buttonAdd){
            addData();
        }else if(v.getId()==R.id.buttonBack){
            this.getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            getActivity().findViewById(R.id.main).setVisibility(View.VISIBLE);
        }
    }

    private void addData() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String addr = editTextAddr.getText().toString().trim();

        if (name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
            Toast.makeText(getContext(), "정보를 입력해주세요", Toast.LENGTH_SHORT).show();
        /*
        } else if (database != null) {
            try {
                sql = "INSERT INTO " + tableName + "(name,email,phone,address) values('"
                        + name + "','" + email + "','" + phone + "','" + addr + "');";
                database.execSQL(sql);
                Toast.makeText(getContext(), name + "님의 데이터가 저장되었습니다.", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(getContext(), "DB를 먼저 생성해주세요.", Toast.LENGTH_SHORT).show();

         */
        return;
        }

        Member member = new Member(name,email,phone,addr);
        MemberDAO memberDAO = new MemberDAO(getActivity());
        memberDAO.addData(member);

        editTextAddr.setText("");
        editTextEmail.setText("");
        editTextPhone.setText("");
        editTextName.setText("");
        editTextName.requestFocus();
    }
}