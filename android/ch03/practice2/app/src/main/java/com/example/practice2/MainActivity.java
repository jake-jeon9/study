package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3,button4;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 =findViewById(R.id.button1);
        button2 =findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4 =findViewById(R.id.button4);

        textView = findViewById(R.id.textView2);
        textView.setTextSize(30);
        textView.setTextColor(Color.rgb(255,255,00));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       // Button button = (Button) v;
       // textView.setText(button.getText());

        int id =v.getId();
        String message = null;

        switch (id){
            case R.id.button1:
                message = "버튼1번 선택됨.!";
                break;
            case R.id.button2:
                message = "버튼2번 선택됨.!";
                break;
            case R.id.button3:
                message = "버튼3번 선택됨.!";
                break;
            case R.id.button4:
                message = "버튼4번 선택됨.!";
                break;
        }
        textView.setText(message);

        //Toast toast =Toast.makeText(this, message,Toast.LENGTH_LONG);
        // toast.show();


    }
}