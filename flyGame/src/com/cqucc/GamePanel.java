package com.cqucc;

import com.cqucc.utils.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhangyu
 * @date 2019-09-11-8:38
 */
public class GamePanel extends JPanel {
    int score=0;

    public GamePanel(){
      /* class MyMouse implements MouseListener{

           @Override
           public void mouseClicked(MouseEvent e) {
               //修改游戏状态值,让游戏从就绪态转变为运行态
               status=Constant.RUNNING;
           }
           @Override
           public void mousePressed(MouseEvent e) { }
           @Override
           public void mouseReleased(MouseEvent e) { }
           @Override
           public void mouseEntered(MouseEvent e) { }
           @Override
           public void mouseExited(MouseEvent e) { }
       }
       MouseListener mouseListener=new MyMouse();*/
      class MyMouseAdapter extends MouseAdapter{
          @Override
          public void mouseClicked(MouseEvent e) {
              status=Constant.RUNNING;
          }
          /*
          * 鼠标每移动一个像素（1px）执行一次*/
          @Override
          public void mouseMoved(MouseEvent e) {
              /*鼠标对象e封装了鼠标所有的信息
              * 因此想要e对象来获取鼠标的横纵坐标*/
              int x = e.getX();//获取鼠标横坐标
              int y = e.getY();//获取鼠标纵坐标

              if (status==Constant.RUNNING){
                  hero.moveTo(x,y);
              }
          }
      }
       MouseAdapter adapter = new MyMouseAdapter();
       addMouseListener(adapter);//添加鼠标监听器,出发鼠标的简单动作，例如点击、释放等
       addMouseMotionListener(adapter);//出发鼠标的高级动作，例如移动，拖拽

/*
* 定时器的创建*/
       Timer timer = new Timer();
     class  MyTimerTask extends TimerTask{

         void addEnemy(){
             int type= (int) (Math.random()*20);
             switch (type){
                 case 0:
                     Bee bee = new Bee();
                     enemies.add(bee);
                     break;
                     default:
                         AirPlane airPlane=new AirPlane();
                         enemies.add(airPlane);
                         break;
             }
         }

         void enemyStep(){
             for (int i=0;i<enemies.size();i++){
                 Enemy enemy = enemies.get(i);
                 enemy.step();
             }

         }
         /*
         * 英雄机发射子弹
         * */
         void shoot(){
             List<Bullet> buibui = hero.buibui();
             all.addAll(buibui);//把buibui集合全部添加到all集合

         }
         int index=0;

         /*
         * 子弹走路
         * */
        void bulletStep(){
            for (Bullet bullet : all) {
                bullet.step();
            }
        }

        /*
        * 子弹打敌机
        * */
        void hit(){
         /*   for (int i = 0; i <all.size() ; i++) {
                Bullet bullet = all.get(i);
                for (int j=0;j<enemies.size();j++){
                    Enemy enemy = enemies.get(j);
                    boolean result = bullet.isTouch(enemy);
                    if (result){
                        all.remove(i);
                        enemies.remove(j);

                    }
                }
            }*/
         for (int i=all.size()-1;i>=0;i--){
             Bullet bullet = all.get(i);
             for (int j=enemies.size()-1;j>=0;j--){
                 Enemy enemy = enemies.get(j);

                 boolean touch = bullet.isTouch(enemy);
                 if (touch){
                     all.remove(i);
                     enemies.remove(j);
                    score++;
                    if (score>20){
                        Hero.fire=2*Hero.ONE_FIRE;

                    }if (score>40){
                            Hero.fire=3*Hero.ONE_FIRE;
                    }
                 }
             }
         }

        }         @Override
         public void run() {
             if (status==Constant.RUNNING){
                 if (index%80==0){
                        addEnemy();
                 }
                 //airPlane.step();
                 enemyStep();
                    if (index%20==0) {
                        shoot();
                    }
                 bulletStep();

                 hit();

                 index++;

             }
             /*调用repaint方法通知面板重绘
             * 一旦面板接收到通知后，会立刻调用paint方法
             * 将面板重新绘制一次*/
             repaint();
         }
     }
     TimerTask task=new MyTimerTask();
       timer.schedule(task,0,10);

   }
    Hero hero=new Hero();
    //AirPlane airPlane=new AirPlane();
    /*List<AirPlane> airs=new ArrayList<AirPlane>();//一群小飞机
    List<Bee> bees=new ArrayList<Bee>();*/

    List<Enemy> enemies=new ArrayList<Enemy>(); //敌机

    List<Bullet> all=new ArrayList<Bullet>();//所有子弹

    void paintScoreAndLife(Graphics g){
        g.drawString("SCORE:"+score,10,20);//分数
        g.drawString("LIFE:3",10,35);//生命
    }

    void paintBackground(Graphics g){
        //调用ImageUtils加载图片
        BufferedImage image = ImageUtils.load("background.png");
        g.drawImage(image,0,0,null);
    }

    //游戏状态

    int status=0;//0->start   1->running  2->pause  3->gameover
    //当前游戏的状态
    void paintState(Graphics g){
        //根据游戏状态值加载对应的状态图
        switch (status){//可以支持char byte short int 枚举 String
            case Constant.START:
                BufferedImage start = ImageUtils.load("start.png");
                g.drawImage(start,0,0,null);
                break;
           /* case 1:
                BufferedImage start = ImageUtils.load("r.png");
                g.drawImage(start,0,0,null);*/
            case Constant.PAUSE:
                BufferedImage pause = ImageUtils.load("pause.png");
                g.drawImage(pause,0,0,null);
                break;

            case Constant.GAMEOVER:
                BufferedImage gameover = ImageUtils.load("gameover.png");
                g.drawImage(gameover,0,0,null);
                break;
        }
    }

    /*
    * */
    void paintHero(Graphics g){
        g.drawImage(hero.image,hero.x,hero.y,null);
    }

    void paintBullet(Graphics g){
        for (Bullet bullet : all) {
            g.drawImage(bullet.image,bullet.x,bullet.y,null);
        }
    }

    void paintEnemy(Graphics g){

        for(int i=0;i<enemies.size();i++)
             {
                 Enemy enemy = enemies.get(i);
                 g.drawImage(enemy.image, enemy.x, enemy.y, null);


             }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);//别删
        paintBackground(g);     //绘制游戏背景
        paintScoreAndLife(g);    //绘制游戏得分和生命
        paintHero(g);
        paintBullet(g);
        paintEnemy(g);
        paintState(g);

    }
}
