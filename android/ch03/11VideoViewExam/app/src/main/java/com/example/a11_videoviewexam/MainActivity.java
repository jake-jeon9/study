package com.example.a11_videoviewexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    VideoView videoView; //비디오뷰 객체
    MediaController mc; //재생버튼 및 컨트롤러
    //퍼미션 체크 확인
    final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100;
    boolean permissionCheck = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //화면 타이틀 바 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        mc = new MediaController(this);

        //비디오 뷰 컨트롤러 연결
        videoView.setMediaController(mc);

        //퍼미션 체크를 먼저 해야한다.
        permissionCheck();

        //퍼미션이 등록 되었는지 확인
        if (permissionCheck) startVideo();

    }


    private void permissionCheck() {
        //퍼미션 함수 시작
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //-> 퍼미션 여부 확인하기 아닐경우 진입

            //첫 실행 시 거부를 눌렀을 떄, 두번째 부터 실행했을 때 퍼미션 창을 띄울 떄
            //총 2번까지만 권한요청을 하고 그 이후로는 묻지 않음.
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) { //->첫번째 권한 요청이 왔는지 물어보는 함수.
                //한번더 묻는 코드
                ActivityCompat.requestPermissions(this,new String[]{
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_FINE_LOCATION
                },MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

            } else { // 처음 어플 실행시 권한 요청
                //허락을 요청하는 알럿창 출력하는 함수
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                //-->알럿창의 결과를 누르면 onRequestPermission 함수를 실행하고,
                //아이디값이 전달됨.
            }
        } else {
            permissionCheck = true;
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startVideo();
                } else {
                    Toast.makeText(this, "동영상을 실행할 수 가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private void startVideo() {
        //sd카드의 경로 얻기 (내부 저장소)
        File sdcard = Environment.getExternalStorageDirectory();
        String video_path = sdcard.getAbsolutePath() + "/BigBuck.mp4";

        //비디오  뷰에 재생할 파일의 경로 지정
        videoView.setVideoPath(video_path);

        //재생시작
        videoView.start();
    }

}