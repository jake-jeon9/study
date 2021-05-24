package com.example.fileioexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fileioexam.helper.ObjectInOut;
import com.example.fileioexam.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1,editText2,editText3;
    Button button1,button2,button3,button4;
    TextView textView;
    List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView = findViewById(R.id.textView4);

        list = new ArrayList<>();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //파일 경로 설정 : 내 앱 폴더에 저장
        String fname = getFilesDir().getAbsolutePath()+"/student.txt";

        switch (v.getId()){
            case R.id.button1 ://리스트에 저장
                String name = editText1.getText().toString().trim();
                int age = Integer.parseInt(editText2.getText().toString().trim());
                String addr = editText3.getText().toString().trim();
                list.add(new Student(name,age,addr));
                //화면 초기화
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                break;
            case R.id.button2 : //출력
                String result = "";
                for(Student student : list){
                    result +=student.getName()+", "+student.getAge()+", "+student.getAddr()+"\n";
                }
                textView.setText(result);
                break;
            case R.id.button3 : //파일에 저장
                boolean result3 = ObjectInOut.getInstance().write(fname,list);
                String msg = "저장성공";
                if(!result3){
                    msg = "파일 실패";
                }
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4 : //파일 읽기
                list.clear();   //모든 데이터 지우기
                list = ObjectInOut.getInstance().read(fname);
                String result4 = "불러오기 성공, 출력을 클릭해주세요.";
                if(list.size()<1){
                    result4="불러오기 실패, 다시 시도해주세요.";
                }
                Toast.makeText(this,result4,Toast.LENGTH_SHORT).show();

                break;
        }

    }
}