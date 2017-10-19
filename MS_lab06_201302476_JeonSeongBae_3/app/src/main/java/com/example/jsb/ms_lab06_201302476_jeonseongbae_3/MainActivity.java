package com.example.jsb.ms_lab06_201302476_jeonseongbae_3;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progress;

    private int brightness =100;
    private TextView seekBarText;

    private RatingBar ratingBar;
    private TextView ratingBarText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // progress 관련
        progress = new ProgressDialog(this);

        // seekBar 관련
        seekBarText = (TextView) findViewById(R.id.seekBarText);

        // ratingBar 관련
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBarText = (TextView) findViewById(R.id.ratingBarText);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){
                ratingBarText.setText("결과"+rating);
            }
        });

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekbar, int i , boolean b){
                setBrightness(i);
                seekBarText.setText(i+"");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekbar){

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekbar){

            }
        });
    }
    public void start(View view){
        progress.setCancelable(true);
        progress.setMessage("다운로드 중입니다.");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setProgress(0);
        progress.setMax(100);
        progress.show();

        final Thread t = new Thread(){
            @Override
            public void run(){
                int time = 0;
                while(time<100){
                    try {
                        sleep(200);
                        time+=5;
                        progress.setProgress(time);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if (time == 100)
                    progress.dismiss();
            }
        };
        t.start();
    }

    // 화면 밝기 설정
    public void setBrightness(int value) {
        if (value<10){
            value = 10;
        }else if (value>100){
            value =100;
        }
        brightness =value;

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value/100;
        getWindow().setAttributes(params);
    }

}
