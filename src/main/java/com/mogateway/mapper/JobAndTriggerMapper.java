package com.mogateway.mapper;




import com.mogateway.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobAndTriggerMapper {
	public List<JobAndTrigger> getJobAndTriggerDetails(String JOB_GROUP);
}
