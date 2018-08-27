package com.shallowan.merchants.enums;

import lombok.Getter;

/**
 * 模板颜色枚举
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Getter
public enum TemplateColorEnums {
    /**
     * 红色
     */
    RED(1, "红色"),
    /**
     * 绿色
     */
    GREEN(2, "绿色"),
    /**
     * 蓝色
     */
    BLUE(3, "蓝色");

    /**
     * 颜色代码
     */
    private Integer code;

    /**
     * 颜色描述
     */
    private String color;

    TemplateColorEnums(Integer code, String color) {
        this.code = code;
        this.color = color;
    }
}
