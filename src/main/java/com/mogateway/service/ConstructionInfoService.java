package com.mogateway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogateway.entity.ConstructionInfo;
import com.mogateway.mapper.ConstructionInfoMapper;


/**
* 类名称：ConstructionInfoService
* 创建人：
* 创建时间：2018-07-18
* 描   述:
*/

@Service("constructioninfoService")
public class  ConstructionInfoService {

	@Autowired
	private ConstructionInfoMapper constructioninfoMapper;

	/**
	* 查询列表
	* @param constructioninfo
	* @return
	*/
	public List<ConstructionInfo> getConstructionInfoList(ConstructionInfo constructioninfo) {
		return constructioninfoMapper.getConstructionInfoList(constructioninfo);
		}


	public int saveConstructionInfo(ConstructionInfo constructioninfo) {
		return constructioninfoMapper.saveConstructionInfo(constructioninfo);
		}

	public int updateConstructionInfo(ConstructionInfo constructioninfo) {
		return constructioninfoMapper.updateConstructionInfo(constructioninfo);
		}

	public int delConstructionInfo(ConstructionInfo constructioninfo) {
	return constructioninfoMapper.delConstructionInfo(constructioninfo);
		}
}