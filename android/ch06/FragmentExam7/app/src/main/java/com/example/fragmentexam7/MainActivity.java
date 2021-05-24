package com.example.fragmentexam7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LeftFragment.OnListItemSelectedListener {
    RightFragment rightFragment;
    AdapterList adaptert;
    LeftFragment leftFragment;
    List<Job> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //list = new ArrayList<>();
        //adaptert = new AdapterList(this,R.layout.item_list,list);
        //leftFragment = (LeftFragment) getSupportFragmentManager().findFragmentById(R.id.leftfragment);

        rightFragment =(RightFragment)getSupportFragmentManager().findFragmentById(R.id.rightfragment);

        OnListItemSelected(new Job("가수", "노래 부르는 것이 직업인 사람", R.drawable.job01));
        //OnListItemSelected(0);
        //adatper설정
        //leftFramgment.setAdapter(adapter);
        //데이터 추가
        //addData();
        //화면 초기화 이벤트 함수 강제 설정.
        //OnlistItemSelected(0);
    }

    @Override
    public void OnListItemSelected(Job job) {
    //ublic void OnListItemSelected(int position) {
        //Job item =adapter.getItem(position);
        rightFragment.updata(job);
        //rightFragment.updata(item);

    }


}