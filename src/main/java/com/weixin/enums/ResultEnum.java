package com.weixin.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2018/11/28.
 */
@Getter
public enum ResultEnum {
        PODUCT_NOT_EXIST(10,"商品不存在"),
        PODUCT_NOT_ENOU(11,"商品库存不够")

    ;

     private  Integer code;
     private  String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
