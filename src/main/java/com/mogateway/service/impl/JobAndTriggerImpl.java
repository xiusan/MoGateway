package com.mogateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.contans.Constants;
import com.mogateway.entity.JobAndTrigger;
import com.mogateway.entity.Task;
import com.mogateway.mapper.JobAndTriggerMapper;
import com.mogateway.mapper.TaskMapper;
import com.mogateway.quartzJob.BaseJob;
import com.mogateway.redis.RedisUtil;
import com.mogateway.service.IJobAndTriggerService;
import com.mogateway.util.DateUtil;
import com.mogateway.util.Result;
import com.mogateway.util.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {

	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	@Autowired
	private TaskMapper taskMapper;
	@Autowired
	private RedisUtil redisUtil;

	/**
	 * 	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize , String JOB_NAME) {
	 PageHelper.startPage(pageNum, pageSize);
	 //List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails(JOB_NAME);
	 //PageInfo<JobAndTrigger> page = new PageInfo<JobAndTrigger>(list);
	 return page;
	 }
	 * @param task
	 * @throws Exception
	 */



	@Transactional
	@Override
	public  Result addJob(Task task)throws Exception {
		// 通过SchedulerFactory获取一个调度器实例
		//SchedulerFactory sf = new StdSchedulerFactory();
		Result res= new Result();
		Scheduler sched = schedulerFactoryBean.getScheduler();
		// 启动调度器
		sched.start();
		JobDetail jobDetail =null;
		try {
			//构建job信息
			jobDetail = JobBuilder.newJob(getClass(task.getTaskMethod()).getClass()).withIdentity(task.getTaskMethod(), task.getJobGroupName()).build();
		}catch (Exception e){
			System.out.println("找不到该类方法"+e);
			throw new Exception("找不到该类方法");
		}
		// 初始化传入的参数
		//jobDetail.getJobDataMap().putAsString(Constants.EXECUTION_COUNT,1);
		jobDetail.getJobDataMap().put(Constants.EXECUTION_COUNT, 1);
		jobDetail.getJobDataMap().put(Constants.JOB_MEHTOD, task.getMethod());
		jobDetail.getJobDataMap().put(Constants.JOB_GROUP_NAME, task.getJobGroupName());
		//表达式调度构建器(即任务执行的时间)
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(task.getCronExpression());
		try {
			//按新的cronExpression表达式构建一个新的trigger
			CronTrigger trigger =null;
			Date dt1 =new Date();
			if (StringUtils.isNotEmpty(task.getStartTime()) && StringUtils.isNotEmpty(task.getStopTime())){
				trigger = TriggerBuilder.newTrigger().withIdentity(task.getTaskMethod(), task.getJobGroupName()).startAt(task.getStartTime()).endAt(task.getStopTime())
						.withSchedule(scheduleBuilder).build();
				if (task.getStopTime().getTime() > dt1.getTime()){

					int count = taskMapper.insertSelective(task);
					if (count>0){
						sched.scheduleJob(jobDetail, trigger);
						redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "添加定时任务成功");
						res.addSuccess(null);
					}
					return res;
				}else {
					res.addError("TaskManage","过期时间必须大于当前时间");
					return res;
				}
			}else{
				trigger = TriggerBuilder.newTrigger().withIdentity(task.getTaskMethod(), task.getJobGroupName())
						.withSchedule(scheduleBuilder).build();
				sched.scheduleJob(jobDetail, trigger);
				int count = taskMapper.insertSelective(task);
				if (count>0){
					redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "添加定时任务成功");
					res.addSuccess(null);
				}
				return res;


			}

		} catch (SchedulerException e) {
			System.out.println("创建定时任务失败"+e);
			redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "创建定时任务失败");
			throw new Exception("创建定时任务失败");
		}
	}

	@Override
	public  Result modifyJobTime(Task task) {
		Result result =new Result();
		try {

				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				//TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
				// 触发器名,触发器组
				//triggerBuilder.withIdentity(triggerName, triggerGroupName);
				//triggerBuilder.startNow();
				// 触发器时间设定
				//triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
				// 创建Trigger对象
				//trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				//sched.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */

				/** 方式二：先删除，然后在创建一个新的Job  */
				jobdelete(task);
				result = addJob(task);
				/** 方式二 ：先删除，然后在创建一个新的Job */
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 * @Description: 移除一个任务
	 *
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 */
	public  void removeJob(String jobName, String jobGroupName,
								 String triggerName, String triggerGroupName) {
		try {
			Scheduler sched = schedulerFactoryBean.getScheduler();

			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);

			sched.pauseTrigger(triggerKey);// 停止触发器
			sched.unscheduleJob(triggerKey);// 移除触发器
			sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	@Override
	public  void jobreschedule(Task task) throws Exception
	{
		try {


			//SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(task.getTaskMethod(), task.getJobGroupName());
			// 表达式调度构建器
			CronScheduleBuilder scheduleBuilder = null;
			try{
				scheduleBuilder=  CronScheduleBuilder.cronSchedule(task.getCronExpression());
			}catch (Exception e){
				System.out.println("cron表达式错误"+e);
				throw new Exception("cron表达式错误");
			}

			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			try{
				if (StringUtils.isNotEmpty(task.getStartTime()) && StringUtils.isNotEmpty(task.getStopTime())){
					// 按新的cronExpression表达式重新构建trigger
					trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).startAt(task.getStartTime()).endAt(task.getStopTime()).withSchedule(scheduleBuilder).build();
				}else {
					trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
				}

			}catch (Exception e){
				System.out.println("找不到该类方法"+e);
				throw new Exception("找不到该类方法");
			}


			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
			task.setTaskStatus(1);
			int count =taskMapper.updateByPrimaryKey(task);
			if (count>0){
				redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "修改定时任务成功");
			}
		} catch (SchedulerException e) {
			System.out.println("更新定时任务失败"+e);
			throw new Exception("更新定时任务失败");
		}
	}

	@Transactional
	@Override
	public  void jobdelete(Task task) throws Exception
	{
		// 通过SchedulerFactory获取一个调度器实例
		//SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = schedulerFactoryBean.getScheduler();
		sched.pauseTrigger(TriggerKey.triggerKey(task.getTaskMethod(), task.getJobGroupName()));
		sched.unscheduleJob(TriggerKey.triggerKey(task.getTaskMethod(), task.getJobGroupName()));
		sched.deleteJob(JobKey.jobKey(task.getTaskMethod(), task.getJobGroupName()));

		int count =taskMapper.deleteByPrimaryKey(task.getTimedTaskId());
		if (count>0){
			redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "删除定时任务成功");
		}
	}

	@Transactional
	@Override
	public  void jobPause(	Task task) throws Exception
	{
		// 通过SchedulerFactory获取一个调度器实例
		//SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = schedulerFactoryBean.getScheduler();
		sched.pauseJob(JobKey.jobKey(task.getTaskMethod(), task.getJobGroupName()));
		int count = taskMapper.updateByPrimaryKeySelective(task);
		if (count>0){
			redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "恢复定时任务成功");
		}

	}

	@Transactional
	@Override
	public  void jobresume(Task task) throws Exception
	{
		// 通过SchedulerFactory获取一个调度器实例
		//SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = schedulerFactoryBean.getScheduler();
		sched.resumeJob(JobKey.jobKey(task.getTaskMethod(), task.getJobGroupName()));
		int count = taskMapper.updateByPrimaryKeySelective(task);
		if (count>0){
			redisUtil.pubLog("TaskManage", "定时任务管理", "admin", "暂停定时任务成功");
		}
	}



	public static BaseJob getClass(String classname) throws Exception
	{
			Class<?> class1 = Class.forName(classname);
			return (BaseJob)class1.newInstance();

	}

}