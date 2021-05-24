package com.example.practice7;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice7.server.MemberDAO;


public class DeleteFragment extends Fragment implements View.OnClickListener {
    Button buttonBack,buttonRemove;
    TextView textViewResult;
    String name;
    MemberDAO memberDAO;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delete, container, false);
        buttonRemove =rootView.findViewById(R.id.buttonRemove);
        buttonBack =rootView.findViewById(R.id.buttonBackD);
        textViewResult = rootView.findViewById(R.id.textViewResultData);

        memberDAO = new MemberDAO(getContext());
        name = ((MainActivity)getActivity()).resultSearchName;

        textViewResult.setText("삭제할 대상 이름은 : "+ name+"님 입니다. \n 삭제를 원하시면 삭제버튼을 클릭해주세요.");
        buttonRemove.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        return  rootView;
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.buttonBackD){
            this.getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            getActivity().findViewById(R.id.main).setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.buttonRemove){

            memberDAO.delete(name);
            Toast.makeText(getActivity(),name+"님 삭제 완료.",Toast.LENGTH_SHORT).show();
            getActivity().findViewById(R.id.main).setVisibility(View.VISIBLE);
        }



    }
}