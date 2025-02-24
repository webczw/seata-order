package com.webczw.seata.order.dao;

import com.webczw.seata.order.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IOrderDao {
    Integer addOrder(OrderVO order);
}
