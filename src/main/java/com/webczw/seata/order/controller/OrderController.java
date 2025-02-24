package com.webczw.seata.order.controller;

import com.webczw.seata.order.service.IOrderService;
import com.webczw.seata.order.vo.OrderVO;
import com.webczw.seata.order.vo.ProductTypeQueryVO;
import com.webczw.seata.order.vo.ProductTypeVO;
import com.webczw.seata.order.vo.ResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private IOrderService orderService;

    @PostMapping("/getInfo")
    public ResultVO<ProductTypeVO> getProductType(@RequestBody ProductTypeQueryVO queryVO) {
        return orderService.getProductType(queryVO);
    }

    @PostMapping("/addOrder")
    public ResultVO<Integer> addOrder(@RequestBody OrderVO order) {
        return orderService.addOrder(order);
    }
}
