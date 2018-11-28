package com.weixin.exption;

import com.weixin.enums.ResultEnum;

/**
 * Created by Administrator on 2018/11/28.
 */
public class sellException extends  RuntimeException {
    private  Integer code;

    public sellException(ResultEnum resultEnum) {

        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }
}
