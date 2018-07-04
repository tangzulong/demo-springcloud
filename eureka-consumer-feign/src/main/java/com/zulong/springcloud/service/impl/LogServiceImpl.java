package com.zulong.springcloud.service.impl;


import com.zulong.base.dto.LogDO;
import com.zulong.springcloud.mapper.LogDao;
import com.zulong.springcloud.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logMapper;

    /*@Async
    @Override
    public int save(LogDO logDO) {
        return logMapper.save(logDO);
    }
    @Override
    public int remove(Long id) {
        int count = logMapper.remove(id);
        return count;
    }

    @Override
    public int batchRemove(Long[] ids) {
        return logMapper.batchRemove(ids);
    }*/

    @Override
    public LogDO getList(String id) {
        return logMapper.get(Long.parseLong(id));
    }


}
