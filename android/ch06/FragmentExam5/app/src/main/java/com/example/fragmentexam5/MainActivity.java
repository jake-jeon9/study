package com.example.fragmentexam5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SampleListFragment.OnListItemSelectedListener {

    //객체 선언
    SampleViewerFragment sampleViewerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sampleViewerFragment = (SampleViewerFragment)getSupportFragmentManager().findFragmentById(R.id.image_viewer_fragment);

        //화면 초기화 :이벤트 함수 강제 호출
        onListItemSelected(0);

    }

    @Override
    public void onListItemSelected(int index) {
        sampleViewerFragment.update(index);
    }
}