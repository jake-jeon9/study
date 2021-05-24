package com.example.a2_simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(this);
}



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String result = (String)parent.getItemAtPosition(position);
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();


    }
}