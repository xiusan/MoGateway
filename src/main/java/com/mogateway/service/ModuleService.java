package com.mogateway.service;

import com.mogateway.entity.Module;
import com.mogateway.mapper.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */
@Service
public class ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    public List<Module> getModule() {
        return moduleMapper.getModule();
    }
}
