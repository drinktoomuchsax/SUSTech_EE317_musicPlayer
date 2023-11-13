package com.example.myapplication;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    public void exitApp(View view) {
        System.exit(0);
    }

    private Button btn_bye;
    public void init(){

        btn_bye = findViewById(R.id.btn_bye);
        OnClick monclick = new OnClick();
        btn_bye.setOnClickListener(monclick);

    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_bye:
                    Log.e("example","byebye");
                    System.exit(0);
                    break;
            }
        }
    }


    private List<bean> data = new ArrayList<>();

    private String[] name = {"快乐儿歌","哆来咪","海绵宝宝","芝士小马","小小少年"};
    private String[] auther = {"陶泽","蔡徐坤","船长","顶真","曹嗝"};
    private String[] time = {"2024-05-05","2024-05-05","2024-05-05","2024-05-05","2024-05-05"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        for(int i=0;i<5;i++ ){
            bean beAN = new bean();
            beAN.setName(name[i]);
            beAN.setNews(auther[i]);
            beAN.setTime(time[i]);
            data.add(beAN);
        }

        ListView listview = findViewById(R.id.LV);
        listview.setAdapter(new ListAdaptor(data,this));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("example",""+position);
                if(position == 0){
                    Intent intent=new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(position == 1){
                    Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                    startActivity(intent);}
                else if(position == 2){
                    Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                    startActivity(intent);}
                else if(position == 3){
                    Intent intent=new Intent(MainActivity2.this,MainActivity5.class);
                    startActivity(intent);}
                else if(position == 4){
                    Intent intent=new Intent(MainActivity2.this,MainActivity6.class);
                    startActivity(intent);}

            }
        });


    }

}
