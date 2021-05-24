package com.example.practice2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout[] layouts = new LinearLayout[4];
    Button buttonToInsert, buttonInsert, buttonList, buttonEdit, buttonBack1, buttonBack2, buttonBack3, buttonToEdit;
    EditText editTextName, editTextKor, editTextEng, editTextMat, editTextNameE, editTextKorE, editTextEngE, editTextMatE;

    TableLayout tableLayout;

    //DB관련 변수
    String dbName = "newstudent.db";
    String tableName = "newscore";
    SQLiteDatabase database;
    String sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layouts[0] = findViewById(R.id.main);
        layouts[1] = findViewById(R.id.insert);
        layouts[2] = findViewById(R.id.list);
        layouts[3] = findViewById(R.id.modify);

        buttonInsert = findViewById(R.id.buttoninsert);
        buttonToInsert = findViewById(R.id.buttonToInsert);
        buttonList = findViewById(R.id.buttonList);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonBack3 = findViewById(R.id.buttonBack3);
        buttonToEdit = findViewById(R.id.buttonToEdit);

        editTextName = findViewById(R.id.editTextName);
        editTextKor = findViewById(R.id.editTextKor);
        editTextEng = findViewById(R.id.editTextEng);
        editTextMat = findViewById(R.id.editTextMat);
        editTextNameE = findViewById(R.id.editTextNameE);
        editTextKorE = findViewById(R.id.editTextKorE);
        editTextEngE = findViewById(R.id.editTextEngE);
        editTextMatE = findViewById(R.id.editTextMatE);

        tableLayout = findViewById(R.id.tableLayout);

        buttonToInsert.setOnClickListener(this);
        buttonInsert.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonEdit.setOnClickListener(this);
        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);
        buttonToEdit.setOnClickListener(this);

        createDB();
        createTable();

        setLayout(R.id.main);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()== R.id.buttonBack1 ||v.getId()== R.id.buttonBack2 ||v.getId()== R.id.buttonBack3 ){
            setLayout(R.id.main);
        }else {
            switch (v.getId()) {
                case R.id.buttoninsert:
                    setLayout(R.id.insert);
                    break;

                case R.id.buttonList:
                    getList();
                    setLayout(R.id.list);
                    break;

                case R.id.buttonEdit:
                    searchItem();
                    //내부에 이름 검사랑 화면이동 포함
                    break;
                case R.id.buttonToInsert:
                    addData();
                    editTextName.setText("");
                    editTextKor.setText("");
                    editTextEng.setText("");
                    editTextMat.setText("");
                    editTextName.requestFocus();
                    break;
                case R.id.buttonToEdit:
                    modifyData();
                    break;
            }
        }
    }

    //데이터 검사 및 데이터 셋팅
    public boolean setDataForReady(String tarketname) {
        Log.d("[test]", "검색한 이름 : " + tarketname);
        boolean result = false;
        try {
            if (database != null) {
                sql = "SELECT name, kor, eng, mat, tot, avg FROM " + tableName + " WHERE NAME ='" + tarketname + "';";
                Cursor cursor = database.rawQuery(sql, null);


                //검색 데이터가 있는지 검사
                if (cursor.getCount() < 1) {
                    Toast.makeText(this, "검색한 이름이 없습니다.", Toast.LENGTH_SHORT).show();
                    return result;
                } else {
                    //있다면 데이터 가져오기
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getInt(5);

                    editTextNameE.setText(name);
                    editTextKorE.setText(String.valueOf(kor));
                    editTextEngE.setText(String.valueOf(eng));
                    editTextMatE.setText(String.valueOf(mat));

                }
                cursor.close();
                result = true;
            } else {
                Toast.makeText(this, "서버를 먼저 열어주세요.", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //다이어 로그창 + 화면 처리
    private void searchItem() {
        final View loginView = getLayoutInflater().inflate(R.layout.dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("수정할 이름 검색");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);

        builder.setView(loginView);

        //긍정버튼
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText editTextSearchName = loginView.findViewById(R.id.editTextgetName);
                String tarketname = editTextSearchName.getText().toString();
                if (tarketname.equals("")) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                //리턴 트루 : 해당 데이터 있음 -> 수정화면 이동
                //리턴 펠스 : 해당 데이터 없음 -> 메인화면
                boolean chk = setDataForReady(tarketname);
                if (chk) {
                    setLayout(R.id.modify);
                } else {
                    setLayout(R.id.main);
                }

            }
        });
        //부정버튼
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setLayout(R.id.main);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    //수정하기
    private void modifyData() {
        try {
            if (database != null) {

                String name = editTextNameE.getText().toString().trim();
                String strKor = editTextKorE.getText().toString().trim();
                String strEng = editTextEngE.getText().toString().trim();
                String strMat = editTextMatE.getText().toString().trim();

                //입력검사
                if (name.equals("") || strKor.equals("") || strEng.equals("") || strMat.equals("")) {
                    Toast.makeText(this, "데이터를 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                int kor = Integer.parseInt(strKor);
                int eng = Integer.parseInt(strEng);
                int mat = Integer.parseInt(strMat);
                int tot = kor + eng + mat;
                float avg = (float) tot / 3;

                sql = "UPDATE " + tableName
                        + " SET kor =" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
                        + tot + ", avg=" + avg + " WHERE name ='" + name + "';";
                database.execSQL(sql);
                Toast.makeText(this, name + "님의 데이터 수정되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "서버를 먼저 열어주세요.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addData() {
        try {
            String name = editTextName.getText().toString().trim();
            String strKor = editTextKor.getText().toString().trim();
            String strEng = editTextEng.getText().toString().trim();
            String strMat = editTextMat.getText().toString().trim();

            //입력검사
            if (name.equals("") || strKor.equals("") || strEng.equals("") || strMat.equals("")) {
                Toast.makeText(this, "데이터를 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            int kor = Integer.parseInt(strKor);
            int eng = Integer.parseInt(strEng);
            int mat = Integer.parseInt(strMat);
            int tot = kor + eng + mat;
            float avg = (float) tot / 3;

            if (database != null) {
                sql = "INSERT INTO " + tableName + " (name,kor,eng,mat,tot,avg) " +
                        " values('" + name + "'," + kor + "," + eng + "," + mat + "," + tot + "," + avg + ");";
                database.execSQL(sql);
                Toast.makeText(this, name + "님의 데이터 업데이트 완료", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "서버를 먼저 열어주세요.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void getList() {
        //리트스 먼저 초기화
        tableLayout.removeAllViews();

        TableRow tableRow;
        TextView textViewName, textViewNumber, textViewKor, textViewEng, textViewMat, textViewTot, textViewAvg;
        try {
            if (database != null) {
                sql = "SELECT name, kor, eng, mat, tot, avg FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);

                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getFloat(5);

                    tableRow = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
                    textViewNumber = tableRow.findViewById(R.id.textViewNumber);
                    textViewName = tableRow.findViewById(R.id.textViewName);
                    textViewKor = tableRow.findViewById(R.id.textViewKor);
                    textViewEng = tableRow.findViewById(R.id.textViewEng);
                    textViewMat = tableRow.findViewById(R.id.textViewMat);
                    textViewTot = tableRow.findViewById(R.id.textViewTot);
                    textViewAvg = tableRow.findViewById(R.id.textViewAvg);

                    textViewNumber.setText(String.valueOf(i + 1));
                    textViewName.setText(name);
                    textViewKor.setText(String.valueOf(kor));
                    textViewEng.setText(String.valueOf(eng));
                    textViewMat.setText(String.valueOf(mat));
                    textViewTot.setText(String.valueOf(tot));
                    textViewAvg.setText(String.format("%2.2f", avg));

                    tableLayout.addView(tableRow);

                }

                cursor.close();
                Toast.makeText(this, "데이블을 조회했다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야 합니다.", (Toast.LENGTH_SHORT)).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void setLayout(int layout) {
        for (int i = 0; i < layouts.length; i++) {
            layouts[i].setVisibility(View.GONE);
        }
        findViewById(layout).setVisibility(View.VISIBLE);
    }

    private void createTable() {
        try {
            if (database != null) {
                sql = "CREATE TABLE IF NOT EXISTS " + tableName
                        + "( _id integer PRIMARY KEY autoincrement, "
                        + " name text,"
                        + " kor integer,"
                        + " eng integer,"
                        + " mat integer,"
                        + " tot integer,"
                        + " avg float);";
                database.execSQL(sql);
                Toast.makeText(this, tableName + "이 생성되었습니다.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 생성하세요.", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createDB() {
        try {
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, dbName + "를 생성하였습니다.", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, dbName + "을 생성하지 못하였습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}