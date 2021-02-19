package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.DevInfo;
import org.springframework.stereotype.Repository;

/**
 * 执法仪相关数据(DevInfo)表数据库访问层
 *
 * @author archie Lin
 * @since 2021-02-18 16:32:19
 */
@Repository
public interface DevInfoDao extends BaseMapper<DevInfo> {

}
