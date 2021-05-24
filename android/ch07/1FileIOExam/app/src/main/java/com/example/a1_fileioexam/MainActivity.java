package com.example.a1_fileioexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1_fileioexam.helper.FileHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button1,button2;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName);
        textView2 = findViewById(R.id.textView2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
            }
        }
    }


    @Override
    public void onClick(View v) {
        //파일이름
        String fileName= "mymemo.txt";
        //공용폴더 선택
        //개인 앱 폴더선택 : Q버전 이상
        //File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File dir = getFilesDir();
        String filePath = dir.getAbsolutePath() + "/" + fileName;
        System.out.println(filePath);
        //filePate = /data/user/0/com.example.a1_fileioexam/files/여기까지 얻어옴   mymemo.txt
        //C:\Users\ezen\Documents\AndroidStudio\DeviceExplorer\Pixel_2_API_30 [emulator-5554]\data\data\com.example.a1_fileioexam\files
        String encType = "utf-8";
         switch (v.getId()){
             case R.id.button1 :    //저장하기
                String content = editText.getText().toString().trim();
                boolean result = FileHelper.getInstance().writeString(filePath,content,encType);
                String msg = "저장성공";
                if(!result){
                    msg = "저장실패";
                }
                 Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                 break;
             case R.id.button2 :    //파일 읽기
                String read = FileHelper.getInstance().readString(filePath,encType);
                textView2.setText(read);
                 break;
         }
    }
}