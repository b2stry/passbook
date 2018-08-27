package com.shallowan.merchants.enums;

import lombok.Getter;

/**
 * 错误码枚举
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Getter
public enum ErrorCodeEnums {
    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 商户名称重复
     */
    DUPLICATE_NAME(1, "商户名称重复"),
    /**
     * 商户logo为空
     */
    EMPTY_LOGO(2, "商户logo为空"),
    /**
     * 商户营业执照为空
     */
    EMPTY_BUSINESS_LICENSE(3, "商户营业执照为空"),
    /**
     * 商户联系电话错误
     */
    ERROR_PHONE(4, "商户联系电话错误"),
    /**
     * 商户地址为空
     */
    EMPTY_ADDRESS(5, "商户地址为空"),
    /**
     * 商户不存在
     */
    MERCHANTS_NOT_EXIST(6, "商户不存在");

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String desc;

    ErrorCodeEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}