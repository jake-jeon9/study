package com.example.fragmentexam6;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class LeftFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;
    OnListItemSelectedListener mListener;

    //프래그먼트가 액티비티와 연결될 때 호출된다.
    //context 는 activity의 부모
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mListener = (OnListItemSelectedListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnlistItemSelectedListener in MainActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_left, container, false);
        listView = rootView.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mListener.OnListItemSelected(position);
    }

    //사용자 정의 리스너
    public interface OnListItemSelectedListener{
        public void OnListItemSelected(int position);
    }
}