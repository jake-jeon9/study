package com.example.practice7;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LodaingActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lodaing);

        linearLayout = findViewById(R.id.logo);
        linearLayout.setOnClickListener(this);
        Toast.makeText(this,"오빠 달려~",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}