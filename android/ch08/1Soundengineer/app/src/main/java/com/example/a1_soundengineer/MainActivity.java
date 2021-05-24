    package com.example.a1_soundengineer;

    import androidx.annotation.Nullable;
    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.speech.RecognizerIntent;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.List;

    public class MainActivity extends AppCompatActivity implements View.OnClickListener {

        //객체선언
        Button button1,button2;
        TextView textView;
        //음성인식 종류를 구분할 상수
        final int SEARCH = 1;   //구글 음성 검색
        final int SPEECH = 2;   //음성 인식
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            button1 = findViewById(R.id.button);
            button2 = findViewById(R.id.button2);
            textView = findViewById(R.id.textView);

            button1.setOnClickListener(this);
            button2.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.button :
                    callSoundENgine(SEARCH);
                    break;
                case  R.id.button2 :
                    callSoundENgine(SPEECH);
                    break;
            }
        }
        //음성인식을 위해 내장 앱 호출
        private void callSoundENgine(int type) {

            String intent_action = null;
            if(type == SEARCH){
                intent_action = RecognizerIntent.ACTION_WEB_SEARCH;
            }else if(type == SPEECH){
                intent_action = RecognizerIntent.ACTION_RECOGNIZE_SPEECH;
            }

            try{
                Intent intent = new Intent(intent_action);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"음성인식");
                //intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,"음성인식");
                // 뒤에 벨류는 문구 설정

                if(type == SEARCH){
                    startActivity(intent);
                }else{
                    startActivityForResult(intent,100);
                }
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this,"이 기능을 지원하지 않는 단말입니다.", Toast.LENGTH_SHORT).show();

            }

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            switch (requestCode){
                case 100 :
                    if(resultCode==RESULT_OK){
                        //인식된 모든 결과 리스트
                        List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                        //전체 5개의 데이터를 돌려줌
                        //=>첫번째가 가장 정확함
                        String str = results.get(0);

                        //전체 확인
                        for(String all_str : results){
                            all_str += results +"\n";
                        }

                        textView.setText(str);
                    }else{

                    }

                    break;
            }
        }
    }