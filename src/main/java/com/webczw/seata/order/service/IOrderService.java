package com.webczw.seata.order.service;

import com.webczw.seata.order.vo.OrderVO;
import com.webczw.seata.order.vo.ProductTypeQueryVO;
import com.webczw.seata.order.vo.ProductTypeVO;
import com.webczw.seata.order.vo.ResultVO;

public interface IOrderService
{
    ResultVO<ProductTypeVO> getProductType(ProductTypeQueryVO queryVO);

    ResultVO<Integer> addOrder(OrderVO order);
}
