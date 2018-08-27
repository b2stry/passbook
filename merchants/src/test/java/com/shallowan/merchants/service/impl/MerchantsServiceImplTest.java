package com.shallowan.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.shallowan.merchants.service.MerchantsService;
import com.shallowan.merchants.vo.CreateMerchantsRequestVO;
import com.shallowan.merchants.vo.PassTempateVO;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 商户服务测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServiceImplTest {

    @Autowired
    private MerchantsService merchantsService;

    @Test
    public void createMerchants() {
        CreateMerchantsRequestVO createMerchantsRequestVO = new CreateMerchantsRequestVO();
        createMerchantsRequestVO.setName("慕课网");
        createMerchantsRequestVO.setLogoUrl("www.imooc.com");
        createMerchantsRequestVO.setBusinessLicenseUrl("www.imooc.com");
        createMerchantsRequestVO.setPhone("1234567981");
        createMerchantsRequestVO.setAddress("北京市");

        System.out.println(JSON.toJSON(merchantsService.createMerchants(createMerchantsRequestVO)));
    }

    @Test
    public void buildMerchantsInfoById() {
        System.out.println(JSON.toJSON(merchantsService.buildMerchantsInfoById(6)));
    }

    @Test
    public void dropPassTemplate() {
        PassTempateVO passTempateVO = new PassTempateVO();
        passTempateVO.setId(2);
        passTempateVO.setTitle("慕课网");
        passTempateVO.setSummary("简介：慕课网");
        passTempateVO.setDesc("详情：慕课网");
        passTempateVO.setLimit(10000L);
        passTempateVO.setHasToKen(false);
        passTempateVO.setBackground(2);
        passTempateVO.setStart(new Date());
        passTempateVO.setEnd(DateUtils.addDays(new Date(), 10));
        System.out.println(JSON.toJSON(merchantsService.dropPassTemplate(passTempateVO)));
    }
}