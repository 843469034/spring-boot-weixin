package com.weixin.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Created by Administrator on 2018/11/26.
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结"),
    CANCEL(2,"取消");
    private  Integer code;
    private  String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
