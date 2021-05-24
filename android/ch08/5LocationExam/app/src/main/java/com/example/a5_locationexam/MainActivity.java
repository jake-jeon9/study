package com.example.a5_locationexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {
    TextView textView1, textView2, textView3;

    //위치정보 객체
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        //위치 수신을 준비
        //현재 사용 가능한 하드웨어 이름얻기
        //LocationManager.GPS_PROVIDER 또는 LocationManager.NETWORK_PROVIDER 중에서 얻어옴
        String provider = lm.getBestProvider(new Criteria(), true);
        Toast.makeText(this, "베스트 제공자는 ? " + provider, Toast.LENGTH_SHORT).show();

        if (provider == null) {
            Toast.makeText(this, "프로바이더 활성화 실패.. 다시 시도해주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        //해당장치가 마지막으로 수신한 위치 얻기
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = lm.getLastKnownLocation(provider);

        if(location !=null){
            onLocationChanged(location);
        }
        //위치 정보 취득 시작
        lm.requestLocationUpdates(provider,400,1,this);
    }

    @Override
    protected void onPause() {
        //위치 수신 종료
        super.onPause();
        lm.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //현재위치 얻기
        double lat = location.getLatitude(); // 위도
        double lng = location.getLongitude(); //경도
        String placeName = getAddress(lat,lng);
        textView1.setText("경도 : " + lat);
        textView2.setText("위도 : "+lng);
        textView3.setText("주소 : "+placeName);
    }

    //위도와 경도를 주소 구하기
    private String getAddress(double lat, double lng) {
        String str_addr = null;
        //주소 구하기 객체
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        //주소 목록 저장 List
        List<Address> list = null;
        try {
            list = geocoder.getFromLocation(lat,lng,1);
            if(list.size()>0){
                Address address = list.get(0);
                str_addr = address.getAddressLine(0);

                //address객체에 저장된 내용 확인
                for(int i= 0;i<=address.getMaxAddressLineIndex();i++){
                    Log.d("[test]",address.getAddressLine(i)+"\n");

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str_addr;
    }
}