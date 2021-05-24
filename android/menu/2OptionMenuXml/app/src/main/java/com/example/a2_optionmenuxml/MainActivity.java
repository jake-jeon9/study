package com.example.a2_optionmenuxml;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.jjajang :
                Toast.makeText(this, "짜증날땐 짜장면", Toast.LENGTH_SHORT).show();
                break;
            case R.id.jjambbong :
                Toast.makeText(this, "ㅋㅋ루삥짬뽕", Toast.LENGTH_SHORT).show();
                break;
            case R.id.udong :
                Toast.makeText(this, "우동사리뇌", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mandoo :
                Toast.makeText(this, "쾌걸근육만두", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}