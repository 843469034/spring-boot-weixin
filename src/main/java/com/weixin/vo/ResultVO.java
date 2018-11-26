package com.weixin.vo;

import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/23.
 */
@Data
public class ResultVO<T>{
            private  Integer code;
            private  String msg;

            private List<T> data;

}
