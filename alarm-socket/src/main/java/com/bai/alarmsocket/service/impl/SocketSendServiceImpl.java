package com.bai.alarmsocket.service.impl;

import com.bai.alarmcommons.CommonResult;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import com.bai.alarmsocket.service.SocketSendService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 18:10
 */
@Service
public class SocketSendServiceImpl implements SocketSendService {



    @Override
    public CommonResult alarmSend(Integer port, String alarmTxt,String charset) {
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            socket = new Socket("localhost", port);
            outputStream = socket.getOutputStream();
            StopWatch sw = new StopWatch();
            sw.start();
            System.out.println(Thread.currentThread().getName()+"-开始写入.................");
            outputStream.write(alarmTxt.getBytes(charset));
            outputStream.flush();
            outputStream.close();
            System.out.println(Thread.currentThread().getName()+"写入完成.................");
            sw.stop();
            return new CommonResult(200,"发送成功，发送耗时："+sw.getTotalTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(400,"发送失败");
        }finally {
            try {
                if (null != outputStream)
                    outputStream.close();
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CommonResult alarmSend(String address, Integer port, String alarmTxt,String charset) {
        OutputStream outputStream = null;
        Socket socket = null;
        try {
            socket = new Socket(address, port);
            outputStream = socket.getOutputStream();
            StopWatch sw = new StopWatch();
            sw.start();
            System.out.println(Thread.currentThread().getName()+"-开始写入.................");
            outputStream.write(alarmTxt.getBytes(charset));
            outputStream.flush();
            outputStream.close();
            System.out.println(Thread.currentThread().getName()+"写入完成.................");
            sw.stop();
            return new CommonResult(200,"发送成功，发送耗时："+sw.getTotalTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(400,"发送失败");
        }finally {
            try {
                if (null != outputStream)
                    outputStream.close();
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CommonResult alarmSend(Integer port, Integer count, String alarmTxt,String charset) {
        OutputStream outputStream = null;
        Socket socket = null;
        int num = 1;
        try {
            StopWatch sw = new StopWatch();
            sw.start();
            do{
                socket = new Socket("localhost", port);
                outputStream = socket.getOutputStream();
                System.out.println(Thread.currentThread().getName()+"-开始写入.................");
                outputStream.write(alarmTxt.getBytes(charset));
                outputStream.flush();
                outputStream.close();
                System.out.println(Thread.currentThread().getName()+"写入完成.................");
                num++;
            }while (num>count);
            sw.stop();
            return new CommonResult(200,"发送成功，发送耗时："+sw.getTotalTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(400,"发送失败");
        }finally {
            try {
                if (null != outputStream)
                    outputStream.close();
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public CommonResult alarmSend(String address, Integer port, Integer count, String alarmTxt,String charset) {
        OutputStream outputStream = null;
        Socket socket = null;
        int num = 1;
        try {
            StopWatch sw = new StopWatch();
            sw.start();
            do{
                socket = new Socket(address, port);
                outputStream = socket.getOutputStream();
                System.out.println(Thread.currentThread().getName()+"-开始写入.................");
                outputStream.write(alarmTxt.getBytes(charset));
                outputStream.flush();
                outputStream.close();
                System.out.println(Thread.currentThread().getName()+"写入完成.................");
                num++;
            }while (num>count);
            sw.stop();
            return new CommonResult(200,"发送成功，发送耗时："+sw.getTotalTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
            return new CommonResult(400,"发送失败");
        }finally {
            try {
                if (null != outputStream)
                    outputStream.close();
                if (null != socket)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
