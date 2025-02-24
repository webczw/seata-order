package com.webczw.seata.order.vo;

import lombok.Data;

@Data
public class DeductionVO {
    private Integer orderQyt;
    private Long productId;
    private Long lastUpdatedBy;
}
