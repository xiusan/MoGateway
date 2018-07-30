package com.mogateway.quartzJob;

import com.mogateway.contans.Constants;
import com.mogateway.redis.RedisUtil;
import com.mogateway.util.HttpClientUtil;
import com.mogateway.util.JsonUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class FaultJob implements BaseJob {
  
    private static Logger log = LoggerFactory.getLogger(FaultJob.class);

    @Autowired
    private RedisUtil redisService;
//    @Autowired
//    private TaskService taskService;
//    @Autowired
//    private RedisUtil redisUtil;
    // 静态变量
    // public static final String EXECUTION_COUNT = "count";

    // Quartz 将每次将会重新实例化对象 ，非静态的成员变量不能用来保持状态
    private int _counter = 1;

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        // job 的名字
        String jobName = context.getJobDetail().getKey().getName();
        // 任务执行的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy 年 MM 月 dd 日  HH 时 mm 分 ss 秒");
        String jobRunTime = dateFormat.format(java.util.Calendar.getInstance().getTime());

        // 获取 JobDataMap , 并从中取出参数
        JobDataMap data = context.getJobDetail().getJobDataMap();
        int count = data.getInt(Constants.EXECUTION_COUNT);
        log.info("ColorJob: " + jobName + " 在 " + jobRunTime + " 执行了 ...  \n"
                        + "      执行次数统计(from job jobDataMap)： " + count + "\n"
                        + "      执行次数统计( from job 类的成员变 量 ): "
                        + _counter+ " \n ");
        try {
           redisService.setValue(Constants.EXECUT_COUNT+jobName, JsonUtils.objectToJson(count));

            log.info("UnzipJob execute");

            String info = HttpClientUtil.httpGet("http://192.168.1.123:8181/Diagnosis/cronRemote/cronFaultInfoOnDateAll", null, null);

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