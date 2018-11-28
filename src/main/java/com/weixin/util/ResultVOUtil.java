package com.weixin.util;

import com.weixin.vo.ResultVO;

import java.util.List;

/**
 * Created by Administrator on 2018/11/26.
 */
public class ResultVOUtil {

    public  static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        resultVO.setData((List) object);
        return  resultVO;

    }


    public  static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        return  success(null);

    }

    public  static  ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
