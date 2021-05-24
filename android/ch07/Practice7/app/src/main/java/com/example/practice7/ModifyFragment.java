package com.example.practice7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practice7.model.Member;
import com.example.practice7.server.MemberDAO;


public class ModifyFragment extends Fragment implements View.OnClickListener {
    EditText editTextName,editTextEmail,editTextPhone,editTextAddr;
    Button buttonEditE,buttonBackE;
    String resultSearchName;
    MemberDAO memberDAO = null;
    Member member = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_modify, container, false);
        editTextAddr = rootView.findViewById(R.id.editTextAddrE);
        editTextName = rootView.findViewById(R.id.editTextNameE);
        editTextEmail = rootView.findViewById(R.id.editTextEmailE);
        editTextPhone = rootView.findViewById(R.id.editTextPhoneE);

        buttonEditE = rootView.findViewById(R.id.buttonEditE);
        buttonBackE = rootView.findViewById(R.id.buttonBackE);
        memberDAO = new MemberDAO(getActivity());
        buttonBackE.setOnClickListener(this);
        buttonEditE.setOnClickListener(this);
        return  rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        resultSearchName = ((MainActivity)getActivity()).resultSearchName;

        member = memberDAO.getData(resultSearchName);
        editTextName.setText(member.getName());
        editTextAddr.setText(member.getAddr());
        editTextEmail.setText(member.getEmail());
        editTextPhone.setText(member.getPhone());
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonEditE){
            editData();

        }else if(v.getId()==R.id.buttonBackE){
            this.getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            getActivity().findViewById(R.id.main).setVisibility(View.VISIBLE);
        }

    }

    private void editData() {
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String phone = editTextPhone.getText().toString().trim();
        String addr = editTextAddr.getText().toString().trim();
     //   Log.d("[test]","에딧데이터 이름 :"+name );
        if (name.equals("") || email.equals("") || phone.equals("") || addr.equals("")) {
            Toast.makeText(getContext(), "정보를 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        member=null;
        member = new Member(name,email,phone,addr);
      //  Log.d("[test]","에딧데이터 member이름 :"+member.getName() );
        memberDAO.modify(member,resultSearchName);

    }
}