package com.shallowan.merchants.vo;

import com.shallowan.merchants.dao.MerchantsDao;
import com.shallowan.merchants.enums.ErrorCodeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 投放的优惠券对象定义
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTempateVO {

    /**
     * 所属商户 id
     */
    private Integer id;

    /**
     * 优惠券标题
     */
    private String title;

    /**
     * 优惠券摘要
     */
    private String summary;

    /**
     * 优惠券的详细信息
     */
    private String desc;

    /**
     * 最大个数限制
     */
    private Long limit;

    /**
     * 优惠券是否有 Token， 用户商户核销
     * token存储在redis set中，每次领取从reids中获取
     */
    private Boolean hasToKen;

    /**
     * 优惠券背景色
     */
    private Integer background;


    /**
     * 优惠券开始时间
     */
    private Date start;


    /**
     * 优惠券结束时间
     */
    private Date end;


    /**
     * 校验优惠券对象的有效性
     *
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCodeEnums}
     */
    public ErrorCodeEnums validate(MerchantsDao merchantsDao) {
        if (null == merchantsDao.findById(this.id)) {
            return ErrorCodeEnums.MERCHANTS_NOT_EXIST;
        }
        return ErrorCodeEnums.SUCCESS;
    }
}
