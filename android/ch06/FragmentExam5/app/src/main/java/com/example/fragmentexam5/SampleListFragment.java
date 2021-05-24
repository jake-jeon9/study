package com.example.fragmentexam5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

public class SampleListFragment extends ListFragment {
    private int index = 0;
    private OnListItemSelectedListener mListener; //inner Interface;

    //프래그먼트를 포함하는 액티비가 만들어질 떄, 호출되는 메소드
    @Override
    public void onActivityCreated(@NonNull Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //리스트뷰를 위한 어댑터 객체를 생성하여 설정
        //ArrayAdapter.createFromResource(Context content : 액티비티(컨텍스트)
        //                                 ,ArrayRes :  int textArrayResId, -> Strings에 설정된 array name
        //                                 LayoutRes :  int textViewResId)  -> 화면을 만들어줄 layout res name
        setListAdapter(ArrayAdapter.createFromResource(getActivity(),R.array.image_titles,android.R.layout.simple_list_item_1));
        //선택된 아이템  인덱스 값을 읽어와서 리스트의 메소드 호출

        if(savedInstanceState !=null){
            index = savedInstanceState.getInt("index",0);
            mListener.onListItemSelected(index);
        }
    }

    //선택된 아이템 인덱스 값을 저장
    //메모리 부족으로 인한 강제종료 or 가르/세로 화면 전환 시 호출
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.getInt("index",index);
    }

    //프래그먼트가 액티비티와 연결될 떄 호출된다.
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mListener=(OnListItemSelectedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnListItemSelectedListener in Activity");
        }

    }

    //ListFragment에서 보여주는 리스트의 한 아이템을 선택했을 때의 이벤트 처리
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        index = position;
        mListener.onListItemSelected(position);

    }

    //리스너 인터페이스 정의 : 사용자 정의 리스너
    //Activity에서 동작시킬 이벤트 Listener 정의

    public interface OnListItemSelectedListener{
        public void onListItemSelected(int index);
    }
}
