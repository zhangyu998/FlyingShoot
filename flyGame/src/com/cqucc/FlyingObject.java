package com.cqucc;

import java.awt.image.BufferedImage;

/**
 * @author zhangyu
 * @date 2019-09-18-8:32
 */
public abstract class FlyingObject {
    int x;
    int y;
    int w;
    int h;
    BufferedImage image;

   abstract void step();
}
