package com.bai.alarmsocket.service;

import com.bai.alarmcommons.CommonResult;

public interface SocketSendService {

    /**
     * 发送到本地socket服务
     * @param port
     * @return
     */
    CommonResult alarmSend(Integer port,String alarmTxt,String charset);

    /**
     * 发送远程socket服务
     * @param address
     * @param port
     * @param alarmTxt
     * @return
     */
    CommonResult alarmSend(String address,Integer port,String alarmTxt,String charset);

    /**
     * 发送本地socket服务可选次数
     * @param port 端口号
     * @param count 发送次数
     * @param alarmTxt 告警原文
     * @return
     */
    CommonResult alarmSend(Integer port,Integer count,String alarmTxt,String charset);

    /**
     * 发送远程socket服务可选次数
     * @param address
     * @param port
     * @param count 发送次数
     * @param alarmTxt
     * @return
     */
    CommonResult alarmSend(String address,Integer port,Integer count,String alarmTxt,String charset);

}
