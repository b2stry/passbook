package com.shallowan.merchants.security;


import com.shallowan.merchants.constant.CommonConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
@Component
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String token = httpServletRequest.getHeader(CommonConstants.TOKEN_STRING);

        if (StringUtils.isEmpty(token)) {
            throw new Exception("Header 中缺少" + CommonConstants.TOKEN_STRING + "!");
        }

        if (!token.equals(CommonConstants.TOKEN)) {
            throw new Exception("Header 中" + CommonConstants.TOKEN_STRING + "错误！");
        }

        AccessContext.setToken(token);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        AccessContext.clearAccessKey();
    }
}
