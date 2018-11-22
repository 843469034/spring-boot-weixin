package com.weixin.repository;

import com.weixin.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Integer 主键名
 * Created by Administrator on 2018/11/21.
 */
public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Integer>{
    //List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    @Query(nativeQuery = true,value ="SELECT * from product_category where  category_type IN ?1 ")
    List<ProductCategory> findByCategory_typeIn( List<Integer> categoryTypeList);

  //  List<ProductCategory> findByCategoryType(Integer categoryType);
}
