package com.example.a6_activityforresultexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String memo = textView.getText().toString();

        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("memo", memo);
        //requestCode 는 직접 지정.
        startActivityForResult(intent, 100);


    }

    /***
     * startActivityForResult() 에 의해서 화면이 이동되었다가 이 activity로 되돌아올 경우 자동으로 실행된다.
     * @param requestCode : activity Id
     * @param resultCode : Ok / Cancel
     * @param data : serResult()에 설정한 인텐트
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                textView.setText(data.getStringExtra("memo"));
            }else{
                Toast.makeText(this,"수정하기 취소됨..",Toast.LENGTH_SHORT).show();
            }
        }
        
    }
}


