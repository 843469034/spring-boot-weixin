package com.weixin.service;

import com.weixin.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/11/23.
 */
public interface ProductService {
    Optional<ProductInfo> findOne(String productId);

    List<ProductInfo> findUpall();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存



    //减库存
}
