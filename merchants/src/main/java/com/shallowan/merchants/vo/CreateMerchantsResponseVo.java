package com.shallowan.merchants.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户响应对象
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsResponseVo {
    /**
     * 商户 id：创建失败则为-1
     */
    private Integer id;

}
