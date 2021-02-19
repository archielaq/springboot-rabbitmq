package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * 案件表(EventEvent)表实体类
 *
 * @author archie Lin
 * @since 2021-02-18 16:40:48
 */
@Data
public class EventEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    //主键
    private String id;
    //任务号
    private String taskcode;
    //状态
    private String state;

    private String placecode;
    //问题来源
    private String source;
    //问题类型：投诉、咨询、建议
    private String wttype;
    //事件等级 1：一级  2：二级  3：三级
    private String grade;
    //一级类
    private String type1Id;

    private String type1Name;
    //二级类
    private String type2Id;

    private String type2Name;
    //三级类
    private String type3Id;

    private String type3Name;
    //市级
    private String citycode;
    //区县
    private String towncode;
    //街道
    private String streetId;
    //社区
    private String countryId;
    //单元网格
    private String gridId;
    //举报人呼叫号码
    private String reporterCallphone;
    //采集员
    private String patrolerId;
    //举报人
    private String reporterId;
    //受理人
    private String operatorId;
    //发生位置
    private String address;
    //gpsx坐标
    private String pointx;
    //gpsy坐标
    private String pointy;
    //问题描述
    private String eventdesc;
    //建立时间
    private Long createtime;
    //建议案卷，上报自结案：1，其他null
    private String simple;
    //当前处置人ID
    private String currentId;
    //当前处置部门ID
    private String currentdeptId;
    //对方对接系统标识
    private String sign;
    //最后处置结果
    private String dealresult;
    //处置时间
    private Long dealtime;
    //对方系统事件ID
    private String pretaskcode;
    //最后处置期限
    private Long deadtime;
    //谁锁定了当前事件
    private String lockevent;
    //是否有人处理
    private String ifdeal;
    //是否拨打电话0是否，1
    private String ifcontact;
}
