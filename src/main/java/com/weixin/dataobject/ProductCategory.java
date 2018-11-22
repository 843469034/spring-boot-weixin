package com.weixin.dataobject;

/**
 * Created by Administrator on 2018/11/21.
 */

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import  java.util.Date;
/**
 *
 */
@Component
@Entity
@Table(name = "product_category")
@DynamicUpdate
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
   // @GeneratedValue(strategy = GenerationTypeType.INDENTY)

    private  String categoryName;

    private  Integer category_type;

    private  Date createTime;


    private  Date updateTime;

     public ProductCategory() {
    }
/*


    public Integer getCategory_type() {
        return category_type;
    }

    public void setCategory_type(Integer category_type) {
        this.category_type = category_type;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }*/
}
