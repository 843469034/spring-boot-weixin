package com.weixin.dto;

import lombok.Data;

/**
 * Created by Administrator on 2018/11/28.
 */
@Data
public class CartDTO {
    private String productId;
    private  Integer product_quantity;

    public CartDTO(String productId, Integer product_quantity) {
        this.productId = productId;
        this.product_quantity = product_quantity;
    }
}
