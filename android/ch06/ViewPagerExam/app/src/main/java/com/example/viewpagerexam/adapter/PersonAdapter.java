package com.example.viewpagerexam.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.viewpagerexam.R;
import com.example.viewpagerexam.model.Person;

import java.util.List;

public class PersonAdapter extends PagerAdapter {
    private Activity activity;
    private List<Person> list;



    public PersonAdapter(Activity activity, List<Person> list) {
        this.activity = activity;
        this.list = list;
    }

    // List 객체에 저장된 데이터 개수 리턴
    @Override
    public int getCount() {
        return list.size();
    }

    //페이지 검사
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    // 뷰페이저가 만들어졌을 때 호출됨
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // page_item.xml에 설정된 클래스 객체 생성
        View itemView = activity.getLayoutInflater().inflate(R.layout.page_item, null);
        // 한 페이지에 보여줄 데이터 1개 꺼내기
        final Person person = list.get(position);

        ImageView imageView = itemView.findViewById(R.id.imageView);
        TextView textView = itemView.findViewById(R.id.textView);
        Button button = itemView.findViewById(R.id.button);

        textView.setText(person.getName());
        imageView.setImageResource(person.getImage());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "전화걸기 버튼 클릭됨 : " + person.getNumber(), Toast.LENGTH_SHORT).show();
            }
        });

        //컨테이너 에 추가
        container.addView(itemView, 0);

        return itemView;
    }

    //페이지 삭제하는 메서드
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}