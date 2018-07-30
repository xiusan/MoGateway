package com.mogateway.quartzJob;

import com.mogateway.contans.Constants;
import com.mogateway.entity.Task;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.TaskService;
import com.mogateway.util.HttpClientUtil;
import com.mogateway.util.JsonUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ExecutJob implements BaseJob,Serializable {

    @Autowired
    private RedisUtil redisService;
    @Autowired
    private TaskService taskService;
    private static Logger log = LoggerFactory.getLogger(ExecutJob.class);


    // 静态变量
   // public static final String EXECUTION_COUNT = "count";

    // Quartz 将每次将会重新实例化对象 ，非静态的成员变量不能用来保持状态
    private int _counter = 1;

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {

        // job 的名字
        String jobName = context.getJobDetail().getKey().getName();
        //String jobGroupname =context.getJobDetail().getKey().getGroup();
        //int exeCount = Integer.valueOf(context.getJobDetail().getJobDataMap().get(Constants.EXECUTION_COUNT).toString());
        // 任务执行的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");
        String jobRunTime = dateFormat.format(java.util.Calendar.getInstance().getTime());

        // 获取 JobDataMap , 并从中取出参数
        JobDataMap data = context.getJobDetail().getJobDataMap();
        int count = data.getInt(Constants.EXECUTION_COUNT);
        String mehtod = data.getString(Constants.JOB_MEHTOD);
        String jobGroupName = data.getString(Constants.JOB_GROUP_NAME);

        Task task = new Task();
        task.setJobGroupName(jobGroupName);
        List<Task> tasks = taskService.selectByExample(task);
        if (tasks.size()==0){
            context.getJobDetail().getJobDataMap().remove(Constants.EXECUTION_COUNT);
            context.getJobDetail().getJobDataMap().remove(Constants.JOB_MEHTOD);
            context.getJobDetail().getJobDataMap().remove(Constants.JOB_GROUP_NAME);
            return ;
        }


        System.out
                .println("ColorJob: " + jobName + " 在 " + jobRunTime + " 执行了"+mehtod+" ...  \n"
                        + "      执行次数统计(from job jobDataMap)： " + count + "\n"
                        + "      执行次数统计( from job 类的成员变 量 ): "
                        + _counter+ " \n ");
        try {
            redisService.setValue(Constants.EXECUT_COUNT+jobGroupName, JsonUtils.objectToJson(count));

            log.info("ExecutJob execute");

            String info = HttpClientUtil.httpPost(mehtod, null, null);

            log.info(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 每次+1 并放回Map 中
        count++;


        data.put(Constants.EXECUTION_COUNT, count);
        // 成员变量的增加没有意义，每次实例化对象的时候会 同时初始化该变量
        _counter++;
    }


}
