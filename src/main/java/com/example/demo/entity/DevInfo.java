package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 执法仪相关数据(DevInfo)表实体类
 *
 * @author archie Lin
 * @since 2021-02-18 16:32:18
 */
@Data
public class DevInfo {
    //设备id
    private String id;
    //设备编号
    private String serialnumber;
    //设备名称
    private String nickname;
    //角色
    private String portrait;
    //部门ID
    private String departmentid;
    //终端类型：1 一期  2 二期  5 三期
    private String terminaltype;
    //经度
    private String lon;
    //纬度
    private String lat;
}
