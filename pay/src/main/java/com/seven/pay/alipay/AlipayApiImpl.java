package com.seven.pay.alipay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class AlipayApiImpl implements AlipayApi {
    @Value("${ALIPAY.APPID}")
    private String appId;
    @Value("${ALIPAY.RSA_PRIVATE_KEY}")
    private String merchant_private_key;
    @Value("${ALIPAY.ALIPAY_PUBLIC_KEY}")
    private String alipay_public_key;
    @Value("${ALIPAY.notify_url}")
    private String notifyUrl;
    @Value("${ALIPAY.return_url}")
    private String returnUrl;
    @Value("${ALIPAY.SIGNTYPE}")
    private String signType;
    @Value("${ALIPAY.CHARSET}")
    private String charset;
    @Value("${ALIPAY.URL}")
    private String gatewayUrL;
    @Value("${ALIPAY.FORMAT}")
    private String format;


    /**
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no     支付宝交易凭证号
     * @param trade_status 交易状态
     * @return String
     * @throws AlipayApiException
     * @throws
     * @Title: alipayNotify
     * @Description: 支付宝回调接口
     * @author nelson
     */
    @Override
    public String alipayNotify(HttpServletRequest request, String out_trade_no, String trade_no, String trade_status) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                System.out.println(valueStr);
            }
            map.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, alipay_public_key, charset, signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return ("fail");// 验签发生异常,则直接返回失败
        }
        if (signVerified) {
            //处理你的业务逻辑，更细订单状态等
            return ("success");
        } else {
            System.out.println("验证失败,不去更新状态");
            return ("fail");
        }
    }


    /**
     * @param request
     * @param out_trade_no 商户订单号
     * @param trade_no     支付宝交易凭证号
     *                     //     * @param trade_status 交易状态
     * @return String
     * @throws AlipayApiException
     * @throws
     * @Title: alipayReturn
     * @Description: 支付宝回调接口
     * @author nelson
     */
    @Override
    public String alipayReturn(Map<String, String> params, HttpServletRequest request, String
            out_trade_no, String trade_no, String total_amount) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = iter.next();
            String[] values = requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
                System.out.println(valueStr);
            }
            map.put(name, valueStr);
        }
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(map, alipay_public_key, charset, signType);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return ("fail");// 验签发生异常,则直接返回失败
        }
        if (signVerified) {
            return ("success");
        } else {
            System.out.println("验证失败,不去更新状态");
            return ("fail");
        }
    }
    @Override
    public String alipayPay(String totalAmount, String subject,String outTradeNo) {
        AlipayVo vo = new AlipayVo();
        vo.setOut_trade_no(outTradeNo);
        vo.setTotal_amount(totalAmount);
        vo.setSubject(subject);
        vo.setProduct_code("FAST_INSTANT_TRADE_PAY"); //这个是固定的
        String json = JSONObject.toJSONString(vo);
        System.out.println(json);

        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrL, appId, merchant_private_key, format,
                charset, alipay_public_key, signType);
        // 设置请求参数
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);
        alipayRequest.setBizContent(json);
        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        System.out.println(result);
        return result; //这里生成一个表单，会自动提交
    }

    @Override
    public AlipayTradeRefundResponse refund(AlipayAcquireRefundRequest refundRequest) {
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrL,appId,merchant_private_key,format,charset,alipay_public_key,signType);
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "\"out_trade_no\":"+refundRequest.getOutTradeNo()+"," +
                "\"trade_no\":"+refundRequest.getTradeNo()+"," +
                "\"refund_amount\":"+refundRequest.getRefundAmount()+"," +
                "\"refund_reason\":"+refundRequest.getRefundReason()+"," +
                "\"out_request_no\":"+refundRequest.getOutRequestNo()+"," +
                "\"operator_id\":"+refundRequest.getOperatorId()+"," +
                "  }");
        AlipayTradeRefundResponse response = null;

        try {
            response = alipayClient.execute(request);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return response;

    }
}
