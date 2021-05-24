package com.example.practice7;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


import com.example.practice7.model.Member;
import com.example.practice7.server.MemberDAO;

import java.util.List;


public class OutputFragment extends Fragment implements View.OnClickListener {
    Button buttonBack;

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