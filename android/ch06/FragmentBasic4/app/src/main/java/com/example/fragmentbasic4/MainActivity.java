package com.example.fragmentbasic4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2;
    Test1Fragment test1Fragment;
    Test2Fragment test2Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        test1Fragment = new Test1Fragment();
        test2Fragment = new Test2Fragment();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.container,test1Fragment).commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, test1Fragment).commit();
                break;
            case R.id.button2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.container, test2Fragment).commit();
                break;

        }
    }
}