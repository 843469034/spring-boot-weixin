package com.weixin.service.impl;

import com.weixin.dataobject.ProductInfo;
import com.weixin.dto.CartDTO;
import com.weixin.enums.ProductStatusEnum;
import com.weixin.enums.ResultEnum;
import com.weixin.exption.sellException;
import com.weixin.repository.ProductInfoRepository;
import com.weixin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Administrator on 2018/11/23.
 */
@Service
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

    @Override
    public void increaseStock(List<CartDTO> listCartDto) {

    }

    @Override
    @org.springframework.transaction.annotation.Transactional
    public void decreaseStock(List<CartDTO> listCartDto) {
        for(CartDTO cartDTO :listCartDto){
            ProductInfo productInfo = productInfoRepository.findByProductId(cartDTO.getProductId());
            if(productInfo == null){
                throw  new sellException(ResultEnum.PODUCT_NOT_EXIST);
            }
            Integer yue = productInfo.getProductStock() - cartDTO.getProduct_quantity();
            if(yue<0){
                throw new sellException(ResultEnum.PODUCT_NOT_ENOU);
            }
           // productInfoRepository.updateProductStook(cartDTO.getProductId(),cartDTO.getProduct_quantity());
            productInfo.setProductStock(yue);
            productInfoRepository.save(productInfo);
        }
    }
}
