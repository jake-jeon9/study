package com.example.a1_jsonimagelistexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.a1_jsonimagelistexam.R;
import com.example.a1_jsonimagelistexam.model.Column;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class ColumnAdapter extends ArrayAdapter<Column> {

    Activity activity;
    int resource;

    //이미지 로더 객체
    //1. 이미지 요청, 2. 이미지 응답 처리, 3. 이미지를 imageView에 설정
    ImageLoader imageLoader;
    DisplayImageOptions options;

    public DisplayImageOptions getOptions() {
        return options;
    }

    public ColumnAdapter(@NonNull Context context, int resource, @NonNull List<Column> objects) {
        super(context, resource, objects);

        activity = (Activity) context;
        this.resource = resource;

        //이미지 로더 초기화
        imageLoaderInit();

    }

    private void imageLoaderInit() {
        //이미지로더 초기화
        imageLoader = ImageLoader.getInstance();
        if(!imageLoader.isInited()){             //어떤 액티비티에 사용할지 초기화 설정
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(activity);
            imageLoader.init(configuration);
        }
        //다운로드옵션
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();

        //다운로드 동안 표시할 임시 이미지 설정
        builder.showImageOnLoading(R.drawable.ic_stub);
        //이미지가 지정되지 않은 경우 사용될 이미지 설정
        builder.showImageForEmptyUri(R.drawable.ic_empty);
        //다운로드 실패시에 사용될 이미지 설정정
        builder.showImageOnFail(R.drawable.ic_error);
        options = builder.build();
    }

    @NonNull
   @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(resource,null);
        }
        Column item = getItem(position);

        if( item != null){
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView1 = convertView.findViewById(R.id.textView1);
            TextView textView2 = convertView.findViewById(R.id.textView2);

            //이ㅣ밎 다운로드 처리 : 1. 이미지 요청, 2.이미지 응답처리, 3.이미지를 imageView 에 추가
            imageLoader.displayImage(item.getImg(),imageView,options);
            textView1.setText(item.getSubject());
            textView2.setText(item.getContent());
        }
        return convertView;
    }
}
