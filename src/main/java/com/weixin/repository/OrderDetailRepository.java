package com.weixin.repository;

import com.weixin.dataobject.OrderDatail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/11/26.
 */
public interface OrderDetailRepository extends JpaRepository<OrderDatail,String> {

    List<OrderDatail>  findByOrderId(String orderId);
}
