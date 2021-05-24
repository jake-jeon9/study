package com.example.a1_optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //메뉴 만들기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    //(group id,itemId,order,title)
        MenuItem item = menu.add(0,1,0,"짜장");
        item.setIcon(R.mipmap.ic_launcher);
        item.setAlphabeticShortcut('a');
        menu.add(0,2,0,"짬뽕").setIcon(R.mipmap.ic_launcher);

        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");

        return super.onCreateOptionsMenu(menu);
    }

    //메뉴에서 항목 선택시 호출
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = "";
        switch ((item.getItemId())){
            case 1:
                msg = "짜증나는 짜장면";
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;

            case 2:
                msg = "속풀을땐 짬봉";
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;

            case 3:
                msg = "우울한텐 우동";
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;

            case 4:
                msg = "서비스는 군만두!";
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;
        }

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}