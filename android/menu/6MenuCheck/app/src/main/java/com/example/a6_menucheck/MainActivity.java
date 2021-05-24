package com.example.a6_menucheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
    }

    //메뉴 셋팅 준비시키는 함수
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //메뉴창이 열릴 때마다 함수가 호출됨.

        if(button.getTextSize() == 60){
            menu.findItem(R.id.bigfont).setChecked(true);
        }else{
            menu.findItem(R.id.bigfont).setChecked(false);
        }

        int color = button.getTextColors().getDefaultColor();

        if(color == Color.RED){
            menu.findItem(R.id.red).setChecked(true);
        }else if(color == Color.GREEN){
            menu.findItem(R.id.green).setChecked(true);
        }else if(color == Color.BLUE){
            menu.findItem(R.id.blue).setChecked(true);
        }

        return super.onPrepareOptionsMenu(menu);
    }


    //메뉴 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_check,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bigfont :
                if(item.isChecked()){
                    button.setTextSize(TypedValue.COMPLEX_UNIT_PX,30);
                }else{
                    button.setTextSize(TypedValue.COMPLEX_UNIT_PX,60);
                }
                return true;
            case R.id.red :
                button.setTextColor(Color.RED);
                break;
            case R.id.green :
                button.setTextColor(Color.GREEN);
                break;
            case R.id.blue :
                button.setTextColor(Color.BLUE);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}