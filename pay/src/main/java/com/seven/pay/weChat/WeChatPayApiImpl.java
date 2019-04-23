package com.seven.pay.weChat;

import com.yansu.pay.ApiResponse;
import com.yansu.pay.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.yansu.pay.weChat.WXPayUtil.*;

@Service
public class WeChatPayApiImpl implements WeChatPayApi {

    @Value("${WXPAY.APPID}")
    private String appId;
    @Value("${WXPAY.MchID}")
    private String MchID;
    @Value("${WXPAY.KEY}")
    private String KEY;


    @Override
    public ApiResponse unifiedOrder(WeChatPayEntity payEntity) {
        StringBuilder sBuilder = null;

        try {
            Map<String, String> paraMap = new HashMap<String, String>();
            paraMap.put("appid", payEntity.getAppid());
            paraMap.put("attach", payEntity.getAttach());
            paraMap.put("body", payEntity.getBody());
            paraMap.put("mch_id", payEntity.getMchId());
            paraMap.put("nonce_str", payEntity.getNonceStr());
//            paraMap.put("openid", payEntity.getOpenId());
            paraMap.put("out_trade_no", payEntity.getOutTradeNo());
            paraMap.put("spbill_create_ip", payEntity.getSpbillCreateIp());
            paraMap.put("total_fee", payEntity.getTotalFee());
            paraMap.put("trade_type", payEntity.getTradeType());
            paraMap.put("notify_url", payEntity.getNotifyUrl());// 此路径是微信服务器调用支付结果通知路径
            String sign = generateSignature(paraMap, KEY);
            paraMap.put("sign", sign);
            // 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
            String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

            String xml = WXPayUtil.mapToXml(paraMap);

//            String xmlStr = HttpUtils.connectServer(xml, url);
            String xmlStr = HttpUtils.httpsRequest(url, "POST", xml);
            // 预付商品id
            String prepay_id = "001";

            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = xmlToMap(xmlStr);
                prepay_id = (String) map.get("prepay_id");
            }

            long timeStamp = getCurrentTimestamp();
            String nonceStr = generateNonceStr();
            Map<String, String> payMap = new HashMap<String, String>();
            payMap.put("appId", appId);
            payMap.put("timeStamp", timeStamp + "");
            payMap.put("nonceStr", nonceStr);
            payMap.put("signType", "MD5");
            payMap.put("package", "prepay_id=" + prepay_id);
            String paySign = generateSignature(payMap, KEY);

            payMap.put("pg", prepay_id);
            payMap.put("paySign", paySign);

            // 拼接并返回json
            sBuilder = new StringBuilder("[{");
            sBuilder.append("appId:'").append(appId).append("',")
                    .append("timeStamp:'").append(timeStamp).append("',")
                    .append("nonceStr:'").append(nonceStr).append("',")
                    .append("pg:'").append(prepay_id).append("',")
                    .append("signType:'MD5',")
                    .append("paySign:'").append(paySign).append("'");
            sBuilder.append("}]");

        } catch (Exception e) {
            e.printStackTrace();
        }


        return ApiResponse.success(sBuilder);
    }

    @Override
    public ApiResponse orderQuery(Map<String, Object> paraMap) {
        return null;
    }

    @Override
    public ApiResponse refund(Map<String, Object> paraMap) {
        return null;
    }

    @Override
    public ApiResponse refundquery(Map<String, Object> paraMap) {
        return null;
    }
}
