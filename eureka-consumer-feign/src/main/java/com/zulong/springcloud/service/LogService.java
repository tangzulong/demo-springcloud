package com.zulong.springcloud.service;


import com.zulong.base.dto.LogDO;
import org.springframework.stereotype.Service;



@Service
public interface LogService {
    /*int save(LogDO logDO);

    int remove(Long id);

    int batchRemove(Long[] ids);*/

    LogDO getList(String id);
}
