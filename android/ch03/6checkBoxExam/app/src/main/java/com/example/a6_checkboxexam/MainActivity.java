package com.example.a6_checkboxexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements CompoundButton.OnCheckedChangeListener {

    CheckBox checkBox1,checkBox2,checkBox3;
    TextView textView2;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        textView2 = findViewById(R.id.textView2);
        button = findViewById(R.id.button);

        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
        //button.setOnClickListener(this);
    }
    //안드로이드가 제공하는 클릭이벤트
    public void onButtonClick(View v){
        switch (v.getId()){
            case R.id.button:
                String msg= "";
                //checkBox1.isChecked() : 체크되었을 시
                if(checkBox1.isChecked()) {
                    msg += checkBox1.getText().toString() + "  ";
                }
                if(checkBox2.isChecked()){
                    msg += checkBox2.getText().toString() + "  ";
                }
                if(checkBox3.isChecked()){
                    msg += checkBox3.getText().toString() + "  ";
                }
                if(msg.equals("")){
                    msg="체크된 것이 없습니다.";
                }
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;
        }
    }
    /*
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String msg= "";
                //checkBox1.isChecked() : 체크되었을 시
                if(checkBox1.isChecked()) {
                    msg += checkBox1.getText().toString() + "  ";
                }
                if(checkBox2.isChecked()){
                    msg += checkBox2.getText().toString() + "  ";
                }
                if(checkBox3.isChecked()){
                    msg += checkBox3.getText().toString() + "  ";
                }
                if(msg.equals("")){
                    msg="체크된 것이 없습니다.";
                }
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;
        }
    }
    */


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    String msg = buttonView.getText().toString();
        if(isChecked){
        msg +="가 체크되었습니다.";
        }else{
            msg+="가 체크 해제되었습니다.";
        }
        textView2.setText(msg);
    }

}