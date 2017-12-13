package com.example.jsb.notificationandservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnStart, btnEnd;
    private Notification mNoti;
    private NotificationManager mNM;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        mNM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNoti = new Notification.Builder(getApplicationContext())
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setTicker("알림!!!")
                .build();

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Service 시작",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,MyService.class);
//                startService(intent);
                mNM.notify(7777,mNoti);
            }
        });

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Service 끝",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this,MyService.class);
//                stopService(intent);
                mNM.cancel(7777);
            }
        });
    }
}
