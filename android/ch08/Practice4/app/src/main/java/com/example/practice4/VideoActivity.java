package com.example.practice4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {
    VideoView videoView;
    Button button;
    MediaController mc;
    private RelativeLayout.LayoutParams defaultVideoViewParams;
    private int defaultScreenOrientationMode;

    boolean change = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);
        button = findViewById(R.id.buttonBack2);

        button.setOnClickListener(this);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnClickListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) finish();
        return super.onOptionsItemSelected(item);
    }

    // play video in fullscreen mode
    private void makeVideoFullScreen() {

        defaultScreenOrientationMode = getResources().getConfiguration().orientation;

        defaultVideoViewParams = (RelativeLayout.LayoutParams) videoView.getLayoutParams();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        videoView.postDelayed(new Runnable() {

            @Override
            public void run() {
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.MATCH_PARENT);

                videoView.setLayoutParams(params);
                videoView.layout(10, 10, 10, 10);
            }
        }, 700);
    }


    // close fullscreen mode
    private void exitVideoFullScreen() {
        setRequestedOrientation(defaultScreenOrientationMode);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);

        videoView.postDelayed(new Runnable() {

            @Override
            public void run() {
                videoView.setLayoutParams(defaultVideoViewParams);
                videoView.layout(10, 10, 10, 10);
            }
        }, 700);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonBack2 :
                finish();
                break;

            case R.id.videoView:
                if(!change){
                    makeVideoFullScreen();
                    change = true;
                }else{
                    exitVideoFullScreen();
                    change = false;
                }
                Toast.makeText(this,"클릭됨",Toast.LENGTH_SHORT).show();
                break;
        }

    }

}