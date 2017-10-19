package com.example.jsb.ms_lab06_201302476_jeonseongbae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fragment 객체
        fragment1 = (Fragment1) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        fragment2 = new Fragment2();
    }

    //fragment 교체
    public void onFragmentChanged(int index){
        if (index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
        }else if (index ==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
        }
    }
}
