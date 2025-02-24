package com.webczw.seata.order.util;

import com.webczw.seata.order.vo.ResultVO;

public class ResultUtils {
    private static final int SUCCESS = 200;
    private static final int ERROR = 500;

    public static <T> ResultVO<T> success() {
        return new ResultVO<>(SUCCESS);
    }

    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(SUCCESS, data);
    }

    public static <T> ResultVO<T> error() {
        return new ResultVO<>(ERROR);
    }

    public static <T> ResultVO<T> error(String msg) {
        return new ResultVO<>(ERROR, msg);
    }
}
