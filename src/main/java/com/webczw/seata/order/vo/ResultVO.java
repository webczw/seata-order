package com.webczw.seata.order.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultVO<T> {
    private int status;
    private String msg;
    private T data;
    private Long sysDate;

    public ResultVO(int status) {
        this.status = status;
    }

    public ResultVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResultVO(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public Long getSysDate() {
        return System.currentTimeMillis();
    }
}
