package com.cqucc;

import javax.swing.*;

/**
 *
 * 飞机游戏启动类
 * @author zhangyu
 * @date 2019-09-11-8:26
 */
public class Go {
    public static void main(String[] args) {
        JFrame f=new JFrame("飞机大战");
        f.setSize(400,654);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// f.setDefaultCloseOperation(3);
        f.setResizable(false);//关闭窗体最大化功能
        f.add(new GamePanel());
        f.setVisible(true);
    }
}
