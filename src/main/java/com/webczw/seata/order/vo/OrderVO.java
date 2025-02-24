package com.webczw.seata.order.vo;

import lombok.Data;

@Data
public class OrderVO {
    private Long orderId;
    private String orderCode;
    private String orderName;
    private Integer orderQty;
    private Long productId;
    private Long createdBy;
    private String creationDate;
    private Long lastUpdatedBy;
    private String lastUpdateDate;
}
