package com.example.jsonimagelisttest.reponse;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.Toast;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.example.jsonimagelisttest.model.Job;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class JobResponse extends AsyncHttpResponseHandler {

    Activity activity;
    JobAdapter jobAdapter;
    ProgressDialog dialog ;

    public JobResponse(Activity activity, JobAdapter jobAdapter) {
        this.activity = activity;
        this.jobAdapter = jobAdapter;
        Log.d("[test]","JobResponse 생성됨");
    }

    @Override
    public void onStart() {
        Log.d("[test]","onStart 생성됨");
        dialog = new ProgressDialog(activity);
        dialog.setMessage("처리중입니다.");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onFinish() {
        Log.d("[test]","onFinish 생성됨");
        dialog.dismiss();
        dialog = null;

    }

    @Override
    public void onSuccess(int i, Header[] headers, byte[] bytes) {
        String result = new String(bytes);
        Log.d("[test]","onSuccess 생성됨");

        try {
            JSONObject json = new JSONObject(result);
            JSONObject job = json.getJSONObject("job");
            JSONArray items = job.getJSONArray("item");

            for(int a = 0; a<items.length();a++){
                JSONObject item = items.getJSONObject(a);

                int num = item.getInt("num");
                String subject = item.getString("subject");
                String content = item.getString("content");
                String img = item.getString("img");

                Job newJob = new Job(num,subject,content,img);
                jobAdapter.add(newJob);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        Toast.makeText(activity,"통신실패..",Toast.LENGTH_SHORT).show();
        Log.d("[test]","onFailure 생성됨");
    }
}
