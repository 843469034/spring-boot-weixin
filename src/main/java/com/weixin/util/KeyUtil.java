package com.weixin.util;

import java.util.Random;

/**
 * Created by Administrator on 2018/11/28.
 */
public class KeyUtil {
    public  static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(90000)+10000;

        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
