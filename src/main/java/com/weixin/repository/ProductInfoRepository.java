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

    @Query(nativeQuery = true,value = "select  * from product_info where product_id = ?1 ")
     ProductInfo  findByProductId(String productId);

    List<ProductInfo>  findAllByProductName(List<String> productName);

    @Query(nativeQuery = true,value = "update product_info set product_stock = ?1 where product_id = ?2 ")
    void  updateProductStook(String product_id,Integer stook);
}
