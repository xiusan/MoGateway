package com.mogateway.mapper;

import com.mogateway.entity.Module;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */
@Mapper
public interface ModuleMapper {

    @Select("select * from module")
    List<Module> getModule();
}
