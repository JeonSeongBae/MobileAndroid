package com.example.jsb.ms_hw08_201302476;

/**
 * Created by jsb on 2017-11-09.
 */

public class SingerItem {
    String name;
    String mobile;
    String price;
    String comment;
    int resId;

    public SingerItem(String name, String mobile, String price, String comment, int resId){
        this.name = "["+name+"]";
        this.mobile=mobile;
        this.price=price;
        this.comment=comment;
        this.resId= resId;
    }
    public String getPrice(){return price;}
    public void setPrice(String price){this.price=price;}

    public String getComment(){return comment;}
    public void setComment(String comment){this.comment=comment;}

    public int getResId(){return resId;}
    public void setResId(int resId){this.resId=resId;}

    public String getMobile(){return mobile;}
    public void setMobile(String mobile){this.mobile=mobile;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}
}
