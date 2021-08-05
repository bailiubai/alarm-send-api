package com.bai.alarmapi.controller.socket;

import com.bai.alarmcommons.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bai.alarmsocket.service.SocketServerService;

import javax.annotation.Resource;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 23:15
 *
 * win 10  查看端口占用情况命令
 * netstat -ano | findstr "10086"  查看某个端口
 * netstat -ano 查看全部端口
 */
@RestController
@RequestMapping(value = "/socket/server")
public class SocketServerController {

    @Resource
    private SocketServerService socketServerService;

    @GetMapping(value = "/start/{port}")
    public CommonResult startServer(@PathVariable("port") Integer port){
        if (null == port){
            return new CommonResult(400,"端口号不可为空！");
        }
        return socketServerService.startServer(port);
    }

    @GetMapping(value = "/stop")
    public CommonResult stopServer(){
        return socketServerService.stopServer();
    }

    @GetMapping(value = "/status")
    public CommonResult getServerStatus(){
        return socketServerService.getStatus();
    }



}
