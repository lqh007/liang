package com.seven.pay.weChat;

public class test {


    public static void main(String[] args) {
        WeChatPayApi weChatPayApi = new WeChatPayApiImpl();
        WeChatPayEntity weChatPayEntity = new WeChatPayEntity();
        weChatPayEntity.setAppid("wxe9ba72c6c5f0ae2f");
        weChatPayEntity.setMchId("1489149222");
        weChatPayEntity.setAttach("深圳分店");
        weChatPayEntity.setNonceStr(WXPayUtil.generateNonceStr());
        weChatPayEntity.setBody("test");
        weChatPayEntity.setOutTradeNo("001");
        weChatPayEntity.setTotalFee("0.01");
        weChatPayEntity.setNotifyUrl("www.baidu.com");
        weChatPayApi.unifiedOrder(weChatPayEntity);
    }
}
