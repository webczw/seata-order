package com.webczw.seata.order.service.impl;

import com.webczw.seata.order.common.SnowflakeIdGenerator;
import com.webczw.seata.order.dao.IOrderDao;
import com.webczw.seata.order.service.IOrderService;
import com.webczw.seata.order.util.ResultUtils;
import com.webczw.seata.order.vo.*;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderService implements IOrderService {
    Logger LOG = LoggerFactory.getLogger(OrderService.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private IOrderDao orderDao;

    @Override
    public ResultVO<ProductTypeVO> getProductType(ProductTypeQueryVO queryVO) {
        ResultVO<ProductTypeVO> resultVO = restTemplate.postForObject("http://seata-product/sp/productType/getInfo", queryVO, ResultVO.class);
        assert resultVO != null;
        LOG.info("status={}", resultVO.getStatus());
        return resultVO;
    }

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public ResultVO<Integer> addOrder(OrderVO order) {
        LOG.info("Account Service ... xid: {}" , RootContext.getXID());
        DeductionVO deductionVO = new DeductionVO();
        deductionVO.setOrderQyt(order.getOrderQty());
        deductionVO.setProductId(order.getProductId());
        deductionVO.setLastUpdatedBy(order.getLastUpdatedBy());
        ResultVO<Integer> resultVO = restTemplate.postForObject("http://seata-product/sp/productType/deduction", deductionVO, ResultVO.class);
        assert resultVO != null;
        Integer updateCount = resultVO.getData();
        LOG.info("data={}", updateCount);

        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1,1);
        order.setOrderId(idGenerator.nextId());
        Integer addCount = orderDao.addOrder(order);
        Integer sum = addCount + updateCount;
        int a = 1/0;
        return ResultUtils.success(sum);
    }
}
