package com.weixin.service.impl;

import com.weixin.dataobject.OrderDatail;
import com.weixin.dataobject.OrderMaster;
import com.weixin.dataobject.ProductInfo;
import com.weixin.dto.CartDTO;
import com.weixin.dto.OrderDTO;
import com.weixin.enums.OrderStatusEnum;
import com.weixin.enums.PayStatusEnum;
import com.weixin.enums.ResultEnum;
import com.weixin.exption.sellException;
import com.weixin.repository.OrderDetailRepository;
import com.weixin.repository.OrderMasterRepository;
import com.weixin.repository.ProductInfoRepository;
import com.weixin.service.OrderService;
import com.weixin.service.ProductService;
import com.weixin.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2018/11/27.
 */
@Service
public class OrderServicelmpl implements OrderService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductService productService;

    @Override
    @org.springframework.transaction.annotation.Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String order_id = KeyUtil.genUniqueKey();
        BigDecimal orderAmount = new BigDecimal(0);
        //查询商品是否存在，数量交给扣时候判断，价格
            for(OrderDatail orderDatail :orderDTO.getOrderDatailList()){
                ProductInfo productInfo = productInfoRepository.findByProductId(orderDatail.getProductId());
                    if(productInfo == null){
                        throw  new sellException(ResultEnum.PODUCT_NOT_EXIST);
                    }
                //计算订单价格
                orderAmount= productInfo.getProductPrice().multiply(new BigDecimal(orderDatail.getProductQuantity())).add(orderAmount);
                //订单入orderdetail
                orderDatail.setDetailId(KeyUtil.genUniqueKey());
                orderDatail.setOrderId(order_id);
                BeanUtils.copyProperties(productInfo,orderDatail);

                 orderDetailRepository.save(orderDatail);
            }
        //写入订单数据库OrderMaster
        OrderMaster orderMaster = new OrderMaster();

        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderId(order_id);
        orderMasterRepository.save(orderMaster);

        //扣库存
       List<CartDTO> cartDTOList = orderDTO.getOrderDatailList().stream().map(e-> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDTO;

    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
