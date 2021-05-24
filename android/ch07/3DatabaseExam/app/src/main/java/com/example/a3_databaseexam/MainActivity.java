package com.example.a3_databaseexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout mainLayout,inputLayout,listLayout;
    Button button1,button2,buttonInput1,buttonBack1,buttonBack2;
    EditText editTextName,editTextKor,editTextEng,editTextMat;
    TextView textViewList;
    LinearLayout[] layouts = new LinearLayout[3];

    List<Student> list;

    //DE관련 변수
    String dbName = "student.db";
    String tableName = "score";
    SQLiteDatabase database;

    //넘버링
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layouts[0]= findViewById(R.id.layoutmMain);
        layouts[1]=findViewById(R.id.layoutInput);
        layouts[2]= findViewById(R.id.layoutList);
        list = new ArrayList<>();

        //객체 초기화
        //mainLayout = findViewById(R.id.layoutmMain);
      //  inputLayout = findViewById(R.id.layoutInput);
       // listLayout = findViewById(R.id.layoutList);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        buttonInput1 = findViewById(R.id.buttonAdd);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonBack2 = findViewById(R.id.buttonBack2);

        editTextName = findViewById(R.id.editTextName);
        editTextKor = findViewById(R.id.editTextKor);
        editTextEng = findViewById(R.id.editTextEng);
        editTextMat = findViewById(R.id.editTextmat);
        textViewList = findViewById(R.id.textViewList);

        //이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        buttonInput1.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);

        //화면 초기화
        setVisible(R.id.layoutmMain);

        createDatabase();
        createTable();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.button1 : //입력화면 이동

                setVisible(R.id.layoutInput);
                break;
            case R.id.button2 : //출력화면 이동
                listData();
                setVisible(R.id.layoutList);
                break;
            case R.id.buttonAdd :   //입력값을 DB에 저장
                insertData();
                editTextName.setText("");
                editTextKor.setText("");
                editTextEng.setText("");
                editTextMat.setText("");
                editTextName.requestFocus();
                break;
            case R.id.buttonBack1 : //메인화면이동
                setVisible(R.id.layoutmMain);
                break;
            case R.id.buttonBack2 : //메인화면 이동
                setVisible(R.id.layoutmMain);
                break;
        }
    }

    //1.데이터베이스 만들기 : student.db 파일만들기
    private void createDatabase(){
        try {
            database = openOrCreateDatabase(dbName,MODE_PRIVATE,null);
            Toast.makeText(this,dbName+" 데이터베이스를 열었습니다.",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,dbName+" 데이터베이스 열기 실패..",Toast.LENGTH_SHORT).show();
        }
    }

    //2.테이블만들기
    private void createTable(){
        try {
            if(database !=null){
                String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                        + " ( _id integer PRIMARY KEY autoincrement, "
                        +" name text,"
                        +" kor integer,"
                        +" eng integer,"
                        +" mat integer,"
                        +" tot integer,"
                        +" avg float);";
                database.execSQL(sql);
                Toast.makeText(this,tableName+"을 테이블을 만들었습니다.", (Toast.LENGTH_SHORT)).show();
            }else{
                Toast.makeText(this,"데이터베이스를 먼저 열어야 합니다.", (Toast.LENGTH_SHORT)).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //INSERT INTO tableName(name,kor,eng,mat,tot,avg)//
    //values('홍길동',kor,eng,mat,tot,avg)
    //3.레코드 추가하기
    private void insertData(){
        try {
            String name = editTextName.getText().toString().trim();
            String strKor =editTextKor.getText().toString().trim();
            String strEng = editTextEng.getText().toString().trim();
            String strMat = editTextMat.getText().toString().trim();
            //입력검사
            if(strKor.equals("") || strEng.equals("") || strMat.equals("")){
                Toast.makeText(this,"점수를 입력해주세요",Toast.LENGTH_SHORT).show();
                return;
            }
            int kor = Integer.parseInt(strKor);
            int mat = Integer.parseInt(strMat);
            int eng = Integer.parseInt(strEng);
            int tot = kor+eng+mat;
            float avg = (float)tot/3;

            //리스트 데이터
//            count = list.size();
//            count ++;
//            Student student = new Student(count,name,kor,eng,mat,tot,avg);
//            list.add(student);

            if(database != null) {
                String sql = "INSERT INTO " + tableName + " (name,kor,eng,mat,tot,avg) " +
                        " values('" + name + "'," + kor + "," + eng + "," + mat + "," + tot + "," + avg + ");";
                database.execSQL(sql);
                Toast.makeText(this, "데이터를 추가했습니다.", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"데이터베이스를 먼저 열어야 합니다.", (Toast.LENGTH_SHORT)).show();
            }
        }catch (Exception e){

        }

    }

    //4.데이터 조회하기
    //Select name, kor,eng, mat, tot, avg FROM tableName;
    private void listData() {
        try{
            if(database != null){
                String sql = "SELECT name, kor, eng, mat, tot, avg FROM "+tableName+";";
                Cursor cursor = database.rawQuery(sql,null);

                String result = "";
                result = textViewList.getText().toString()+"\n";

                for(int i = 0 ; i<cursor.getCount();i++){
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getInt(5);
                    result += String.format("%3d%9s%7d%7d%7d%7d%7.1f\n",i+1,name,kor,eng,mat,tot,avg);

                }
                //Log.d("[TEST]",result);
                textViewList.setText(result);
                cursor.close();
                Toast.makeText(this,"데이블을 조회했다.",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this,"데이터베이스를 먼저 열어야 합니다.", (Toast.LENGTH_SHORT)).show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        for(Student student : list){
//            result += student.getNum() + "\t\t"+student.getName() + "\t\t"+student.getKor()
//                    + "\t\t"+student.getEng() + "\t\t"+student.getMat() + "\t\t"+student.getTot()
//                    + "\t\t"+student.getAvg()+"\n";
//        }
//        textViewList.setText(result);
    }

    public void setVisible(int layout){
        for(LinearLayout layouts : layouts){
            layouts.setVisibility(View.GONE);
        }
        findViewById(layout).setVisibility(View.VISIBLE);
    }
}