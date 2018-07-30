package com.mogateway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogateway.entity.StationStatus;
import com.mogateway.mapper.StationStatusMapper;


/**
* 类名称：StationStatusService
* 创建人：
* 创建时间：2018-07-18
* 描   述:
*/

@Service("stationstatusService")
public class  StationStatusService {

	@Autowired
	private StationStatusMapper stationstatusMapper;

	/**
	* 查询列表
	* @param stationstatus
	* @return
	*/
	public List<StationStatus> getStationStatusList(StationStatus stationstatus) {
		return stationstatusMapper.getStationStatusList(stationstatus);
		}


	public int saveStationStatus(StationStatus stationstatus) {
		return stationstatusMapper.saveStationStatus(stationstatus);
		}

	public int updateStationStatus(StationStatus stationstatus) {
		return stationstatusMapper.updateStationStatus(stationstatus);
		}

	public int delStationStatus(StationStatus stationstatus) {
	return stationstatusMapper.delStationStatus(stationstatus);
		}
}