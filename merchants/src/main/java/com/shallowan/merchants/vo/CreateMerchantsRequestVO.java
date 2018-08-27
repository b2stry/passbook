package com.shallowan.merchants.vo;

import com.shallowan.merchants.dao.MerchantsDao;
import com.shallowan.merchants.entity.Merchants;
import com.shallowan.merchants.enums.ErrorCodeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 创建商户请求对象
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMerchantsRequestVO {

    /**
     * 商户名称
     */
    private String name;

    /**
     * 商户logo
     */
    private String logoUrl;


    /**
     * 商户营业执照
     */
    private String businessLicenseUrl;

    /**
     * 商户联系电话
     */
    private String phone;

    /**
     * 商户地址
     */
    private String address;

    /**
     * 验证请求的有效性
     *
     * @param merchantsDao {@link MerchantsDao}
     * @return {@link ErrorCodeEnums}
     */
    public ErrorCodeEnums validate(MerchantsDao merchantsDao) {
        if (null != merchantsDao.findByName(this.name)) {
            return ErrorCodeEnums.DUPLICATE_NAME;
        }

        if (null == this.logoUrl) {
            return ErrorCodeEnums.EMPTY_LOGO;
        }

        if (null == this.businessLicenseUrl) {
            return ErrorCodeEnums.EMPTY_BUSINESS_LICENSE;
        }

        if (null == this.address) {
            return ErrorCodeEnums.EMPTY_ADDRESS;
        }

        if (null == this.phone) {
            return ErrorCodeEnums.ERROR_PHONE;
        }

        return ErrorCodeEnums.SUCCESS;
    }

    /**
     * 将请求对象转化为商户对象
     *
     * @return {@link Merchants}
     */
    public Merchants toMerchants() {
        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);

        return merchants;
    }
}
