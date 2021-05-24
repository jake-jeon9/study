package com.example.a1_simplespiinerexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinner;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        //특정 항목을 선택하도록 설정
        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(this);

    }

    /*
     * @param parent : spinner 객체
     * @param view : 선택된 위치를 구성하는 view
     * @param position : 선탠된 위치에 대한 인덱스
     * @param id : 선택된 위치에 대한 인덱스
     * */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selected = (String) parent.getSelectedItem();
        String result = position + "번째 항목>>" + selected;
        textView.setText(result);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    @Override
    public void onClick(View v) {
        //spinner 선택된 위치 가져오가
        int selectIndex = spinner.getSelectedItemPosition();
        //리소스 배열에서 가져오기
        Resources r = getResources();
        String[] data = r.getStringArray(R.array.spinner_data);
        Toast.makeText(this, data[selectIndex], Toast.LENGTH_SHORT).show();
    }
}