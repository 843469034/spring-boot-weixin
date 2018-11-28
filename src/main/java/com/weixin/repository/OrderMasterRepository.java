package com.weixin.repository;

import com.weixin.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2018/11/26.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String > {

    Page<OrderMaster>  findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
