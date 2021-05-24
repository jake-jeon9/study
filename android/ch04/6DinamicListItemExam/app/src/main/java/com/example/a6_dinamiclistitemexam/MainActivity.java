package com.example.a6_dinamiclistitemexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a6_dinamiclistitemexam.model.Item;
import com.example.a6_dinamiclistitemexam.model.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    List<Item> list;
    Button button;
    ListView listView;
    EditText editText;
    ItemAdapter adapter;

    //일렬번호를 관리할 변수
    static int NUM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new ItemAdapter(this,R.layout.list_item,list);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        listView.setAdapter(adapter);

        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
       }

    @Override
    public void onClick(View v) {

        String input = editText.getText().toString().trim();
        NUM ++;

        Item item = new Item(input,NUM);
        //adapter.add(item);              //list 의 마지막 부분에 저장됨.
        adapter.insert(item,0);  //list의 특정 위치에 값 저장 (0이면 맨위에 삽입됨)
        editText.setText("");//추가 후 내용 초기화
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

         Item item = adapter.getItem(position);
         String result = item.getNum() + " / " + item.getName();
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();

    }
}