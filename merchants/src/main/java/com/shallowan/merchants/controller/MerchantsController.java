package com.shallowan.merchants.controller;

import com.alibaba.fastjson.JSON;
import com.shallowan.merchants.service.MerchantsService;
import com.shallowan.merchants.vo.CreateMerchantsRequestVO;
import com.shallowan.merchants.vo.PassTempateVO;
import com.shallowan.merchants.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商户服务 Controller
 *
 * @author shallowan
 */
@RestController
@RequestMapping("/merchants")
@Slf4j
public class MerchantsController {

    /**
     * 商户服务接口
     */
    @Autowired
    private MerchantsService merchantsService;

    @GetMapping
    public String hello() {
        return "hello";
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseVO createMerchants(@RequestBody CreateMerchantsRequestVO createMerchantsRequestVO) {
        log.info("CreateMerchants：{}", JSON.toJSON(createMerchantsRequestVO));
        return merchantsService.createMerchants(createMerchantsRequestVO);
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResponseVO buildMerchantsInfo(@PathVariable Integer id) {
        log.info("buildMerchantsInfo：id={}", id);
        System.out.println(id);
        return merchantsService.buildMerchantsInfoById(id);
    }

    @PostMapping("/drop")
    @ResponseBody
    public ResponseVO dropPassTemplate(@RequestBody PassTempateVO passTempateVO) {
        log.info("dropPassTemplate：{}", JSON.toJSON(passTempateVO));
        return merchantsService.dropPassTemplate(passTempateVO);
    }
}
