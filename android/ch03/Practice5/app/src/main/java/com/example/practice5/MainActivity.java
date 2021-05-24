package com.example.practice5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView, textView2;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, buttonPlus, buttonMinus, buttonTimes, buttonShare, buttonChange, buttonDot, buttonReset, buttonResult;

    double a = 0;
    double b = 0;
    String operator = "";
    double resultData = 0;
    boolean positive = true;
    String input = "";
    boolean count = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button01);
        button2 = findViewById(R.id.button02);
        button3 = findViewById(R.id.button03);
        button4 = findViewById(R.id.button04);
        button5 = findViewById(R.id.button05);
        button6 = findViewById(R.id.button06);
        button7 = findViewById(R.id.button07);
        button8 = findViewById(R.id.button08);
        button9 = findViewById(R.id.button09);
        button0 = findViewById(R.id.button00);
        buttonPlus = findViewById(R.id.button1);
        buttonMinus = findViewById(R.id.button2);
        buttonTimes = findViewById(R.id.button3);
        buttonShare = findViewById(R.id.button4);
        buttonDot = findViewById(R.id.button6);
        buttonChange = findViewById(R.id.button5);
        buttonReset = findViewById(R.id.button7);
        buttonResult = findViewById(R.id.button8);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonTimes.setOnClickListener(this);
        buttonShare.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonChange.setOnClickListener(this);
        buttonResult.setOnClickListener(this);
        buttonReset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //숫자 입력
        if (v.getId() == button1.getId()) {
            input += button1.getText();
            textView.setText(input);
        } else if (v.getId() == button2.getId()) {
            input += button2.getText();
            textView.setText(input);
        } else if (v.getId() == button3.getId()) {
            input += button3.getText();
            textView.setText(input);
        } else if (v.getId() == button4.getId()) {
            input += button4.getText();
            textView.setText(input);
        } else if (v.getId() == button5.getId()) {
            input += button5.getText();
            textView.setText(input);
        } else if (v.getId() == button6.getId()) {
            input += button6.getText();
            textView.setText(input);
        } else if (v.getId() == button7.getId()) {
            input += button7.getText();
            textView.setText(input);
        } else if (v.getId() == button8.getId()) {
            input += button8.getText();
            textView.setText(input);
        } else if (v.getId() == button9.getId()) {
            input += button9.getText();
            textView.setText(input);
        } else if (v.getId() == button0.getId()) {
            input += button0.getText();
            textView.setText(input);
        }

        //연산자
        if (v.getId() == buttonPlus.getId()) {
            if (input.equals("")) {

            } else {
                if (count) {
                    input += "0";
                }
                a = Double.parseDouble(input);
                operator = "+";
                input = "";
                positive = true;
                count = false;
                textView.setText(operator);
            }
        } else if (v.getId() == buttonMinus.getId()) {
            if (input.equals("")) {

            } else {
                if (count) {
                    input += "0";
                }
                a = Double.parseDouble(input);
                operator = "-";
                input = "";
                positive = true;
                count = false;
                textView.setText(operator);
            }
        } else if (v.getId() == buttonTimes.getId()) {
            if (input.equals("")) {

            } else {
                if (count) {
                    input += "0";
                }
                a = Double.parseDouble(input);
                operator = "*";
                input = "";
                positive = true;
                count = false;
                textView.setText(operator);
            }
        } else if (v.getId() == buttonShare.getId()) {
            if (input.equals("")) {

            } else {
                if (count) {
                    input += "0";
                }
                a = Double.parseDouble(input);
                operator = "/";
                input = "";
                positive = true;
                count = false;
                textView.setText(operator);
            }
        } else if (v.getId() == buttonReset.getId()) { // 리셋
            operator = "";
            a = 0;
            b = 0;
            resultData = 0;
            count = false;
            input = "";
            textView.setText("0");
            Toast.makeText(this, "초기화 되었습니다.", Toast.LENGTH_SHORT).show();

        } else if (v.getId() == buttonDot.getId()) { // 소숫점
            if (input == null || input.equals("")) {
                input = "0.";
                count = true;

            } else if (!count) {
                input = input + ".";
                count = true;

            }
        } else if (v.getId() == buttonChange.getId()) { // 양수 음수 바꾸기
            if (positive) {
                positive = false;
                input = "-" + input;
            } else {
                positive = true;
                input = input.substring(1);
            }
            textView.setText(input);

        } else if (v.getId() == buttonResult.getId()) { // 결과
            b = Integer.parseInt(input);
            if (a == 0 && b == 0) {

            } else {

                if (operator.equals("+")) {
                    resultData = a + b;
                } else if (operator.equals("-")) {
                    resultData = a - b;
                } else if (operator.equals("*")) {
                    resultData = a * b;
                } else if (operator.equals("/")) {
                    resultData = a / b;
                } else {
                    textView.setText("작동하지 않음");
                    return;
                }

                int finalResult = 0;
                if (resultData % 1 == 0) {
                    finalResult = (int) resultData;
                    textView.setText(String.valueOf(finalResult));
                } else {
                       /*
                    String makeResult = String.valueOf(resultData);
                    String integer = makeResult.substring(0,makeResult.lastIndexOf("."));
                    String dot = "0" + makeResult.substring(makeResult.lastIndexOf("."));
                    int newResult=0;
                    double dot1 = Double.parseDouble(dot);
                    */
                    textView.setText(String.valueOf(resultData));
                }
                String resultAll = a + operator + b + "= " + resultData;
                textView2.setText(resultAll);
                input = "";
                a = b = 0;
                positive = true;
                count = false;
            }

        }

    }
}