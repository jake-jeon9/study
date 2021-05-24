package com.example.a2_senderexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button button;
    String phoneNum, messgage;

    //문자메세지 관리 클래스
    SmsManager sms;

    //눌림상태 확인 : 여러번 전송되는 것 방지
    boolean pressCheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editTextPhone);
        editText2 = findViewById(R.id.editTextMessage);
        button = findViewById(R.id.button);

        sms = SmsManager.getDefault();

        //이벤트설정
        button.setOnClickListener(this);

        //퍼미션체크
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 100);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                phoneNum = editText1.getText().toString().trim();
                messgage = editText2.getText().toString().trim();
                if (!phoneNum.equals("") && !messgage.equals("")) {
                    Toast.makeText(this, phoneNum+"전화번호와"+messgage+ "메세지 설정 완료", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "전화번호와 메세지를 입력해주세요", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }

    //하드웨어 키가 눌릴 때 호출된다
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("[test]",keyCode+"");
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_DOWN:

                if (pressCheck == false) {
                    //딱 한번만 문자발송을 하기위해서, 눌림 상태임을 저장함.
                    pressCheck = true;
                    //입력값 검사
                    if (phoneNum == null || messgage == null || phoneNum.equals("") || messgage.equals("")) {
                        Toast.makeText(this, "전화번호나 메세지가 설정되지 않았습니다.", Toast.LENGTH_SHORT).show();
                        return false;//함수 강제 종료
                    }
                    //문자 발송하기

                    sms.sendTextMessage(phoneNum, null, messgage, null, null);
                }
                return true;
            case KeyEvent.KEYCODE_BACK:
                finish();
                return true;

        }

        return false;
    }

    //하드웨어 키를 뗄 때 호출된다.
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        pressCheck = false; // 키에서 떨어진 상태

        return super.onKeyUp(keyCode, event);
    }
}