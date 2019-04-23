package com.seven.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证
 *
 * @Author Michael
 * @time 2018/9/9 17:48
 */
public class ValidationUtils {

    /**
     * 手机正则
     */
    private final static String REX_MOBILE = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
    ;

    /**
     * 身份证正则
     */
    private final static String REX_IDNO = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";


    /**
     * 是否手机号码
     *
     * @param mobileNo 手机号
     * @return
     */
    public static boolean isMobileNo(String mobileNo) {

        return ValidationUtils.regEx(REX_MOBILE, mobileNo);

    }

    /**
     * 是否身份证号码
     *
     * @param idNo 身份证号码
     * @return
     */
    public static boolean isIdNo(String idNo) {
        return ValidationUtils.regEx(REX_IDNO, idNo);
    }


    private static boolean regEx(String regEx, String test) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(test);
        return m.matches();
    }

    public static void main(String[] args) {
        System.out.println(ValidationUtils.isIdNo("6104281985051740161"));
    }
}
