package com.example.practice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    EditText editText1, editText2;
    RadioGroup radioGroup;
    CheckBox checkBox1, checkBox2, checkBox3;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextName);
        editText2 = findViewById(R.id.editTextAge);

        radioGroup = findViewById(R.id.radioGrorp);
        button = findViewById(R.id.button);

        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        button.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = editText1.getText().toString().trim();
        int age = 0;
        String age_str = editText2.getText().toString().trim();

        if (!age_str.equals("")) {
            age = Integer.parseInt(age_str);
        }

        int genderId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(genderId);

        String gender = radioButton.getText().toString();
        String hobby = "";
        String result = "";
        if (checkBox1.isChecked()) {
            hobby += checkBox1.getText() + " ";
            result = checkBox1.getText().toString();
        }
        if (checkBox2.isChecked()) {
            hobby += checkBox2.getText() + "  ";
            result = checkBox2.getText().toString();
        }
        if (checkBox3.isChecked()) {
            hobby += checkBox3.getText() + "  ";
            result = checkBox3.getText().toString();
        }

        if (age_str.equals("") || name.equals("")) {
            Toast.makeText(this, "이름 혹은 나이가 입력되지 않았습니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        } else if (result.equals("")) {
            Toast.makeText(this, "취미를 1개 이상 선택해주세요.",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String resultText = name + "님,\n " + age + "살, \n" + gender + "이며,\n 취미는 : " + hobby;
        Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getId()) {
            case R.id.radioGrorp:
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(this, radioButton.getText() + "가 선택 됨.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String msg = buttonView.getText().toString();
        if (isChecked) {
            msg += "가 체크되었습니다.";
        } else {
            msg += "가 체크 해제되었습니다.";
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}