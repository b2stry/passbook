package com.shallowan.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应对象
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO {

    /**
     * 错误码。正确返回 0
     */
    private Integer errorCode;

    /**
     * 错误信息，正确返回SUCCESS
     */
    private String errorMsg;

    /**
     * 返回值对象
     */
    private Object data;

    /**
     * 正确的响应构造函数
     *
     * @param data 返回值对象
     */
    public ResponseVO(Object data) {
        this.data = data;
    }
}
