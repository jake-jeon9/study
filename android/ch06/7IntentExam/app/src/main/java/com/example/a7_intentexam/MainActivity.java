package com.example.a7_intentexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(this);

        //퍼미션체크
        permissionCheck();
        permissionCheck2();
    }

    private void permissionCheck2() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)){
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},101);
            }
        }else{

        }
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)){

            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},100);
            }
        }else{

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = null;
        //암묵적 인텐트 : Intent(액션,URI)

        switch (position){
            case 0 :    // 전화 걸기 창 열기
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01093138802"));
                startActivity(intent);
                break;
            case 1 :    //전화걸기
                //CALL_PHONE 퍼미션 추가
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01093138802"));
                startActivity(intent);
                break;
            case 2 :    //문자 보내기 창 열기
                //sendMessage();
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:01093138802"));
                intent.putExtra("sms_body","hello Android");
                startActivity(intent);
                break;
            case 3 :    //이메일 보내기
                //sendEmail();
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:jakejeon91@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT,"메일 테스트");
                intent.putExtra(Intent.EXTRA_TEXT,"안드로이드에서 메일 발송 테스트입니다.");
                startActivity(intent);
                break;
            case 4 :    //웹브라우저 열기
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.naver.com"));
                startActivity(intent);
                break;
            case 5 :    //주소록
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
            case 6 :    //특정 APP에 대한 구글 플레이 화면 호출
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=mok.android"));
                startActivity(intent);

                break;
            case 7 :    //동영상 재생
                intent = new Intent(Intent.ACTION_VIEW);
                String video_path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/iu.mp4";
                String file_name = "";
                File video_file = new File(video_path);
                Uri video_uri = null;
                Log.d("[test]","Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT);
                //안드로이드 버전에따라 명령어가 달라진다.
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                    video_uri = FileProvider.getUriForFile(this,
                            getApplicationContext().getPackageName()+".fileprovider",video_file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }else{
                    video_uri = Uri.fromFile(video_file);
                }
                intent.setDataAndType(video_uri,"video/*");
                startActivity(intent);
                break;
            case 8 :
                intent = new Intent(Intent.ACTION_VIEW);
                String audio_path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/iu.mp3";
                File audio_file = new File(audio_path);
                Uri audio_uri = null;
                Log.d("[test]","Build.VERSION.SDK_INT = " + Build.VERSION.SDK_INT);
                //안드로이드 버전에따라 명령어가 달라진다.
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                    audio_uri = FileProvider.getUriForFile(this,
                            getApplicationContext().getPackageName()+".fileprovider",audio_file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }else{
                    audio_uri = Uri.fromFile(audio_file);
                }
                intent.setDataAndType(audio_uri,"audio/*");
                startActivity(intent);
            case 9 :    //환경설정 화면 호출
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case 10 :      //GPS설정 화면 호출
                intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case 11 :   //WIFI 설정화면 호출
                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;
            case 12 :   //특정 어플 실행
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"subject");
                intent.putExtra(Intent.EXTRA_TEXT,"text");
                intent.setPackage("com.kakao.talk");
                startActivity(intent);
                break;

        }
    }
}