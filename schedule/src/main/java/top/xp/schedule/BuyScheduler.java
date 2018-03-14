package top.xp.schedule;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class BuyScheduler {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            JobDataMap dataMap = new JobDataMap();
            dataMap.put("money", 100);
            dataMap.put("thing", "陈桢");
            JobDetail jobDetail = JobBuilder.newJob(BuyJob.class)
                    .withIdentity("buyJob", "buyJob").setJobData(dataMap).build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("buyTrigger", "buyTrigger")
                    //.withSchedule(SimpleScheduleBuilder.repeatHourlyForever(5))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).withRepeatCount(3))
                    //Cron表达式
                    //.withSchedule(CronScheduleBuilder.cronSchedule("0/5 0-50 11-12 * * ? *"))
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cron表达式
     * 由6或7个部分组成，每一个部分都有特定的含义，每一个部分用空格分割
     *
     * second minute hour date month day year
     * second minute hour date month day
     * 字段名                 允许的值                        允许的特殊字符
     秒                         0-59                               , - * /
     分                         0-59                               , - * /
     小时                     0-23                               , - * /
     日                         1-31                               , - * ? / L W C
     月                         1-12 or JAN-DEC               , - * /
     周几                     1-7 or SUN-SAT                  , - * ? / L C #
     年 (可选字段)        empty, 1970-2099                    , - * /


     ?　只会出现在date和day里，并且只会出现一次，表示不确定的值
     * 匹配任意值
     - 范围
     , 多个值
     / 间隔
     L 用在日期中表示月里的最后一天，用在星期中，表示月里的最后一个星期几
     W 离给定日期最近的工作日，不确定的一定值
     “#”字符：表示该月第几个周X。6#3表示该月第3个周五

     2018年的3月14日上午11点30分0秒
     0 30 11 14 3 ? 2018

     每年的3月14日晚上20点0分0秒
     0 0 20 14 3 ? *

     每年的3月14日晚上20点到22点的30分0秒
     0 30 20-22 14 3 ? *

     每年的3月14日晚上20点到22点的15分和30分0秒
     0 15,30 20-22 14 3 ? *

     每年的每月的周日晚上20点0分0秒
     0 0 20 ? * 1 *

     每年的3月14日晚上20点到22点的0分0秒,每隔5秒
     0/5 0 20-22 14 3 ? *

     每年每月的最后一天晚上20点0分0秒
     0 0 20 L * ? *

     */
}
