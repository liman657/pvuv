package com.tool.PvAndUv.service.impl;

import com.tool.PvAndUv.DataStructure.VisitorsData;
import com.tool.PvAndUv.Entity.Client;
import com.tool.PvAndUv.repo.ClientRepository;
import com.tool.PvAndUv.service.SaveClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 */
@Service("SaveClientService")
public class SaveClientServiceImpl implements SaveClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Scheduled(fixedRate = 60000)
    public void saveClient() {
        CopyOnWriteArrayList<Client> clientList = VisitorsData.getClientList();
        for(Client client:clientList){
            clientRepository.save(client);
        }
    }
}
