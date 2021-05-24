package com.example.practice4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TextActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_text);

        textView =findViewById(R.id.textView);
        button = findViewById(R.id.buttonBack3);

        button.setOnClickListener(this);

        Intent intent = getIntent();
        Uri uri =intent.getData();

        ParcelFileDescriptor pfd = null;
        FileInputStream fis = null;
        try {
            pfd = getContentResolver().openFileDescriptor(uri,"r");
            fis = new FileInputStream(pfd.getFileDescriptor());
            byte[] content_byte = new byte[fis.available()];
            fis.read(content_byte);
            String result = new String(content_byte);
            textView.setText(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        finish();
    }
}