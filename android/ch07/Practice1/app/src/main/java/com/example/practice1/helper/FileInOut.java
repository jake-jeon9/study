package com.example.practice1.helper;

import android.util.Log;

import com.example.practice1.medel.Member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileInOut {

    //싱글톤 패턴 시작

    private static FileInOut instance = null;

    public static FileInOut getInstance(){
        if(instance ==null) instance = new FileInOut();
        return instance;
    }

    private FileInOut(){}
    //싱글톤 패턴 끝

    public boolean write(String name, List<Member> list){
        boolean result = false;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(name);
            oos = new ObjectOutputStream(fos);

            oos.writeInt(list.size());

            for(Member member : list){
                oos.writeObject(member);
                oos.flush();
            }
            result = true;

            Log.d("[INFO]","파일저장 성공 >>" + name);
        } catch (FileNotFoundException e) {
            Log.d("[ERROR]","지정된 경로를 찾을 수 없음 >>" + name);
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("[ERROR]","파일 저장 실패 >>" + name);
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("[ERROR]","알 수 없는 에러 >>" + name);
            e.printStackTrace();
        }finally {
            try {
                if(fos!=null)fos.close();
                if(oos!=null)oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


        public List<Member> read(String name){
        List<Member> list = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

            try {
                fis = new FileInputStream(name);
                ois = new ObjectInputStream(fis);

                int size = ois.readInt();

                for(int i = 0 ; i<size; i++){
                    Member member = (Member)ois.readObject();
                    list.add(member);
                }
                Log.d("[INFO]","파일 읽기 성공 >>" + name);
            } catch (FileNotFoundException e) {
                Log.d("[ERROR]","지정된 경로를 찾을 수 없음 >>" + name);
                e.printStackTrace();
            } catch (IOException e) {
                Log.d("[ERROR]","파일 읽기 실패 >>" + name);
                e.printStackTrace();
            } catch (Exception e) {
                Log.d("[ERROR]","알 수 없는 에러 >>" + name);
                e.printStackTrace();
            }finally {
                try {
                    if(ois !=null)ois.close();
                    if(fis !=null)fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return list;
        }

}
