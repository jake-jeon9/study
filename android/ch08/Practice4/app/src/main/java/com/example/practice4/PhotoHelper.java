package com.example.practice4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class PhotoHelper {

    //싱글톤 시작
    private static PhotoHelper instance;

    public static PhotoHelper getInstance(){
        if(instance == null) instance = new PhotoHelper();
        return instance;
    }

    private PhotoHelper(){}
    //싱글톤 종료

    /*
    DCIM 폴더 하위에 새로 저장될 사진 파일의 이름을 생성한다.
    @return 경로 문자열

     */
    public String getNewPhotoPath(){
        Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH)+1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        int hh = calendar.get(Calendar.HOUR_OF_DAY);
        int mi = calendar.get(Calendar.MINUTE);
        int ss = calendar.get(Calendar.SECOND);

        String fileName = String.format("p%4d-%02d-%02d %02d-%02d-%02d.jpg",yy,mm,dd,hh,mi,ss);

        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

        if(!dir.exists()){// 폴더가 없으면 폴더 생성
            dir.mkdirs();
        }
        String photoPath = dir.getAbsolutePath() + "/" + fileName;
        Log.d("[Test]","photo : "+photoPath);

        return photoPath;
    }

    /**
     * 큰 이미지를 스마트폰 크기로 줄이기
     * @param activity
     * @param path : 파일 겨올
     * @return bitmap : 파일의 이미지
     */
    public Bitmap getThumb(Activity activity,String path){
        //실제 이미지를 저장하는 객체
        Bitmap bmp = null;

        //1.스마트폰의 해상도 얻기
        //해상도 관리 객체
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //스마트 폰의 가로 세로 크기 얻기
        int deviceWidth = displayMetrics.widthPixels;
        int deviceHeight = displayMetrics.heightPixels;

        /*
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
         */

        //긴축을 골라내기
        int maxScale = deviceWidth ;
        if(deviceWidth<deviceHeight) maxScale = deviceHeight;

        //2.이미지 크기 얻어오기
        //bitmap 이미지를 읽어오는 객체
        BitmapFactory.Options options = new BitmapFactory.Options();
        //이미지를 읽어오지 말고 사진 정보(=exif정보)만 읽어오라는설정
        options.inJustDecodeBounds = true;

        //비트맵 이미지 읽어오기 -> 옵션에 의해서 사진 정보 정보만 읽어온다.
        BitmapFactory.decodeFile(path,options);

        //이미지의 가로,세로 값을 읽어와서, 긴축의 값을 저장
        int fScale = options.outHeight;
        if(options.outHeight < options.outWidth){
            fScale = options.outWidth;
        }

        //3.이미지 리사이징
        if(maxScale < fScale){//이미지의 길이가 스마트폰 보다 크면
            //비율 계산
            //=> fScale : 2400px , maxScale : 800px  => 3: 이미지가 핸드폰보다 3배 크다.
            int sampleSize = fScale / maxScale;

            //비트맵 옵션 설정
            BitmapFactory.Options options2 =new BitmapFactory.Options();
            //읽어올 이미지의 비율을 설정 : 3 -> 1/3 크기로 읽어옴
            options2.inSampleSize = sampleSize;
            //이미지 읽어오기
            bmp = BitmapFactory.decodeFile(path,options2);

        }else{ // 이미지가 핸드폰 보다 작으면
            bmp = BitmapFactory.decodeFile(path);
        }


        //돌아간 사진 바로 세우기
        //=>exif 정보에서 orientation 값이 90 보다 클경우,보정하기
        try {
            ExifInterface exif = new ExifInterface(path);
            int exifOrientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL);
            //상수값을 실제 각로도 전환
            int exifEdgree = 0;
            if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_90){
                exifEdgree = 90;
            }else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_180){
                exifEdgree = 180;
            }else if(exifOrientation == ExifInterface.ORIENTATION_ROTATE_270){
                exifEdgree = 270;
            }
            bmp = rotate(bmp, exifEdgree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bmp;

    }

    //각도만큼 이미지를 돌리기
    private Bitmap rotate(Bitmap bmp,int exifDefree){
        if(exifDefree != 0 && bmp !=null){
            Matrix m = new Matrix();
            m.setRotate(exifDefree,(float)bmp.getWidth()/ 2,(float)bmp.getHeight()/2);

            Bitmap converted = Bitmap.createBitmap(bmp,0,0,bmp.getWidth(),bmp.getHeight(),m,true);
            if(bmp !=null){
                bmp.recycle();;

            }
            bmp = converted;
        }
        return bmp;
    }
}
