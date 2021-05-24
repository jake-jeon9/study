package com.example.fragmentexam1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            //getSupportFragmentManager() : FragmentMannger객체 구하기
            //beginTransaction() : 프래그먼트를 변경하기 위한 트랜잭션
            //add(layout의 id,fragment 객체) : mainactivity 안의 layout 프래그먼트 객체를 추가
            //commit() : 상태 저장
            getSupportFragmentManager().beginTransaction().add(R.id.container,new PlaceholderFragment()).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment(){}

        /**
         * inflate(R.layout.fragment_main,container,false);
         * 채울 레이아웃
         * 이용할 레이아웃
         *
         */
            @Nullable
            @Override
            public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View rootView = inflater.inflate(R.layout.fragment_main,container,false);
                return  rootView;


            }
        }
    }
