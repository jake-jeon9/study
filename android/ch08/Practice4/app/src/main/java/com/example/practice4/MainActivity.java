package com.example.practice4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewMain);

        permissionCheck();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        switch (item.getItemId()){
            case R.id.getImage :
                textView.setText("이미지 보기 실행됨.");
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                break;
            case R.id.getVideo :
                textView.setText("비디오 보기 실행됨.");
                intent.setType("video/*");
                startActivityForResult(intent, 200);
                break;
            case R.id.getText :
                textView.setText("text 보기 실행됨.");
                intent.setType("text/*");
                startActivityForResult(intent, 300);
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) return;
        Uri uri = data.getData();
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

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText("명령 대기중");
    }
}