package com.example.jsb.ms_hw08_201302476;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jsb on 2017-11-09.
 */

public class SingerItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView imageView;

    public SingerItemView(Context context){
        super(context);
        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs){
        super(context, attrs);
        init(context);
    }
    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item,this, true);

        textView =(TextView)findViewById(R.id.company);
        textView2 =(TextView)findViewById(R.id.name);
        textView3 =(TextView)findViewById(R.id.price);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
    public void setName(String name){textView.setText(name);}
    public void setMobile(String mobile){textView2.setText(mobile);}
    public void setYear(int year){textView3.setText(String.valueOf(year));}
    public void setImage(int resId){imageView.setImageResource(resId);}
}
