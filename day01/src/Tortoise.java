import javax.swing.*;
import java.awt.*;

/**
 * @author zhangyu
 * @date 2019-09-10-13:58
 */
public class Tortoise {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("乌龟");
        jFrame.setSize(800,800);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

        JPanel jPanel=new TortoisePanel();
        jFrame.add(jPanel);
    }
}

class TortoisePanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //乌龟头型
        g.setColor(new Color(21,96,21));
        g.fillOval(330,70,140,180);
        //乌龟头上的两只眼睛
        g.setColor(new Color(0,0,0));
        g.fillOval(360,100,20,20);
        g.fillOval(420,100,20,20);

        //乌龟的四肢
        g.setColor(new Color(27,110,27));
        g.fillOval(210,220,100,100);//左前爪
        g.fillOval(210,490,100,100);//左后爪
        g.fillOval(490,220,100,100);//右前爪

        //乌龟尾巴
        g.fillOval(390,560,80,100);
        g.setColor(new Color(238,238,238));//238
        g.fillOval(410,500,200,200);

        //之所以后画右后爪，是因为画尾巴的两个圆会遮住右后爪的圆
        g.setColor(new Color(27,110,27));
        g.fillOval(490,490,100,100);//右后爪

        //龟壳
        g.setColor(new Color(4,55,4));
        g.fillOval(240,200,320,400);

        //龟壳花纹
        g.setColor(new Color(0,0,0));
        g.drawLine(320,300,320,500);
        g.drawLine(320,300,480,300);
        g.drawLine(480,300,480,500);
        g.drawLine(480,500,320,500);



        //水平垂直参考线
        g.setColor(new Color(0,0,0));
        g.drawLine(0,400,800,400);
        g.drawLine(400,0,400,800);
    }
}