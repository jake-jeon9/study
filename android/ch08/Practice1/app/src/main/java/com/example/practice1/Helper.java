package com.example.practice1;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Helper {
    private static Helper instance = null;

    public static Helper getInstance() {
        if (instance == null) instance = new Helper();
        return instance;
    }

    private Helper() {
    }
//싱글톤종료

    public byte[] read(String filePath) {
        byte[] data = null;
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            //파일의내용을저장할변수생성
            data = new byte[in.available()];
            //in.available():파일의크기를구하기->크기만큼변수크기지정
            in.read(data);
            Log.d("[INFO]", "파일읽기성공>>" + filePath);
        } catch (FileNotFoundException e) {
            Log.d("[ERROR]", "지정된경로를찾을수없음>>" + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("[ERROR]", "파일읽기실패>>" + filePath);
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("[ERROR]", "알수없는에러>>" + filePath);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    public String readString(String filePath, String encType) {
        String content = null;

        byte[] data = read(filePath);//파일읽기
        //byte[]값을문자열로변환

        try {
            content = new String(data, encType);
        } catch (UnsupportedEncodingException e) {
            Log.d("[ERROR]", "인코딩지정에러");
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("[ERROR]", "알수없는에러");
            e.printStackTrace();
        }
        return content;

    }
}
