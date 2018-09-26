package com.tool.PvAndUv.DataStructure;

import com.tool.PvAndUv.Entity.Client;
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

    private static CopyOnWriteArrayList<Client> clientList = new CopyOnWriteArrayList<Client>();

    public synchronized static void addClient(Client client){
        clientList.add(client);
    }

    public static CopyOnWriteArrayList<Client> getClientList(){
        return clientList;
    }

}
