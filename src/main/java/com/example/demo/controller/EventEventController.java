package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.EventEvent;
import com.example.demo.service.EventEventService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 案件表(EventEvent)表控制层
 *
 * @author archie Lin
 * @since 2021-02-18 16:40:48
 */
@RestController
@RequestMapping("eventEvent")
public class EventEventController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private EventEventService eventEventService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param eventEvent 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<EventEvent> page, EventEvent eventEvent) {
        return success(this.eventEventService.page(page, new QueryWrapper<>(eventEvent)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.eventEventService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param eventEvent 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody EventEvent eventEvent) {
        return success(this.eventEventService.save(eventEvent));
    }

    /**
     * 修改数据
     *
     * @param eventEvent 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody EventEvent eventEvent) {
        return success(this.eventEventService.updateById(eventEvent));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.eventEventService.removeByIds(idList));
    }
}
