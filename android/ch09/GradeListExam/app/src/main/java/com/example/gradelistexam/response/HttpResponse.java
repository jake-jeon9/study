package com.example.gradelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

import com.example.gradelistexam.adapter.ListAdapter;
import com.example.gradelistexam.model.Score;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class HttpResponse extends AsyncHttpResponseHandler {
    Activity activity;
    ListAdapter adapter;
    ProgressDialog dialog;

    public HttpResponse(Activity activity, ListAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만기다려주세요");
        dialog.setCancelable(false);
        dialog.show();

    }

    @Override
    public void onFinish() {
        dialog.dismiss();
        dialog= null;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String result = new String(responseBody);

        try {
            JSONObject json = new JSONObject(result);
            JSONObject grade = json.getJSONObject("grade");
            JSONArray array = grade.getJSONArray("member");

            //Log.d("[test]","json size ? "+json.length());
            //Log.d("[test]","grade size ? "+grade.length());
            //Log.d("[test]","array size ? "+array.length());

            for(int i = 0;i<array.length();i++){
                JSONObject score = array.getJSONObject(i);

                String name =  score.getString("name");
                int kor = score.getInt("kor");
                int eng = score.getInt("eng");
                int mat = score.getInt("mat");

                adapter.add(new Score(name,kor,eng,mat));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

    }
}
