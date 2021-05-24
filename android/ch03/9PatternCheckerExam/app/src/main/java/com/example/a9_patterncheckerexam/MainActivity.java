package com.example.a9_patterncheckerexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a9_patterncheckerexam.helper.Regexhelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);

        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //사용자가 입력한 값
        String name = editText1.getText().toString().trim();
        String email = editText2.getText().toString().trim();
        String address = editText3.getText().toString().trim();
        String phone = editText4.getText().toString().trim();

        //문자열이 형식에 맞지 않을 경우, 에러메시지를 담기 위한 변수
        String err_msg = null;

        // 공백
        if (err_msg == null && !Regexhelper.getInstance().isValue(name)) {
            err_msg = "이름을 입력해주세요.";
        }
        if (err_msg == null && !Regexhelper.getInstance().isValue(email)) {
            err_msg = "이메일을 입력해주세요.";
        }
        if (err_msg == null && !Regexhelper.getInstance().isValue(address)) {
            err_msg = "주소를 입력해주세요.";
        }
        if (err_msg == null && !Regexhelper.getInstance().isValue(phone)) {
            err_msg = "핸드폰 번호를 입력해주세요.";
        }
        //이름 한글만
        if (err_msg == null && !Regexhelper.getInstance().isKor(name)) {
            err_msg = "이름을 한글만 입력해주세요.";
        }
        //이메일
        if (err_msg == null && !Regexhelper.getInstance().isEmail(email)) {
            err_msg = "이메일 형식을 확인하고 입력해주세요.";
        }
        //주소
        if (err_msg == null && !Regexhelper.getInstance().isKorAndNumber(address)) {
            err_msg = "주소를 확인해주세요.";
        }

        //전화번호
        if (err_msg == null && !Regexhelper.getInstance().isPhone(phone)) {
            err_msg = "핸드폰 번호를 다시 확인해주세요.";
        }

        if (err_msg != null) {
            Toast.makeText(this, err_msg, Toast.LENGTH_SHORT).show();
            return;
        }


        //결과를 문자열에 저장한 후 , 출력
        String result = String.format("이름 : %s\n이메일 %s\n주소 : %s\n핸드폰 : %s", name, email, address, phone
        );
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();


    }
}