package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.EventEventDao;
import com.example.demo.entity.EventEvent;
import com.example.demo.service.EventEventService;
import org.springframework.stereotype.Service;

/**
 * 案件表(EventEvent)表服务实现类
 *
 * @author archie Lin
 * @since 2021-02-18 16:40:48
 */
@Service
public class EventEventServiceImpl extends ServiceImpl<EventEventDao, EventEvent> implements EventEventService {

}
