package com.weixin.dto;

import com.weixin.dataobject.OrderDatail;
import com.weixin.enums.OrderStatusEnum;
import com.weixin.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/11/27
 *
 */
@Data
public class OrderDTO {

    private  String orderId;

    private  String buyerName;

    private  String buyerPhone;

    private  String buyerAddress;

    private  String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus  ;

    private  Integer payStatus ;

    private Date createTime;

    private Date updateTime;

    private List<OrderDatail> orderDatailList;
}
