package com.example.a1_jsonimagelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.a1_jsonimagelistexam.adapter.ColumnAdapter;
import com.example.a1_jsonimagelistexam.model.Column;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ColumnResponse extends AsyncHttpResponseHandler {

    Activity activity;
    ColumnAdapter adapter;
    ProgressDialog dialog;


    public ColumnResponse(Activity activity, ColumnAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려주세요");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onFinish() {
        dialog.dismiss();
        dialog = null;
    }

    @Override
    public void onSuccess(int i, Header[] headers, byte[] bytes) {
        String result = new String(bytes);

        try {
            JSONObject json = new JSONObject(result);
            JSONObject column = json.getJSONObject("column");
            JSONArray items = column.getJSONArray("item");

            for(int k = 0; k <items.length();k++){
                JSONObject item = items.getJSONObject(k);
                int num = item.getInt("num");
                String img = item.getString("img");
                String subject = item.getString("subject");
                String content = item.getString("content");

                Column columns = new Column(num,img,subject,content);
                adapter.add(columns);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
        Toast.makeText(activity.getBaseContext(),"통신 실패,,",Toast.LENGTH_SHORT).show();
    }
}
