package com.cqucc;

import com.cqucc.utils.ImageUtils;

import java.util.EnumMap;

/**
 * @author zhangyu
 * @date 2019-09-20-15:09
 */

/*
* 子弹类
* */
public class Bullet extends FlyingObject{

    int speed=3;
    public Bullet(int x,int y) {
        image=ImageUtils.load("bullet.png");
        w=image.getWidth();
        h=image.getHeight();
        this.x=x-w/2;
        this.y=y;
    }

    @Override
    void step() {
        y-=speed;
    }

    /*
    * 判断子弹是否打中敌机
    *
    * */
    boolean isTouch(Enemy enemy){
        int x1=enemy.x-w;
        int x2=enemy.x+enemy.w;

        int y1=enemy.y-h;
        int y2=enemy.y+enemy.h;


        if (x>x1 && x<x2 &&  y>y1 && y<y2){
            return true;
        }
            return false;

    }


}
