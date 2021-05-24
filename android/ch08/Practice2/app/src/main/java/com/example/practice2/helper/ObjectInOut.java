package com.example.practice2.helper;

import android.util.Log;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ObjectInOut {

    //싱글톤 패턴 시작

        private static ObjectInOut instance = null;

        public static ObjectInOut getInstance(){
            if(instance ==null) instance = new ObjectInOut();
            return instance;
        }

        private ObjectInOut(){}
        //싱글톤 패턴 끝

    public String readString(String filePath) {
        String content = null;

        byte[] data = read(filePath);//파일읽기
        //byte[]값을문자열로변환

        try {
            content = new String(data, "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.d("[ERROR]", "인코딩지정에러");
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("[ERROR]", "알수없는에러");
            e.printStackTrace();
        }
        return content;
    }

    public byte[] read(String filePath){
        byte[]data=null;
        InputStream in=null;
        try{
            in=new FileInputStream(filePath);
            data=new byte[in.available()];

            in.read(data);
            Log.d("[INFO]","파일읽기성공>>"+filePath);
        }catch(FileNotFoundException e){
            Log.d("[ERROR]","지정된경로를찾을수없음>>"+filePath);
            e.printStackTrace();
        }catch(IOException e){
            Log.d("[ERROR]","파일읽기실패>>"+filePath);
            e.printStackTrace();
        }catch(Exception e){
            Log.d("[ERROR]","알수없는에러>>"+filePath);
            e.printStackTrace();
        }finally{
            try{
                if(in!=null)in.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return data;
    }

}
