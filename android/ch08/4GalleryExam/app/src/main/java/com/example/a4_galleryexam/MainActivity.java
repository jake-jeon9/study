package com.example.a4_galleryexam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a4_galleryexam.helper.FileUtils;
import com.example.a4_galleryexam.helper.PhotoHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ImageView imageView;
    Bitmap bmp = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        imageView =findViewById(R.id.imageView);

        button.setOnClickListener(this);

        permissionCheck();

    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        //이미지 파일만 필터링 => MIME 형태
        //intent.setType("image/*");
        //intent.setType("video/*"); // 볼 수 는 읽지만 선택해서 재생은 불가 설정을 안했음
        intent.setType("mp3/*");
        //intent.setType("*/*");// 모든 경로를 읽어옴
        //구글 클라우드에 싱크된 이미지 파일 제외
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        //선택된 파일을 돌려받아야 함.
        Log.d("[test]","gettype? " + intent.getType());
        startActivityForResult(intent,200);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200){
            if(resultCode==RESULT_OK){
                //사용자가 선택한 파일 정보
                Uri photoUri = data.getData();
                //uri ? content://com.android.providers.media.documents/document/image%3A2211
                Log.d("[test]","photoUri ? "+ photoUri);

                //절대 경로로 변환
                String filePath = FileUtils.getPath(this,photoUri);
                ///storage/emulated/0/Pictures/iu11.jpg
                Log.d("[test]","filePath ? "+ filePath);

                imageView.setImageURI(photoUri);
                /*
                imageView.setImageBitmap(null);

                bmp = PhotoHelper.getInstance().getThumb(this,filePath);
                imageView.setImageBitmap(bmp);

                 */
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bmp!=null){
            bmp.recycle();
            bmp = null;
        }
    }
}