package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener, View.OnClickListener {

    Button button,button2;
    TextView textView;
    TextToSpeech tts;
    boolean init;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);

        init = false;
        tts = new TextToSpeech(this,this);

        checkPserMission();

    }

    private void checkPserMission() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            }
        }

    }

    @Override
    public void onInit(int status) {
        init =(status == TextToSpeech.SUCCESS);
        String msg ="엔진이 초기화에 실패했습니다.";
        if(init) msg = "엔진이 초기화에 성공했습니다.";
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
     //   if(!init){
     //       Toast.makeText(this,"아직 초기화 되지 않았습니다.",Toast.LENGTH_SHORT).show();
     //       return;
     //   }
        if(v.getId()==R.id.button2){
            tts.stop();
        }else {
            //파일 읽기
            String fileName = "tts3.txt";

            //파일 읽기
            //File dir = getFilesDir();
            File dir = Environment.getExternalStorageDirectory();
            String filePath = dir.getAbsolutePath() + "/" + fileName;

            String encType = "utf-8";

            String msg = Helper.getInstance().readString(filePath, encType);

            textView.setText(msg);

            InputStream inputStream = getResources().openRawResource(R.raw.tts);
            String msg2 = null;

            try {
                byte[] temp = new byte[inputStream.available()];
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (msg.equals("")) {
                Toast.makeText(this, "내용을 입력하세요.", Toast.LENGTH_SHORT).show();
                return;
            }
            //언어선택
            Locale locale = Locale.KOREAN;

            //해당언어가 지원되는지 검사
            int available = tts.isLanguageAvailable(locale);

            if (available < 0) {
                Toast.makeText(this, "지원되지 않는 언어입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            //언어 설정
            tts.setLanguage(locale);
            //tts.setSpeechRate(3.0f);
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                tts = new TextToSpeech(getApplicationContext(), this, "com.google.android.tts");

                for(Voice voice : tts.getVoices()){
                    Log.d("[test]",voice + "\n");
                    if(voice.getName().equals("ko-kr-x-kod-local")){
                        tts.setVoice(voice);
                    }
                }

            }
            tts.speak(msg, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(tts !=null){
            tts.stop();
            tts.shutdown();
        }
    }
}