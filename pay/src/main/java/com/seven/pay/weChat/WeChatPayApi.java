package com.seven.pay.weChat;

import com.yansu.pay.ApiResponse;

import java.util.Map;

public interface WeChatPayApi {
    /**
     * @param payEntity
     * @return 统一下单
     */
    ApiResponse unifiedOrder(WeChatPayEntity payEntity);

    /**
     * 订单查询
     * @param paraMap
     * @return
     */
    ApiResponse orderQuery(Map<String, Object> paraMap);

    /**
     * 申请退款
     */
    ApiResponse refund(Map<String, Object> paraMap);

    /**
     * 退款查询
     * @param paraMap
     * @return
     */
    ApiResponse refundquery(Map<String, Object> paraMap);
}
