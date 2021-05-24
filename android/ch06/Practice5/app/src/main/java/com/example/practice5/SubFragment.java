package com.example.practice5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SubFragment extends Fragment implements View.OnClickListener {
    TextView textView1,textView2;
    ImageView imageView;
    MainFragment mainFragment;
    Job job;
    LinearLayout linearLayout;

//    public SubFragment(int contentLayoutId, MainFragment mainFragment) {
//        super(contentLayoutId);
//        this.mainFragment = mainFragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sub, container, false);
        textView1 = rootView.findViewById(R.id.textView1);
        textView2 = rootView.findViewById(R.id.textView2);
        imageView = rootView.findViewById(R.id.imageView);
        linearLayout = rootView.findViewById(R.id.fragment_sub);
        linearLayout.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        textView1.setText(job.getJob());
        textView2.setText(job.getDescription());
        imageView.setImageResource(job.getImage());
    }

    public void updata(Job job){
        //System.out.println("업데이트 클릭 직업은? "+job.getJob());
      this.job= job;

    }
    public void getActivity(MainFragment mainFragment){
        this.mainFragment = mainFragment;
    }

    @Override
    public void onClick(View v) {
        getFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();
        //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment);
        //이것도 가능

    }
}