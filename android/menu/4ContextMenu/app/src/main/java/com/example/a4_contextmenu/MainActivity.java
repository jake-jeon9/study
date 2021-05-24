package com.example.a4_contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);

        //context Menu 연결 설정
        registerForContextMenu(button);
        registerForContextMenu(editText);
        registerForContextMenu(imageView);
    }

    //메인 화면의 항목을 길게 눌렀을 경우 , 보여줄 ContentMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        if(v == button){
            menu.setHeaderTitle("Button Menu");
            menu.add(0,1,0,"Red");
            menu.add(0,2,0,"Green");
            menu.add(0,3,0,"Blue");
        }else if(v == editText){
            menu.add(0,4,0,"번역하기");
            menu.add(0,5,0,"필기인식");
        }else if(v == imageView){
        menu.setHeaderTitle("ImageView Menu");
        menu.add(0,6,0,"Fit Start");
        menu.add(0,7,0,"Center Crop");
        menu.add(0,8,0,"Fit XY");
        }
    }

    //Context Menu에서 항목을 클릭했을 때 자동 호출

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 1 :
            button.setTextColor(Color.RED);
            button.setText("빨강");
            break;
            case 2 :
                button.setTextColor(Color.GREEN);
                button.setText("초록");
            break;
            case 3 :
                button.setTextColor(Color.BLUE);
                button.setText("파랑");
            break;
            case 4 :
            String data = editText.getText().toString();
                Toast.makeText(this,data+"to 입니다.",Toast.LENGTH_SHORT).show();
            break;
            case 5 :
                String getText = editText.getText().toString();
                Toast.makeText(this,getText+"가 인식됨.",Toast.LENGTH_SHORT).show();
            break;
            case 6 :
                imageView.setScaleType(ImageView.ScaleType.FIT_START);
            break;
            case 7 :
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            break;
            case 8 :
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            break;

        }


        return super.onContextItemSelected(item);
    }
}