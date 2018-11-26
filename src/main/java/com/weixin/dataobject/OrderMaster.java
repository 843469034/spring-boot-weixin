package com.weixin.dataobject;

import com.weixin.enums.OrderStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/26.
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private  String orderId;

    private  String buyerName;

    private  String buyerPhone;

    private  String buyerAddress;

    private  String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private  Integer payStatus;

    private  Date createTime;

    private Date updateTime;
}
