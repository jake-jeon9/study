package com.example.a3_menuonclick;

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
        getMenuInflater().inflate(R.menu.onclickitem,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void onMenuClick(MenuItem item){
       switch (item.getItemId()){
           case R.id.about :
               Toast.makeText(this,"소개",Toast.LENGTH_SHORT).show();
               break;
           case R.id.help :
               Toast.makeText(this,"도움",Toast.LENGTH_SHORT).show();
               break;
       }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}