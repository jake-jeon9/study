package com.example.a5_popupmenutest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);

        //온클릭 이벤트
        button.setOnClickListener(this);
        //롱클릭 이벤트
        button.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"클릭됨",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View v) {
        PopupMenu popupMenu = new PopupMenu(this,v);
        Menu menu = popupMenu.getMenu();
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,menu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.popup_red :
                        button.setBackgroundColor(Color.RED);
                        break;
                    case R.id.popup_green :
                        button.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.popup_blue :
                        button.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.popup_black :
                        button.setTextColor(Color.BLACK);
                        break;
                    case R.id.popup_white :
                        button.setTextColor(Color.WHITE);
                        break;
                    case R.id.popup_gray :
                        button.setTextColor(Color.GRAY);
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
        return false;
    }
}