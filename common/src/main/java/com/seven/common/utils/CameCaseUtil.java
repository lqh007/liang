package com.seven.common.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ClassName: CameCaseUtil 
 * @Description:实现数据库下划线类型向驼峰的相互转化
 * @author zhangbo
 * @date May 16, 2014
 */
public class CameCaseUtil {
	private static final char SEPARATOR = '_';
	private static final Logger LOGGER = LoggerFactory.getLogger(CameCaseUtil.class);
	
	/**
	 * @Description: 将驼峰命名转化为下划线，如userName转化为user_name
	 * @param str
	 * @return String  
	 * @author zhangbo
	 * @date May 16, 2014
	 */
	public static String toUnderScoreCase(String str) {
		if (str == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			boolean nextUpperCase = true;
			if (i < (str.length() - 1)) {
				nextUpperCase = Character.isUpperCase(str.charAt(i + 1));
			}
			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}
			sb.append(Character.toLowerCase(c));
		}
		return sb.toString();
	}
	/**
	 * @Description: 将下划线转化为驼峰命名如:user_name转化为userName
	 * @param str
	 * @return String  
	 * @author zhangbo
	 * @date May 16, 2014
	 */
	public static String toCamelCase(String str) {
		if (str == null) {
			return null;
		}
		str = str.toLowerCase();
		StringBuilder sb = new StringBuilder(str.length());
		boolean upperCase = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * @Description: 将下划线转化为驼峰命名如:user_name转化为UserName。
	 * @param str
	 * @return String
	 * @author zhangbo
	 * @date May 16, 2014
	 */
	public static String toCapitalizeCamelCase(String str) {
		if (str == null) {
			return null;
		}
		str = toCamelCase(str);
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	/**
	 * @Description: 判断字符串是否为驼峰命名。
	 * @param str
	 * @return boolean  
	 * @author zhangbo
	 * @date May 16, 2014
	 */
	public static boolean isCame(String str){
		boolean result = false,upflag = false,lowlfag = false,underFlag = true;
		if(str.contains("_")){
			underFlag = false;
		}
		for(int i = 0,j=str.length();i<j;i++){
			if(!result){
				char c = str.charAt(i);
				if(!upflag){
					if(Character.isUpperCase(c)){
						upflag = true;
					}
				}
				if(!lowlfag){
					if(Character.isLowerCase(c)){
						lowlfag = true;
					}
				}
			}else{
				break;
			}
		}
		if(upflag && lowlfag && underFlag){
			result = true;
		}
		return result;
	}
}
