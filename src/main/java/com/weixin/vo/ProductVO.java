package com.weixin.vo;

import lombok.Data;

/**
 * Created by Administrator on 2018/11/23.
 */
@Data
public class ProductVO<T> {
    private  String name;
    private  Integer type;
    private  T foods;
}
