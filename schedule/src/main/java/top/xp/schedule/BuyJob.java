package top.xp.schedule;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BuyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 作业执行上下文件，包含了作业执行过程中相关的信息，jobdetail， 参数
        JobDataMap dataMap=jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("小明拿着"+dataMap.get("money")+"去买"+dataMap.get("thing"));
    }
}
