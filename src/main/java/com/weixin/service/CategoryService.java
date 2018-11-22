package com.weixin.service;

import com.weixin.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

//<editor-fold desc="Description">
/**
 * Created by Administrator on 2018/11/22.
 */
public interface CategoryService {

    Optional<ProductCategory> findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
//</editor-fold>
