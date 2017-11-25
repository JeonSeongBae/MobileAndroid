package com.example.jsb.ms_hw10_201302476_jeonseongbae;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;


public class CustomerItemView extends FrameLayout {
    TextView textView;
    TextView textView2;
    TextView textView3;

    public CustomerItemView(Context context) {
        super(context);
        init(context);
    }

    public CustomerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item, this, true);
        textView = (TextView) findViewById(R.id.name);
        textView2 = (TextView) findViewById(R.id.mobile);
        textView3 = (TextView) findViewById(R.id.address);
    }

    public void setName(String name) {
        textView.setText(name);
    }
    public void setAddress(String address) {
        textView2.setText(address);
    }
    public void setMobile(String mobile) {
        textView3.setText(mobile);
    }

}