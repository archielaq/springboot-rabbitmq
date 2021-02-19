package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.DevInfoDao;
import com.example.demo.entity.DevInfo;
import com.example.demo.service.DevInfoService;
import org.springframework.stereotype.Service;

/**
 * 执法仪相关数据(DevInfo)表服务实现类
 *
 * @author archie Lin
 * @since 2021-02-18 16:32:19
 */
@Service
public class DevInfoServiceImpl extends ServiceImpl<DevInfoDao, DevInfo> implements DevInfoService {

}
