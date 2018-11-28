package com.weixin.service;

import com.weixin.dto.OrderDTO;
import org.springframework.data.domain.Page;

import java.awt.*;
import java.awt.print.Pageable;

/**
 * Created by Administrator on 2018/11/27.
 */
public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

    OrderDTO findOne(String orderId);

     Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    OrderDTO cancel(OrderDTO orderDTO);

    OrderDTO finish(OrderDTO orderDTO);

    OrderDTO paid(OrderDTO orderDTO);

}
