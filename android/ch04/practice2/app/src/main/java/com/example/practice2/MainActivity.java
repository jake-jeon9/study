package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice2.model.Job;
import com.example.practice2.model.Jobadapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Jobadapter adapter;
    List<Job> list; //javaBeans저장
    ListView listView;//listView와 List를 연결함
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //객체 초기화
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new Jobadapter(this,R.layout.list_item,list);
        //리스트뷰에 어뎁터 설정
        listView.setAdapter(adapter);//listView와 adapter를 연결
        //리스트뷰 에 이벤트 연결
        textView = findViewById(R.id.textView);
        listView.setOnItemClickListener(this);
        addData();


    }
    public void addData() {
        adapter.add(new Job("가수", "노래 부르는 것이 직업인 사람", R.drawable.job01));
        adapter.add(new Job("경찰공무원", "경찰 업무에 종사하는 공무원. 치안총감, 치안정감, 치안감, 경무관, 총경, 경정, 경감, 경위, 경사, 경장, 순경의 계급이 있다.", R.drawable.job02));
        adapter.add(new Job("과학자", "과학을 전문으로 연구하는 사람. 주로 자연 과학을 연구하는 사람을 이른다.", R.drawable.job03));
        adapter.add(new Job("군인", "군대에서 복무하는 사람. 육해공군의 장교, 부사관, 병사를 통틀어 이르는 말이다.", R.drawable.job04));
        adapter.add(new Job("미용사", "일정한 자격을 가지고 사람의 머리나 피부 따위를 아름답게 매만지는 일을 직업으로 하는 사람.", R.drawable.job05));
        adapter.add(new Job("비행기 조종사", "항공기를 일정한 방향과 속도로 움직이도록 다루는 기능과 자격을 갖춘 사람", R.drawable.job06));
        adapter.add(new Job("선생님", "학생을 가르치는 사람.", R.drawable.job07));
        adapter.add(new Job("소방공무원", "화재를 예방ㆍ경계ㆍ진압하는 데 종사하는 공무원. 국민의 생명, 신체, 재산을 보호하는 것을 직무로 하며 국가 소방 공무원과 지방 소방 공무원이 있다.", R.drawable.job08));
        adapter.add(new Job("스튜어디스", "여객기나 여객선 따위에서 승객을 돌보는 여자 승무원.", R.drawable.job09));
        adapter.add(new Job("운동선수", "운동 경기에 뛰어난 재주가 있거나 전문적으로 운동을 하는 사람.", R.drawable.job10));
        adapter.add(new Job("요리사", "요리를 전문으로 하는 사람.", R.drawable.job11));
        adapter.add(new Job("의사", "의술과 약으로 병을 치료ㆍ진찰하는 것을 직업으로 삼는 사람. 국가시험에 합격하여 보건 복지 가족부 장관의 면허를 취득하여야 한다.", R.drawable.job12));
        adapter.add(new Job("화가", "그림 그리는 것을 직업으로 하는 사람.", R.drawable.job13));
        adapter.add(new Job("회사원", "회사에서 근무하는 사람.", R.drawable.job14));
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Job item = adapter.getItem(position);
        String result = item.getTitle() + "\n" + item.getDescription();
        textView.setText(result);

    }
}