package com.example.practice2;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.practice2.helper.FileUtils;
import com.example.practice2.helper.ObjectInOut;
import com.example.practice2.helper.PhotoHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout main, container;
    Button buttonImage, buttonVideo, buttonText, buttonBack1, buttonBack2, buttonBack3;
    ImageView imageView;
    VideoView videoView;
    TextView textView;
    Bitmap bmp = null;
    MediaController mc;

    LinearLayout[] supportLayout = new LinearLayout[3];
    File file;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportLayout[0] = findViewById(R.id.imageLayout);
        supportLayout[1] = findViewById(R.id.videoLayout);
        supportLayout[2] = findViewById(R.id.textLayout);

        main = findViewById(R.id.main);
        container = findViewById(R.id.container);

        buttonImage = findViewById(R.id.buttonImage);
        buttonVideo = findViewById(R.id.buttonVideo);
        buttonText = findViewById(R.id.buttonText);

        buttonBack1 = findViewById(R.id.buttonBack1);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonBack3 = findViewById(R.id.buttonBack3);

        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        textView = findViewById(R.id.textView);

        buttonBack1.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);

        buttonText.setOnClickListener(this);
        buttonImage.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);

        main.setVisibility(View.VISIBLE);
        container.setVisibility(View.GONE);

        permissionCheck();
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
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        switch (v.getId()) {
            case R.id.buttonImage:
                setLayout(R.id.imageLayout);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                break;

            case R.id.buttonVideo:
                setLayout(R.id.videoLayout);
                intent.setType("video/*");
                startActivityForResult(intent, 200);
                break;

            case R.id.buttonText:
                setLayout(R.id.textLayout);
                intent.setType("text/*");
                startActivityForResult(intent, 300);
                break;

            case R.id.buttonBack1:
                //main.setVisibility(View.VISIBLE);
                //container.setVisibility(View.GONE);
                // break;
            case R.id.buttonBack2:
                videoView.stopPlayback(); //비디오 정지
                //main.setVisibility(View.VISIBLE);
                //container.setVisibility(View.GONE);
                //break;
            case R.id.buttonBack3:
                main.setVisibility(View.VISIBLE);
                container.setVisibility(View.GONE);
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);
            Log.d("[test]","filePath ? " + filePath);
            Log.d("[test]","uri ? " + uri);
            switch (requestCode) {
                case 100://이미지
                    showImage(filePath);
                    //imageView.setImageURI(uri);
                    break;

                case 200://동용상
                    showVideo(filePath);
                    //videoView.setVideoURI(uri);
                    videoView.start();
                    break;

                case 300://텍스트
                    showText(uri);

                    /*
                    String rawString = readTextFile(uri);
                    String s = null;
                    try {
                        s = URLDecoder.decode(rawString, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    textView.setText(s);

                     */
                    break;
            }
        }

    }

    private void showVideo(String filePath) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoPath(filePath);
        //스타트는 다음에

    }

    private void showImage(String filePath) {
        imageView.setImageBitmap(null);
        if (bmp != null) {
            bmp.recycle();
            bmp = null;
        }
        bmp = PhotoHelper.getInstance().getThumb(this, filePath);
        imageView.setImageBitmap(bmp);

    }

    private void showText(Uri uri) {
        //uri = content://.... 로 파일 경로 사용시 , parcelFileDescriptor 객체를 사용
        //fileinputstream객체는 parFileDescriptor 객체로 생성한다.
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
    protected void onDestroy() {
        super.onDestroy();
        if (bmp != null) {
            bmp.recycle();
            bmp = null;
        }
    }

    public void setLayout(int layout) {
        main.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
        for (LinearLayout layoutSet : supportLayout) {
            layoutSet.setVisibility(View.GONE);
        }
        findViewById(layout).setVisibility(View.VISIBLE);
    }

    private String readTextFile(Uri uri) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(uri)));
            String line = "";

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }
}