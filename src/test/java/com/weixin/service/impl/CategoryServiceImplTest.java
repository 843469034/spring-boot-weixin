package com.weixin.service.impl;

import com.weixin.dataobject.ProductCategory;
import com.weixin.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2018/11/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {
    @Autowired
    private CategoryService categoryService;

        @Test
    public void testImplFindOne(){
            Optional<ProductCategory>  optional= categoryService.findOne(2);
            log.info("result:{}",optional.toString());
    }
}