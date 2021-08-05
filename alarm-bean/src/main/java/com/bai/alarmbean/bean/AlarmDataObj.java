package com.bai.alarmbean.bean;

import lombok.Data;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 23:23
 * 告警数据对象
 */
@Data
public class AlarmDataObj {
    /**
     * 告警数据名称
     */
    private String alarmName;
    /**
     * 端口号
     */
    private Integer port;
    /**
     * 服务器地址
     */
    private String address;
    /**
     * 告警原文
     */
    private String alarmTxt;
    /**
     * 发送次数
     */
    private Integer count;
    /**
     * 字符集
     */
    private String charset;

}
