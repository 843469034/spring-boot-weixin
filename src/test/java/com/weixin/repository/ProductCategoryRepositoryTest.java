package com.weixin.repository;

import com.weixin.dataobject.ProductCategory;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProductCategoryRepositoryTest {
        @Autowired
        private  ProductCategoryRepository productCategoryRepository;

        @Test
        public  void findObject(){
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(1);
            System.out.println(productCategory.toString());
         }
         @Test
          public  void saveObject(){
            ProductCategory productCategory = new ProductCategory();
            productCategory.setCategory_type(2);
            productCategory.setCategoryName("哈哈");
             productCategoryRepository.save(productCategory);
          }
          @Test
          @Transactional
          public  void updataObject(){
              Optional<ProductCategory> productCategory = productCategoryRepository.findById(2);
              productCategory.get().setCategoryName("doubi");
              productCategory.get().setCategory_type(4);

             ProductCategory productCategory1= productCategoryRepository.save(productCategory.get());
             log.info("result:{}",productCategory1.toString());
           /*   ProductCategory productCategory = new ProductCategory();
              productCategory.setCategoryId(2);
              productCategory.setCategory_type(3);
              productCategory.setCategoryName("哈哈-----");
              productCategoryRepository.save(productCategory);*/
          }
      @Test
        public void testImplselect(){
            List<Integer> i = Arrays.asList(0,1,2);
            // List<ProductCategory>  productCategories=productCategoryRepository.findByCategory_typeIn(i);
            List<ProductCategory>  productCategories1  = productCategoryRepository.findByCategory_typeIn(i);
           log.info("result:{}",productCategories1.toString());

        }
}