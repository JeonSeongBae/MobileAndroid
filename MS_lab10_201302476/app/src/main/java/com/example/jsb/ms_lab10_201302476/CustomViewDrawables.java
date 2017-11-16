package com.example.jsb.ms_lab10_201302476;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by jsb on 2017-11-10.
 */

class CustomViewDrawables extends View{

    private ShapeDrawable upperDrawable;
    private ShapeDrawable lowerDrawable;

    public CustomViewDrawables(Context context){
        super(context);

        // get display size
        // 윈도우 매니저를 이용해 뷰의 폭과 높이 확인
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point sizePoint = new Point();
        display.getSize(sizePoint);
        int width = sizePoint.x;
        int height = sizePoint.y;

        //get colors
        // 리소스에 정의된 색상 값을 변수에 설정
        Resources curRes = getResources();
        int blackColor = curRes.getColor(R.color.color01);
        int grayColor = curRes.getColor(R.color.color02);
        int darkGrayColor = curRes.getColor(R.color.color03);

        // create the upper drawable
        // Drawable 객체 생성
        upperDrawable = new ShapeDrawable();

        RectShape rectangle = new RectShape();
        rectangle.resize(width, height * 2/3);
        upperDrawable.setShape(rectangle);
        upperDrawable.setBounds(0,0,width, height * 2/3);
        // LinearGradient 객체 생성
        LinearGradient gradient = new LinearGradient(0,0,0, height*2/3, grayColor, blackColor, TileMode.CLAMP);

        Paint paint = upperDrawable.getPaint();
        paint.setShader(gradient);

        // create the lower drawable
        lowerDrawable = new ShapeDrawable();

        RectShape rectangle2 = new RectShape();
        rectangle2.resize(width, height*1/3);
        lowerDrawable.setShape(rectangle2);
        lowerDrawable.setBounds(0, height*2/3, width, height);

        LinearGradient gradient2 = new LinearGradient(0,0,0, height*1/3, blackColor, darkGrayColor, TileMode.CLAMP);

        Paint paint2 = lowerDrawable.getPaint();
        paint2.setShader(gradient2);
    } /* end CustomViewDrawables constructure*/

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        // Drawable 객체 그리기
        upperDrawable.draw(canvas);
        lowerDrawable.draw(canvas);

        Paint pathPaint = new Paint();
        pathPaint.setAntiAlias(true);
        pathPaint.setColor(Color.YELLOW);
        pathPaint.setStyle(Style.STROKE);
        pathPaint.setStrokeWidth(16.0F);
        pathPaint.setStrokeCap(Cap.BUTT);
        pathPaint.setStrokeJoin(Join.MITER);

        Path path = new Path();
        // moveTo: 좌표 값 추가
        // lineTo: 이전 좌표 값과 선으로 연결되는 좌표 값 추가
        path.moveTo(20, 20);
        path.lineTo(120, 20);
        path.lineTo(160, 90);
        path.lineTo(180, 80);
        path.lineTo(200, 120);

        canvas.drawPath(path, pathPaint);

        pathPaint.setColor(Color.WHITE);
        pathPaint.setStrokeCap(Cap.ROUND);
        pathPaint.setStrokeJoin(Join.ROUND);

        // offset을 주어 좌표 이동한 뒤 Path 객체 그리기
        path.offset(30, 120);
        canvas.drawPath(path, pathPaint);

        pathPaint.setColor(Color.CYAN);
        pathPaint.setStrokeCap(Cap.SQUARE);
        pathPaint.setStrokeJoin(Join.BEVEL);

        // offset을 주어 좌표 이동한 뒤 Path 객체 그리기
        path.offset(30, 120);
        canvas.drawPath(path, pathPaint);
    } /* end onDraw method */
} /* end class CustomViewDrawables */
