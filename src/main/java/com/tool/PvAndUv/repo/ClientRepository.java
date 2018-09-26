package com.tool.PvAndUv.repo;

import com.tool.PvAndUv.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:liman
 * createtime:2018/9/26
 * mobile:15528212893
 * email:657271181@qq.com
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

//    public void save(List<Client> clients);

}
