package com.weixin.dataobject;

import com.weixin.enums.OrderStatusEnum;
import com.weixin.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/26.
 */
@Entity
@Data
@DynamicUpdate
@Table(name = "order_master")
public class OrderMaster {
    @Id
    private  String orderId;

    private  String buyerName;

    private  String buyerPhone;

    private  String buyerAddress;

    private  String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    private  Integer payStatus = PayStatusEnum.WAIT.getCode();

    private  Date createTime;

    private Date updateTime;

    public OrderMaster() {
    }
}
