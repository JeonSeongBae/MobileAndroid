package com.example.jsb.ms_lab10_201302476;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        CustomViewDrawables myView = new CustomViewDrawables(this);
        setContentView(myView);
    }
}
