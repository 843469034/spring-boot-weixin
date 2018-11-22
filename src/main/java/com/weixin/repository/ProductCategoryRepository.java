package com.weixin.repository;

import com.weixin.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Integer 主键名
 * Created by Administrator on 2018/11/21.
 */
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer>{
    //List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
   // List<ProductCategory> findByCategory_typeIn(List<Integer> categoryTypeList);

  //  List<ProductCategory> findByCategoryType(Integer categoryType);
}
