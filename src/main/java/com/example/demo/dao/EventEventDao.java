package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.EventEvent;
import org.springframework.stereotype.Repository;

/**
 * 案件表(EventEvent)表数据库访问层
 *
 * @author archie Lin
 * @since 2021-02-18 16:40:48
 */
@Repository
public interface EventEventDao extends BaseMapper<EventEvent> {

}
