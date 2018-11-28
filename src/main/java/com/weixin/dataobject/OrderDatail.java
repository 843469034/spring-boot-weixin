package com.weixin.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/26.
 */
@Data
@Entity
@DynamicUpdate
@Table(name="order_detail")
public class OrderDatail {
     @Id
    private  String detailId;

    private  String orderId;

    private  String productId;


    private  String productName;

    private BigDecimal productPrice;

    private  Integer productQuantity;

    private  String productIcon;

    private  Date createTime;

    private Date updateTime;

    public OrderDatail() {
    }
}
