package com.example.a3_buttoneventexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //1)객체 선언
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2)객체 초기화
        button = findViewById(R.id.button);
        //3) 이벤트 처리
       /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getApplicationContext() : Activity 객체 얻어오기 함수.
                Toast.makeText(getApplicationContext(), "눌러졌습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        */
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        //4)익명클래스 및 람다표현식 사용
        Calculate calculate = new Calculate() {
            @Override
            public int operation(int x, int y) {
                return x + y;
            }
        };
        Toast.makeText(this,String.valueOf(calculate.operation(100,200)),Toast.LENGTH_SHORT).show();

        //2)람다 표현식 사용
        Calculate calculate1 = (int x,int y) -> {return x+ y;};
        Toast.makeText(this,String.valueOf(calculate1.operation(200,300)),Toast.LENGTH_SHORT).show();

        //3)람다 표현식 간략하게 사용
        Calculate calculate2 = ( x,y) -> {return x+ y;};
        Toast.makeText(this,String.valueOf(calculate2.operation(300,10)),Toast.LENGTH_SHORT).show();

        //4)람다 표현식 더 간략하게 사용
        Calculate calculate3 = ( x,y) ->  x+ y;
        Toast.makeText(this,String.valueOf(calculate3.operation(30,10)),Toast.LENGTH_SHORT).show();

        //4)람다 표현식 더욱 더 간략하게 사용
        Toast.makeText(this,String.valueOf(((Calculate)(x,y)->x+y).operation(3,1)),Toast.LENGTH_SHORT).show();
    }

}

interface Calculate {
    int operation(int x,int y);

}