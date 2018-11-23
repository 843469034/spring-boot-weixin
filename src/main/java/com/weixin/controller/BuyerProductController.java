package com.weixin.controller;

import com.weixin.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/11/23.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController  {

    @GetMapping("/list")
    public ResultVO testResult(){
        ResultVO  resultVO = new ResultVO();
        return resultVO;

    }

}
