package com.example.a7_changemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    boolean beginner = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.button1 :
            beginner = true;
            //메뉴 새로 만들기 : onCreateOptionMenu() 호출
            invalidateOptionsMenu();

            break;
        case R.id.button2 :
            beginner = false;
            //메뉴 새로만들기기
           invalidateOptionsMenu();
            break ;
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(beginner){
            getMenuInflater().inflate(R.menu.beginner,menu);
        }else{
            getMenuInflater().inflate(R.menu.expert,menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}