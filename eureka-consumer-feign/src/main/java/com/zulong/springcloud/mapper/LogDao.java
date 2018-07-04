package com.zulong.springcloud.mapper;

import com.zulong.base.dto.LogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统日志
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface LogDao {

	LogDO get(Long id);
}
