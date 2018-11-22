package com.weixin.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/22.
 */
@Table(name="product_info")
@Data
@DynamicUpdate
@Entity
public class ProductInfo {
        @Id
        private String productId;

        private  String  productName;

        private BigDecimal productPrice;

        private  Integer productStock;

        private  String productDescription;

        private  String  productIcon;

        private  Integer productStatus;

        private  Integer categoryType;

        private  Date createTime;

        private Date  updateTime;

    public ProductInfo() {
    }
}
