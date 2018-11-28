package com.weixin.repository;

import com.weixin.dataobject.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.spi.StoredProcedureQueryParameterRegistration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderMasterRepositoryTest  {

    private  final    String openId="1111";
    @Autowired
    private  OrderMasterRepository orderMasterRepository;

    @Test
    public  void  testByopenId(){
        PageRequest pageRequest = new PageRequest(1,2);
        Page<OrderMaster> pages =  orderMasterRepository.findByBuyerOpenid(openId,pageRequest);
        log.info("byopenId_page:{}",pages.getTotalElements());

    }
}