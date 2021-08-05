package com.bai.alarmsocket.threads;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:liuBai
 * @Time : 2021/8/4 18:04
 */
public class ServerThreadStart implements Runnable {

    private ApplicationContext context;
    private ServerSocket serverSocket;
    private Socket socket;

    public ServerThreadStart(ServerSocket serverSocket,ApplicationContext context){
        this.serverSocket = serverSocket;
        this.context = context;
    }


    @Override
    public void run() {
        //监听客户端
        try {
            while (true){
                socket = serverSocket.accept();
                ServerThreadHandler serverThreadHandler = new ServerThreadHandler(socket,context);
                new Thread(serverThreadHandler).start();
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端的IP："+inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
