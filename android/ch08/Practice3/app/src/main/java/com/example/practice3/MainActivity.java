package com.example.practice3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonImage, buttonVideo, buttonText;
    Uri uri;
    String filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonImage = findViewById(R.id.buttonImage);
        buttonVideo = findViewById(R.id.buttonVideo);
        buttonText = findViewById(R.id.buttonText);

        buttonText.setOnClickListener(this);
        buttonImage.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);

        permissionCheck();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        switch (v.getId()) {
            case R.id.buttonImage:
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                break;

            case R.id.buttonVideo:
                intent.setType("video/*");
                startActivityForResult(intent, 200);
                break;

            case R.id.buttonText:
                intent.setType("text/*");
                startActivityForResult(intent, 300);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri = data.getData();
        filePath = FileUtils.getPath(this,uri);
        //Log.d("[test]","filePath ? " + filePath);
        //Log.d("[test]","uri ? " + uri);
        Intent intent = null;
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 100://이미지
                    intent= new Intent(this, ImageActivity.class);
                    break;

                case 200://동용상
                    intent = new Intent(this, VideoActivity.class);
                    break;

                case 300://텍스트
                    intent= new Intent(this, TextActivity.class);
            }
            intent.setData(uri);
            startActivity(intent);
        }
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 200);
            }
        }
    }
}