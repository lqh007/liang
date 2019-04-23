package com.seven.pay.alipay;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AlipayConfig {

    // 商户ID
    private String appid = "2016092500596324";
    // 私钥
    private String rsa_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC5Lp+lab9ulVQtnPFVY2sIA4liywFfZL9FRHCEb9+myc+SkkijTgzLXF040zOeMWoV76jXn1EQfHrk3N2auFKPUCCztheY+OcEv8VfK7N9ArNaui7W/4VgfuepuFqHcQRp2U9GZF0TKbud0+QP2ZZ2aJ+rixLnKnvoBUlFI7bWdkkghOjoRfW69xzUqQrTDcS3Dqeyr3bQ46PCO+PyoNEhpp1m1cenSfhhLwsukyv1HjJCWXkjpZIrnQDrHP3Y/48gHuGXqEFfREj/jlT5R/faZuab3DDNfKg4GSmf3LH/rGtUP54uiUXuC0d/E8PdXREoHGuc5BQkkHx9f95TTXSXAgMBAAECggEAevtfwvcLz2EU2oYUMGUqO9Q9dYLkknnSHSpqn0m8+oOkeu7zlqDLFnNs5cQ9z515mr/jHfAMYiqJY1zbP1mSWuMYFMGlwk3q/thtN9tKBIe6nVJwsRBZf9BIAgsQ9Eo2aCWN5G3a8lMQ6qxCFdSnfFPXVpGyKBuq1lhMZMJnNt2NeU8hzITqDUXEbpv7HIQE/XxTnkAxaQpKchjftGoAxw8mPpDzvq0lqWX0q7QS7CCVJhDNArwa+VlQuQ+lMLmdyZhl3QWzidr/CD1gH7P03wkZ2NdTrg5oLgqsy6yC9vwFHysoyyMy6Ubzx7ly7V1iD/nH5OXuI9JR2p6bIw3tIQKBgQDrSNYxmEbv0/xYYP7iUYIdPu/+9ml8Z0AEXJlrTgFBu1FZEEu5GiKEYIc8hJnhsXCJIWgy0QP6v3xPRWRXP7moIgRJ+kLYJlfO0sSZFc1H+yk6tF8sM/CsXCHIccldlvwkeJ0pwdTieeVF3PuB+HvB76S4CJh9nAWWz5k+QTv1NQKBgQDJfILFvJsEYjdjGAYLqKEgLb4MvBAOQyyB2DFdfCt+RAHa7QY4VoTCnZunsW1zw+ef0eEj88NFwDBZ1GWuMiL5HPt4CGyVYrd9GMmXNAk8N880tCsj2/+/jmdaRc6LRwbtUWkMa7FpeVBBTkKLNkJQz/vm4F8lEx2IXV1JUNs4GwKBgQCc/65Fy7nSAJ9LDfYmaIMtJrkYZa6/31m9T1jkXFnEVc0TZCdTLZhIwuyaulTAYBmat5sDBavlHu9BKimpepFVGtXH02HVP8ip7sRW7lBbrsG1NXSoV0RKjvPP//WBKOW5JG6i1X9LXFFcC/gbowZZw6IjV0EB2CF2n7I+82Kh3QKBgEBaaFpHtytbQ11/Gs82eOASPBVNK8OiaOC/8GRveGTHy9/kvIvZ9mVCeajB3reO5rgBDOuyu7fXfpnyYNeWY901CIx6BFRiR0DJXfnRQPHe0Wt/8Bdv+OtxzEjk6udJNEkwK2EwNGX/vUZefJqCJgQxqb9AAqOQy2n2iAkWri3pAoGBAOLJrJzF9F7cYJ9LMyOG09RSRMoeZHXIEWve3Q+lnTj6A/6bXTTq0J9HEC/m6Sn2E64dP12sWAcdm9lOjlvywSJ1hrO+evkMe7013j4U02j2uH/QQbwlaj6BZS3LqaguZuKiM4EJRA59Hs3+cptWeC457rgBLxEpobF1plT1LNo2";
    // 异步回调地址
    private String notify_url = "http://chefu.yansu.com/";
    // 同步回调地址
    private String return_url;
    // 请求网关地址
    private String gateway_url = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    private String charset = "UTF-8";
    // 返回格式
    private String format = "json";
    // 支付宝公钥
    private String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuS6fpWm/bpVULZzxVWNr CAOJYssBX2S/RURwhG/fpsnPkpJIo04My1xdONMznjFqFe+o159REHx65NzdmrhS j1Ags7YXmPjnBL/FXyuzfQKzWrou1v+FYH7nqbhah3EEadlPRmRdEym7ndPkD9mW dmifq4sS5yp76AVJRSO21nZJIITo6EX1uvcc1KkK0w3Etw6nsq920OOjwjvj8qDR IaadZtXHp0n4YS8LLpMr9R4yQll5I6WSK50A6xz92P+PIB7hl6hBX0RI/45U+Uf3 2mbmm9wwzXyoOBkpn9yx/6xrVD+eLolF7gtHfxPD3V0RKBxrnOQUJJB8fX/eU010 lwIDAQAB";
    // RSA2
    private String signtype = "RSA2";

}
