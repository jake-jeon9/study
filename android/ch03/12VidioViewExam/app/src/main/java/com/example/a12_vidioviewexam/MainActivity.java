package com.example.a12_vidioviewexam;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView2);
        mc= new MediaController(this);
        videoView.setMediaController(mc);
        startVideo();
    }

    private void startVideo() {
    //비디오뷰에 재생할 파일의 경로를
        String uri = "android.resource://com.example.a12_vidioviewexam/" + R.raw.bigbuck;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.start();

    }
}