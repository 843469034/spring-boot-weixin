package com.weixin.controller;

import com.weixin.dataobject.ProductCategory;
import com.weixin.dataobject.ProductInfo;
import com.weixin.service.CategoryService;
import com.weixin.service.ProductService;
import com.weixin.util.ResultVOUtil;
import com.weixin.vo.ProductInfoVO;
import com.weixin.vo.ProductVO;
import com.weixin.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/11/23.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController  {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVO testResult(){
        //获取上线的商品
       List<ProductInfo> productInfoList = productService.findUpall();
       //获取上线商品的type list
       List<Integer> lists = productInfoList.stream().map(e-> e.getCategoryType()).collect(Collectors.toList());
        //根据上线商品type  获取上线商品类目编号
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(lists);
        List<ProductVO> list = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
          productVO.setCategoryName(productCategory.getCategoryName());
          productVO.setCategoryType(productCategory.getCategory_type());

          List<ProductInfoVO>  list11 = new ArrayList<>();
           for (ProductInfo productInfo : productInfoList){
                    if(productCategory.getCategory_type().equals(productInfo.getCategoryType())){
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo,productInfoVO);
                        list11.add(productInfoVO);
                    }
           }
            productVO.setFoods(list11);
            list.add(productVO);
        }

        ResultVO  resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        resultVO.setData(list);
        return resultVO;


    }


    @GetMapping("list1")
    public  ResultVO test1(){
    /*    ResultVO  resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");*/

        //获取上架的商品
        List<ProductInfo> productInfoList = productService.findUpall();

        //获取上架商品的type
         List<Integer> list_type =  productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());

         //根据上架商品type获取类目录表的type名字

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(list_type);
        List<ProductVO> lists = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategory_type());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> list = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                ProductInfoVO  productInfoVO = new ProductInfoVO();
                if(productInfo.getCategoryType().equals(productCategory.getCategory_type())){
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    list.add(productInfoVO);
                }

            }
           productVO.setFoods(list);
            lists.add(productVO);

        }

       // resultVO.setData(lists);

        return ResultVOUtil.success(lists);



    }





}
