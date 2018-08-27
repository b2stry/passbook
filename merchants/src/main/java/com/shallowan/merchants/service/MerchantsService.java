package com.shallowan.merchants.service;

import com.shallowan.merchants.vo.CreateMerchantsRequestVO;
import com.shallowan.merchants.vo.PassTempateVO;
import com.shallowan.merchants.vo.ResponseVO;

/**
 * 商户服务接口定义
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */

public interface MerchantsService {

    /**
     * 创建商户服务
     *
     * @param createMerchantsRequestVO {@link CreateMerchantsRequestVO} 创建商户请求
     * @return {@link ResponseVO}
     */
    ResponseVO createMerchants(CreateMerchantsRequestVO createMerchantsRequestVO);

    /**
     * 根据id构建商户信息
     *
     * @param id 商户id
     * @return {@link ResponseVO}
     */
    ResponseVO buildMerchantsInfoById(Integer id);

    /**
     * 投放优惠券
     *
     * @param passTempateVO {@link PassTempateVO} 优惠券对象
     * @return {@link ResponseVO}
     */
    ResponseVO dropPassTemplate(PassTempateVO passTempateVO);
}
