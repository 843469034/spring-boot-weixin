package com.weixin.service.impl;

import com.weixin.dataobject.ProductCategory;
import com.weixin.repository.ProductCategoryRepository;
import com.weixin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

/**
 * Created by Administrator on 2018/11/22.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
   /* @Autowired
    private  ProductCategory productCategory;*/
    @Override
    public Optional<ProductCategory> findOne(Integer categoryId) {
      return    productCategoryRepository.findById(categoryId);
     /* productCategory.setCategoryId(categoryId);
        Example<ProductCategory> userExample = Example.of(productCategory);
        return productCategoryRepository.findOne(userExample);*/
   // return  null;
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategory_typeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
