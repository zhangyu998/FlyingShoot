package com.cqucc;

import com.cqucc.utils.ImageUtils;

/**
 * @author zhangyu
 * @date 2019-09-18-11:00
 */

/*
* 蜜蜂类
* */
public class Bee extends Enemy{
    public static final int LEFT=0;
    public static final int RIGHT=1;
    int xSpeed;//水平速度
    int ySpeed;//垂直速度
    int direction;//方向  0->左边进   1->右边进
    public Bee() {
        image= ImageUtils.load("bee.png");
        w=image.getWidth();
        h=image.getHeight();
        y=-h;
        x= (int) (Math.random()*(400-w));
        xSpeed= (int) (Math.random()*4+1);
        ySpeed= (int) (Math.random()*3+1);
        direction= (int) (Math.random()*2);
    }

    @Override
    void step() {
        y=y+ySpeed;
            switch (direction){
                case LEFT:x-=xSpeed;
                break;
                case RIGHT:x+=xSpeed;
                break;
            }
            if (x<=0){
                direction=RIGHT;
            }
            if (x>=400-w){
                direction=LEFT;
            }
    }
}
