package com.weixin.vo;

import lombok.Data;

/**
 * Created by Administrator on 2018/11/23.
 */
@Data
public class ResultVO<T>{
            private  Integer code;
            private  String msg;

            private  T data;

}
