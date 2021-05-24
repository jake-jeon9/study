package com.example.a3_listadapterexam.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a3_listadapterexam.R;

import java.util.List;



public class Jobadapter extends ArrayAdapter<Job> {
    Activity activity;
    int resource;

    //JobAdepter adapter = new JobAdepter(this,R.layout.list_item,list);
    public Jobadapter(@NonNull Context context, int resource, @NonNull List<Job> objects) {
        super(context, resource, objects);//부모 생성자를 설정해서 list클래스는 ArrayAdapter클래스를 통해 제어
        activity = (Activity)context;
        this.resource = resource;

    }

    /*
    * getView 함수 는
    * listView에 의해서 호출되는 메소드
    * =>1줄화면 만들기 함수
    * =>List안에서 한 줄에 대한 javaBeans를 추출하여, 한줄 레이아웃에 맴핑한 후,
    *  ListView에게 리턴해준다
    * @param position : 리스트의 몇번째 항목인 지를 의마하는 인덱스값
    * @param convertView : 1줄화면 객체
    *                       앞서 전달받았던 레이아웃 객체, 최초 호출시 에는 null이지만,
    *                       이후 호출될 때마다 이전에 리턴 받았던 view를 이 파라미터를 통해서
    *                       되돌려준다
    * @param parent : listView 객체가 전달됨(사용안함)
    * @return  view : 한줄의 모양을 정의한 레이아웃에 javaBeans의 데이터를 맴핑하여 리턴
    * */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("[TEST]", "position = " + position + ", convertView = " + convertView);
        //1. 1줄 화면객체 생성 : list_item.xml파일에 설정된 데로 객체 생섯
        if(convertView ==null){ //resource에는 list_item.xml 파일의 아이이디가 전달됨.
            convertView = activity.getLayoutInflater().inflate(resource,null);
    }       //최초 convertView 는 null 값임.
            //convertView : 1줄을 채워주는 객체임.


        //2. 전달 받은 위치 값으로 list에서 데이터를 하나 꺼낸다
        Job item = getItem(position);// 어뎁터에 있는 클래스

        //3.데이터가 존재하면,convertView객체에 포함된 컴포넌트들에게 데이터를 출력한다.
        // =>convertView = 컴포넌트 클래스 + 1줄 데이터
        if(item != null){//결합시작.
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            //컴포넌트들에게 데이터를 설정
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getJob());
            textView2.setText(item.getDescription());

        }

        //4. 1줄화면을 돌려줌.
        return convertView;
    }
    //-> 이작업을 전체 화면이 채워질때까지 작동함.



}
