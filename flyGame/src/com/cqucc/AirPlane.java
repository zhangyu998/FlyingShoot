package com.cqucc;

import com.cqucc.utils.ImageUtils;

/**
 * @author zhangyu
 * @date 2019-09-18-8:34
 */
public class AirPlane extends Enemy{

    int speed=2;//

    public AirPlane() {
        image=ImageUtils.load("airplane.png");
        w=image.getWidth();
        h=image.getHeight();
        y=-h;
        x= (int) (Math.random()*(400-w));


    }

    @Override
    void step() {
        y=y+speed;
    }
}
