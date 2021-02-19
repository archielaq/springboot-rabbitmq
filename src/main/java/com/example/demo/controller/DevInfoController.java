package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.DevInfo;
import com.example.demo.mq.SimpleSender;
import com.example.demo.mq.WorkSender;
import com.example.demo.service.DevInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 执法仪相关数据(DevInfo)表控制层
 *
 * @author archie Lin
 * @since 2021-02-18 16:32:19
 */
@RestController
@RequestMapping("devInfo")
public class DevInfoController extends ApiController {
    @Autowired
    private SimpleSender simpleSender;

    @Autowired
    private WorkSender workSender;
    /**
     * 服务对象
     */
    @Resource
    private DevInfoService devInfoService;

    /**
     * 分页查询所有数据
     *
     * @param page    分页对象
     * @param devInfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<DevInfo> page, DevInfo devInfo) {
        return success(this.devInfoService.page(page, new QueryWrapper<>(devInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.devInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param devInfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody DevInfo devInfo) {
        return success(this.devInfoService.save(devInfo));
    }

    /**
     * 修改数据
     *
     * @param devInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody DevInfo devInfo) {
        return success(this.devInfoService.updateById(devInfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.devInfoService.removeByIds(idList));
    }


    /**
     * simple
     */
    @GetMapping("/simple")
    public R simple() {
        for (int i = 0; i < 10; i++) {
            workSender.send(i);
        }
        return success("");
    }
}
