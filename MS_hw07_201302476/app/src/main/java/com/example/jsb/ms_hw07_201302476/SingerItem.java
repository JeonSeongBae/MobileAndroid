package com.example.jsb.ms_hw07_201302476;

/**
 * Created by jsb on 2017-10-28.
 */

public class SingerItem {
    String name;
    String mobile;
    String year;
    int resId;

    public SingerItem(String name, String mobile, String year, int resId){
        this.name = name;
        this.mobile=mobile;
        this.year=year;
        this.resId= resId;
    }
    public String getYear(){return year;}
    public void setYear(String year){this.year=year;}

    public int getResId(){return resId;}
    public void setResId(int resId){this.resId=resId;}

    public String getMobile(){return mobile;}
    public void setMobile(String mobile){this.mobile=mobile;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

}
