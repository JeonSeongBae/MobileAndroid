package com.example.jsb.ms_hw09_201302476_jeonseongbae;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(new Init(this));
    }

    class Init extends View {
        Paint paint;
        Paint basePaint;

        int curX = 550;
        int curY = 700;

        int rectWidth = 40;
        int rectHeight = rectWidth;

        public Init(Context context) {
            super(context);
            paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.RED);

            basePaint = new Paint();
            basePaint.setStyle(Paint.Style.FILL);
            basePaint.setColor(Color.WHITE);
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int action = event.getAction();

            if (action==MotionEvent.ACTION_DOWN){
                curX = (int)event.getX();
                curY = (int)event.getY();

                invalidate();
            }else if (action==MotionEvent.ACTION_MOVE){
                curX = (int)event.getX();
                curY = (int)event.getY();
                invalidate();
            }
            return true;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawRect(0, 0, getWidth(), getHeight(), basePaint);
            canvas.drawRect(curX - rectWidth, curY - rectWidth, curX + rectWidth, curY + rectHeight, paint);
        }
    }


}
