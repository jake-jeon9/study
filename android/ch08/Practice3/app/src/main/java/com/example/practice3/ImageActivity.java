package com.example.practice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.buttonBack1);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        imageView.setImageURI(uri);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}