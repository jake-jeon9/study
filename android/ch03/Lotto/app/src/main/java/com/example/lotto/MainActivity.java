package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    EditText editText;

    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView1 = findViewById(R.id.textView2);
        textView2 = findViewById(R.id.textView3);
        textView3 = findViewById(R.id.textView4);
        textView4 = findViewById(R.id.textView5);
        textView5 = findViewById(R.id.textView6);
        textView6 = findViewById(R.id.textView7);
        textView7 = findViewById(R.id.textView8);
        textView8 = findViewById(R.id.textView9);
        textView9 = findViewById(R.id.textView10);
        textView10 = findViewById(R.id.textView11);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (editText.getText() == null || editText.getText().equals("")||editText.getText().equals("0")) {
            Toast.makeText(this, "번호를 입력하세요.", Toast.LENGTH_SHORT).show();
        } else {
            int getNum = Integer.parseInt(String.valueOf(editText.getText()));
            String[] data = new String[10];

            for (int k = 0; k < 10; k++) {
                data[k] = "";
            }

            for (int getLotto = 1; getLotto <= getNum; getLotto++) {

                int[] getNumArray = new int[6];
                boolean check = false;
                Random random = new Random();
                getNumArray[0] = random.nextInt(45) + 1;

                for (int x = 1; x < 6; ) {
                    getNumArray[x] = random.nextInt(45) + 1;
                    check = false;
                    for (int b = 0; b < x; b++) {
                        if (getNumArray[b] == getNumArray[x]) {
                            check = true;
                            break;
                        }
                    }
                    if (!check) {
                        x++;
                    }
                }
                for (int x = 0; x < 5; x++) {
                    for (int y = x + 1; y < 6; y++) {
                        if (getNumArray[x] > getNumArray[y]) {
                            int temp = getNumArray[x];
                            getNumArray[x] = getNumArray[y];
                            getNumArray[y] = temp;
                        }
                    }
                }

                data[getLotto - 1] = getNumArray[0] + "\t" + getNumArray[1] + "\t" + getNumArray[2] + "\t" +
                        getNumArray[3] + "\t" + getNumArray[4] + "\t" + getNumArray[5];

            }

            textView1.setText(data[0]);
            textView2.setText(data[1]);
            textView3.setText(data[2]);
            textView4.setText(data[3]);
            textView5.setText(data[4]);
            textView6.setText(data[5]);
            textView7.setText(data[6]);
            textView8.setText(data[7]);
            textView9.setText(data[8]);
            textView10.setText(data[9]);
        }
    }
}