package com.mogateway.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mogateway.entity.LogHistory;
import com.mogateway.mapper.LogHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-04-26.
 */
@Service
public class LogHistoryService {

    @Autowired
    private LogHistoryMapper logHistoryMapper;

    public PageInfo<LogHistory> getLogHistory(LogHistory logHistory, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<LogHistory> logHistorys = logHistoryMapper.getLogHistory(logHistory);
        return new PageInfo<>(logHistorys);
    }
}
