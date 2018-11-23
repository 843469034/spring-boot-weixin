package com.weixin.service.impl;

import com.weixin.dataobject.ProductInfo;
import com.weixin.enums.ProductStatusEnum;
import com.weixin.repository.ProductInfoRepository;
import com.weixin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/11/23.
 */
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public Optional<ProductInfo> findOne(String productId) {
        return productInfoRepository.findById(productId);
    }

    @Override
    public List<ProductInfo> findUpall() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
