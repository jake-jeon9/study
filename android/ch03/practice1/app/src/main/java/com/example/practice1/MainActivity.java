package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        textView3.setText(R.string.text1);
        textView4.setText(R.string.text2);

        Resources r = getResources();

        int color = r.getColor(R.color.new_yellow);
        int color2 = Color.rgb(255,255,00);
        textView3.setTextColor(color);
        textView4.setTextColor(color2);

        textView3.setBackgroundColor(Color.rgb(97,79,79));
        textView4.setBackgroundColor(r.getColor(R.color.new_orange));

        int k = 30;
        textView3.setTextSize(k);
        float i = r.getDimension(R.dimen.my_size);
        textView4.setTextSize(i);

        textView4.setSingleLine(true);
        textView3.setSingleLine(true);

        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView4.setEllipsize(truncateAt);





    }
}