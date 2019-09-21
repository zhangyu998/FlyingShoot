import javax.swing.*;
import java.awt.*;

/**
 * @author zhangyu
 * @date 2019-09-10-8:41
 */
public class MyFrame extends JFrame {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        MyPanel p=new MyPanel();
        f.add(p);
        f.setSize(800,600);
        f.setLocationRelativeTo(null);
        f.setTitle("MyFrame");
        f.setDefaultCloseOperation(3);
        f.setVisible(true);
    }
}
class  MyPanel extends JPanel{
    public void paint(Graphics g) {
        super.paint(g);




        for(int i=0;i<300;i++){
            int red=(int)(Math.random()*256);
            int green=(int)(Math.random()*256);
            int blue=(int)(Math.random()*256);
            Color color=new Color(red,green,blue);
            g.setColor(color);


            int size=(int)(Math.random()*80)+30;
            System.out.println(size);
            Font font=new Font(null,1,size);
            g.setFont(font);

            int x=(int)(Math.random()*801);
            int y=(int)(Math.random()*601);
            g.drawString("*",x,y);
        }
/*
画空心圆
        g.drawOval();
*/
//实心圆
        g.fillOval(300,100,300,300);

}

}
