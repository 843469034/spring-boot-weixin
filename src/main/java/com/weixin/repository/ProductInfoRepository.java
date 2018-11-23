package com.weixin.repository;

import com.weixin.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2018/11/22.
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    @Query(nativeQuery = true,value = "select  * from product_info where product_status = ?1 ")
    List<ProductInfo>  findByProductStatus(Integer productStatus);


    List<ProductInfo>  findAllByProductName(List<String> productName);
}
