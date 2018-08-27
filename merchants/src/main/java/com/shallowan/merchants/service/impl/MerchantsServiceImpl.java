package com.shallowan.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import com.shallowan.merchants.constant.CommonConstants;
import com.shallowan.merchants.dao.MerchantsDao;
import com.shallowan.merchants.entity.Merchants;
import com.shallowan.merchants.enums.ErrorCodeEnums;
import com.shallowan.merchants.service.MerchantsService;
import com.shallowan.merchants.vo.CreateMerchantsRequestVO;
import com.shallowan.merchants.vo.CreateMerchantsResponseVo;
import com.shallowan.merchants.vo.PassTempateVO;
import com.shallowan.merchants.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商户服务接口实现
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Service
@Slf4j
public class MerchantsServiceImpl implements MerchantsService {

    /**
     * 数据库接口
     */
    @Autowired
    private MerchantsDao merchantsDao;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 创建商户服务
     *
     * @param createMerchantsRequestVO {@link CreateMerchantsRequestVO} 创建商户请求
     * @return {@link ResponseVO}
     */
    @Override
    @Transactional
    public ResponseVO createMerchants(CreateMerchantsRequestVO createMerchantsRequestVO) {
        ResponseVO responseVO = new ResponseVO();
        CreateMerchantsResponseVo createMerchantsResponseVo = new CreateMerchantsResponseVo();
        ErrorCodeEnums errorCodeEnums = createMerchantsRequestVO.validate(merchantsDao);
        responseVO.setErrorCode(errorCodeEnums.getCode());
        responseVO.setErrorMsg(errorCodeEnums.getDesc());

        if (errorCodeEnums != ErrorCodeEnums.SUCCESS) {
            createMerchantsResponseVo.setId(-1);
            return responseVO;
        }

        createMerchantsResponseVo.setId(merchantsDao.save(createMerchantsRequestVO.toMerchants()).getId());
        responseVO.setData(createMerchantsResponseVo);
        return responseVO;
    }

    /**
     * 根据id构建商户信息
     *
     * @param id 商户id
     * @return {@link ResponseVO}
     */
    @Override
    public ResponseVO buildMerchantsInfoById(Integer id) {
        ResponseVO responseVO = new ResponseVO();
        Merchants merchants = merchantsDao.findById(id);

        if (null == merchants) {
            responseVO.setErrorCode(ErrorCodeEnums.MERCHANTS_NOT_EXIST.getCode());
            responseVO.setErrorMsg(ErrorCodeEnums.MERCHANTS_NOT_EXIST.getDesc());
            return responseVO;
        }

        responseVO.setErrorCode(ErrorCodeEnums.SUCCESS.getCode());
        responseVO.setErrorMsg(ErrorCodeEnums.SUCCESS.getDesc());
        responseVO.setData(merchants);
        return responseVO;
    }

    /**
     * 投放优惠券
     *
     * @param passTempateVO {@link PassTempateVO} 优惠券对象
     * @return {@link ResponseVO}
     */
    @Override
    public ResponseVO dropPassTemplate(PassTempateVO passTempateVO) {
        ResponseVO responseVO = new ResponseVO();
        ErrorCodeEnums errorCodeEnums = passTempateVO.validate(merchantsDao);
        responseVO.setErrorCode(errorCodeEnums.getCode());
        responseVO.setErrorMsg(errorCodeEnums.getDesc());

        if (errorCodeEnums != ErrorCodeEnums.SUCCESS) {
            return responseVO;
        }
        String passTemplate = JSON.toJSONString(passTempateVO);
        kafkaTemplate.send(
                CommonConstants.TEMPLATE_TOPIC,
                CommonConstants.TEMPLATE_TOPIC,
                passTemplate
        );
        log.info("DropPassTemplates：{}", passTempateVO);
        return responseVO;
    }
}
