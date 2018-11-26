package com.weixin.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by Administrator on 2018/11/23.
 */
@Data
public class ProductVO<T> {
    @JsonProperty("name")
    private  String categoryName;

    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<T> foods;
}
