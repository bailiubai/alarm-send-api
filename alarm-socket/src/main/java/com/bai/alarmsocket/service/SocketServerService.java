package com.bai.alarmsocket.service;

import com.bai.alarmcommons.CommonResult;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 17:26
 */
public interface SocketServerService {

    /**
     * 开启本地socket服务器
     * @param port
     * @return
     */
    CommonResult startServer(Integer port);

    /**
     * 关闭本地socket服务器
     * @return
     */
    CommonResult stopServer();

    /**
     * 检测本地socket服务器状态
     * @return
     */
    CommonResult getStatus();

}
