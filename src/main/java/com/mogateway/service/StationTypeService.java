package com.mogateway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogateway.entity.StationType;
import com.mogateway.mapper.StationTypeMapper;


/**
* 类名称：StationTypeService
* 创建人：
* 创建时间：2018-07-18
* 描   述:
*/

@Service("stationtypeService")
public class  StationTypeService {

	@Autowired
	private StationTypeMapper stationtypeMapper;

	/**
	* 查询列表
	* @param stationtype
	* @return
	*/
	public List<StationType> getStationTypeList(StationType stationtype) {
		return stationtypeMapper.getStationTypeList(stationtype);
		}


	public int saveStationType(StationType stationtype) {
		return stationtypeMapper.saveStationType(stationtype);
		}

	public int updateStationType(StationType stationtype) {
		return stationtypeMapper.updateStationType(stationtype);
		}

	public int delStationType(StationType stationtype) {
	return stationtypeMapper.delStationType(stationtype);
		}
}