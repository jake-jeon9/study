package com.example.viewpagerexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.viewpagerexam.adapter.PersonAdapter;
import com.example.viewpagerexam.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //객체 선언
    ViewPager viewPager;
    PersonAdapter adapter;
    List<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체 초기화
        list = new ArrayList<>();

        viewPager = findViewById(R.id.viewPager);
        adapter = new PersonAdapter(this,list);
        viewPager.setAdapter(adapter);
        list.add(new Person("감자","010-1111-1111",R.drawable.job06));
        addData();
        adapter.notifyDataSetChanged();

    }

    private void addData() {
        list.add(new Person("홍길동","010-9313-8802",R.drawable.job05));
        list.add(new Person("나미","010-9313-8802",R.drawable.job06));
        list.add(new Person("루피","010-9313-8802",R.drawable.job07));
    }
}