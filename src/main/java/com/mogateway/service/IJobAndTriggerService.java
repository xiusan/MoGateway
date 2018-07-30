package com.mogateway.service;


import com.github.pagehelper.PageInfo;
import com.mogateway.entity.JobAndTrigger;
import com.mogateway.entity.Task;
import com.mogateway.util.Result;

public interface IJobAndTriggerService {
	//public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize, String JOB_NAME);

	public Result addJob(Task task)throws Exception;

	public  void jobreschedule(Task task) throws Exception;

	public  void jobdelete(Task task) throws Exception;

	public  void jobPause(Task task) throws Exception;

	public  void jobresume(Task task) throws Exception;

	public  Result modifyJobTime(Task task);

}
