package com.example.fragmentexam6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements LeftFragment.OnListItemSelectedListener {

    RightFragment rightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rightFragment =(RightFragment) getSupportFragmentManager().findFragmentById(R.id.rightFragment);

        //화면초기화
        OnListItemSelected(0);
    }


    @Override
    public void OnListItemSelected(int position) {
        rightFragment.update(position);
    }
}