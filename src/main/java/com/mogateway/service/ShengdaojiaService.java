package com.mogateway.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mogateway.entity.Shengdaojia;
import com.mogateway.mapper.ShengdaojiaMapper;


/**
* 类名称：ShengdaojiaService
* 创建人：
* 创建时间：2018-07-31
* 描   述:
*/

@Service("shengdaojiaService")
public class  ShengdaojiaService {

	@Autowired
	private ShengdaojiaMapper shengdaojiaMapper;

	/**
	* 查询列表
	* @param shengdaojia
	* @return
	*/
	public List<Shengdaojia> getShengdaojiaList(Shengdaojia shengdaojia) {
		return shengdaojiaMapper.getShengdaojiaList(shengdaojia);
		}


	public int saveShengdaojia(Shengdaojia shengdaojia) {
		return shengdaojiaMapper.saveShengdaojia(shengdaojia);
		}

	public int updateShengdaojia(Shengdaojia shengdaojia) {
		return shengdaojiaMapper.updateShengdaojia(shengdaojia);
		}

	public int delShengdaojia(Shengdaojia shengdaojia) {
	return shengdaojiaMapper.delShengdaojia(shengdaojia);
		}
}