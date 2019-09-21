import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author zhangyu
 * @date 2019-09-17-9:32
 */
public class TimerDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        class MyTimerTask extends TimerTask{

            @Override
            public void run() {
                System.out.println("hhhh");
            }
        }
        TimerTask timerTask = new MyTimerTask();
        timer.schedule(timerTask,3000,1000);
      /*  Date date = new Date();
        long time = date.getTime();
        System.out.println(time);*/
    }
}
