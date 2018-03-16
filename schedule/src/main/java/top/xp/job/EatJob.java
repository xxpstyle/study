package top.xp.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xuepei
 * @date 2018/3/15 9:33
 */
@Component
public class EatJob {
//spring全注解式的任务调度：spring-task
    // cron只支持6个部分
    @Scheduled(cron = "0/5 * * * * ?")
    public void run() {
        System.out.println("快去吃饭啦……");
    }

}
