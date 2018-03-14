package top.xp.schedule;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


//通过java.util.Timer类的任务调度
public class TimerTest {
    public static void main(String[] args) {
//延迟30秒执行
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务！");
                timer.cancel();
            }
        }, 3 * 1000);

//指定时间执行
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 2, 14, 15, 8, 30);
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务");
                timer1.cancel();
            }
        }, calendar.getTime());
    }
}
