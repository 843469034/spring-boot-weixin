package com.weixin.enums;

import lombok.Getter;

/**
 * Created by Administrator on 2018/11/26.
 */
@Getter
public enum PayStatusEnum {
        WAIT(0,"等待支付"),SUCCESS(1,"支付成功");


    private  Integer code;
    private  String meg;

    PayStatusEnum(Integer code, String meg) {
        this.code = code;
        this.meg = meg;
    }
}
