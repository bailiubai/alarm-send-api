package com.bai.alarmapi.controller.socket;

import com.bai.alarmbean.bean.AlarmDataObj;
import com.bai.alarmcommons.CommonResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.bai.alarmsocket.service.SocketSendService;

import javax.annotation.Resource;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 23:20
 */
@RestController
@RequestMapping(value = "/socket/client")
public class SocketClientController {

    @Resource
    private SocketSendService socketSendService;

    /**
     * 发送本地单次告警
     * @param alarmDataObj
     * @return
     */
    @PostMapping(value = "/sendLocal")
    public CommonResult sendLocal(@RequestBody AlarmDataObj alarmDataObj){
        if (null == alarmDataObj.getPort()){
            return new CommonResult(400,"端口号不可为空！");
        }
        if (StringUtils.isEmpty(alarmDataObj.getAlarmTxt())){
            return new CommonResult(400,"告警原文不可为空！");
        }
        return socketSendService.alarmSend(alarmDataObj.getPort(),alarmDataObj.getAlarmTxt(),alarmDataObj.getCharset());
    }

    /**
     * 发送本地告警，可选次数
     * @param alarmDataObj
     * @return
     */
    @PostMapping(value = "/sendLocalCount")
    public CommonResult sendLocalCount(@RequestBody AlarmDataObj alarmDataObj){
        if (null == alarmDataObj.getPort()){
            return new CommonResult(400,"端口号不可为空！");
        }
        if (StringUtils.isEmpty(alarmDataObj.getAlarmTxt())){
            return new CommonResult(400,"告警原文不可为空！");
        }
        if (null == alarmDataObj.getCount()){
            alarmDataObj.setCount(1);
        }
        return socketSendService.alarmSend(alarmDataObj.getPort(),alarmDataObj.getCount(),alarmDataObj.getAlarmTxt(),alarmDataObj.getCharset());
    }

    /**
     * 发送远程单次告警
     * @param alarmDataObj
     * @return
     */
    @PostMapping(value = "/sendRemote")
    public CommonResult sendRemote(@RequestBody AlarmDataObj alarmDataObj){
        if (null == alarmDataObj.getPort()){
            return new CommonResult(400,"端口号不可为空！");
        }
        if (StringUtils.isEmpty(alarmDataObj.getAlarmTxt())){
            return new CommonResult(400,"告警原文不可为空！");
        }
        if (StringUtils.isEmpty(alarmDataObj.getAddress())){
            return new CommonResult(400,"远程服务器地址不可胃口！");
        }
        return socketSendService.alarmSend(
                alarmDataObj.getAddress(),
                alarmDataObj.getPort(),
                alarmDataObj.getAlarmTxt(),
                alarmDataObj.getCharset()
        );
    }

    /**
     * 发送远程告警，可选次数
     * @param alarmDataObj
     * @return
     */
    @PostMapping(value = "/sendRemoteCount")
    public CommonResult sendRemoteCount(@RequestBody AlarmDataObj alarmDataObj){
        if (null == alarmDataObj.getPort()){
            return new CommonResult(400,"端口号不可为空！");
        }
        if (StringUtils.isEmpty(alarmDataObj.getAlarmTxt())){
            return new CommonResult(400,"告警原文不可为空！");
        }
        if (StringUtils.isEmpty(alarmDataObj.getAddress())){
            return new CommonResult(400,"远程服务器地址不可胃口！");
        }
        if (null == alarmDataObj.getCount()){
            alarmDataObj.setCount(1);
        }
        return socketSendService.alarmSend(
                alarmDataObj.getAddress(),
                alarmDataObj.getPort(),
                alarmDataObj.getCount(),
                alarmDataObj.getAlarmTxt(),
                alarmDataObj.getCharset()
        );
    }

}
