package com.shallowan.merchants.security;

/**
 * 用ThreadLocal去单独存储每一个线程携带的部分信息
 * <p>
 * Created by shallowan
 *
 * @author shallowan
 */
public class AccessContext {

    private static final ThreadLocal<String> TOKEN = new ThreadLocal<String>();

    public static String getToken() {
        return TOKEN.get();
    }

    public static void setToken(String token) {
        TOKEN.set(token);
    }

    public static void clearAccessKey() {
        TOKEN.remove();
    }
}
