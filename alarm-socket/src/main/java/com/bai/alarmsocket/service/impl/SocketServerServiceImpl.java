package com.bai.alarmsocket.service.impl;

import com.bai.alarmcommons.CommonResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import com.bai.alarmsocket.service.SocketServerService;
import com.bai.alarmsocket.threads.ServerThreadStart;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 17:26
 */
@Service
@Log4j2
public class SocketServerServiceImpl implements SocketServerService, ApplicationContextAware {

    private ServerSocket serverSocket;

    private ApplicationContext applicationContext;


    /**
     * 开启本地socket服务器
     * @param port
     * @return
     */
    public CommonResult startServer(Integer port){
        serverSocket = null;
        try {
            //创建服务端socket
            serverSocket = new ServerSocket(port);
            new Thread(new ServerThreadStart(serverSocket,applicationContext)).start();
            log.info("socket服务器启动成功.........");
            //创建客户端socket
            //循环监听等待客户端的连接
            return new CommonResult(200,"socket服务启动成功！");
        } catch (IOException e) {
            log.warn("socket服务器启动失败.........");
            e.printStackTrace();
            return new CommonResult(200,"socket服务启动失败！");
        }
    }

    @Override
    public CommonResult stopServer() {
        try {
            if (null != serverSocket){
                serverSocket.close();
            }
            return new CommonResult(200,"服务已关闭！");
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(400,"服务关闭失败！");
        }
    }

    /**
     * 检测本地socket服务器状态
     * @return
     */
    public CommonResult getStatus(){
        if (null == serverSocket){
            return new CommonResult(400,"未开启");
        }
        boolean closed = serverSocket.isClosed();
        if (closed){
            return new CommonResult(400,"已关闭",closed);
        }else{
            return new CommonResult(200,"正常开启",closed);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
