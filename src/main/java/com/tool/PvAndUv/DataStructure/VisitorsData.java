package com.tool.PvAndUv.DataStructure;

import com.tool.PvAndUv.Entity.Client;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 * comment:
 *      记录客户端的数据
 */
public class VisitorsData {

    /**
     * 采用队列，每保存一个client对象就是出队列
     */
    private static ConcurrentLinkedQueue<Client> clientQueue = new ConcurrentLinkedQueue<Client>();

    public synchronized static void addClient(Client client){
        clientQueue.offer(client);
    }

    public static ConcurrentLinkedQueue<Client> getClientList(){
        return clientQueue;
    }

}
