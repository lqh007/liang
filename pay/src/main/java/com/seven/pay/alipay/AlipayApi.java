package com.seven.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayAcquireRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface AlipayApi {
    /**
     * 支付回调接口
     * @param request
     * @param out_trade_no
     * @param trade_no
     * @param trade_status
     * @return
     * @throws AlipayApiException
     */
    String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status) throws AlipayApiException;

    /**
     * 支付跳转接口
     * @param params
     * @param request
     * @param out_trade_no
     * @param trade_no
     * @param total_amount
     * @return
     */
    String alipayReturn(Map<String, String> params, HttpServletRequest request, String
            out_trade_no, String trade_no, String total_amount);

    /**
     * 下单接口
     * @param totalAmount
     * @param subject
     * @param outTradeNo
     * @return
     */
    String alipayPay(String totalAmount, String subject, String outTradeNo);

    /**
     * 退款接口
     * @return
     */
    AlipayTradeRefundResponse refund(AlipayAcquireRefundRequest refundRequest);

}
