package com.bai.alarmsocket.threads;

import com.bai.alarmsocket.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import java.io.*;
import java.net.Socket;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 17:48
 */
public class ServerThreadHandler implements Runnable{

    //@Resource
    //@Autowired
    //private KafkaProducer kafkaProducer;

    private Socket socket;

    private ApplicationContext context;

    @Value("${alarm.log.path}")
    private String logPath;

    public ServerThreadHandler(Socket socket,ApplicationContext context){
        this.socket = socket;
        this.context = context;
    }


    @Override
    public void run(){
        KafkaProducer kafkaProducer = context.getBean(KafkaProducer.class);
        InputStream inputStream = null;
        try {
            if (StringUtils.isEmpty(logPath)){
                logPath = "E:\\logs\\alarm.log";
            }
            System.setOut(new PrintStream(new BufferedOutputStream(
                    new FileOutputStream(logPath)),true));
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (inputStream.read(bytes)!=-1){
                System.out.println(new String(bytes,"UTF-8"));
                kafkaProducer.send(new String(bytes,"UTF-8"));
            }
            socket.shutdownInput();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(socket.getInetAddress()+"断开连接....");
        }finally {
            /*try {
                if (null!=inputStream)
                    inputStream.close();
                if(socket!=null)
                    socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }*/
        }
    }

}
