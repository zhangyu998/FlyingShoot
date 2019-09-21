package com.cqucc;

import com.cqucc.utils.ImageUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @date 2019-09-16-15:07
 */
public class Hero extends FlyingObject{

    /*
    *火力
    * 20---1倍火力
    * 40---1倍火力
    * 60---1倍火力
    * 80---1倍火力
    * 100---1倍火力
    */
    public static final int ONE_FIRE=20;

   static int fire=ONE_FIRE;//
    public Hero() {
        x=150;
        y=400;
        image= ImageUtils.load("hero0.png");
        w=image.getWidth();
        h=image.getHeight();
    }

    /*
    * x是鼠标的横纵表
    * y是鼠标的纵坐标
    * */
    public void moveTo(int x, int y) {
        this.x=x-w/2;
        this.y=y-h/2;
    }

    /*
    * 发射子弹
    * */
   List<Bullet> buibui(){
        List<Bullet> bullets=new ArrayList<Bullet>();
        int num=fire/ONE_FIRE;//获取子弹发射的颗数
        num=num>5?5:num;//限制最大5颗子弹
        int ew=w/(num+1);
        for (int i = 0; i < num; i++) {//根据子弹颗数循环创建子弹
            int bx=x+ew*(i+1);
            int by=y-20;
            Bullet bullet=new Bullet(bx,by);
                   bullets.add(bullet);
        }
        return bullets;
    }

    @Override
    void step() {
        //喷火
    }
}
