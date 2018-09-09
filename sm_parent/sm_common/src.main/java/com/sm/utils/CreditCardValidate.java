package com.sm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 16位卡号校验位采用 Luhm 校验方法计算（19位通用）：
 * 1、将未带校验位的 15（18） 位卡号从右依次编号 1 到 15（18），位于奇数位号上的数字乘以 2
 * 2、 将奇位乘积的个十位全部相加，再加上所有偶数位上的数字
 * 3、 将加法和加上校验位能被 10 整除。 
 * 
 */
public class CreditCardValidate {
	
	/**
	 * 验证银行卡格式
	 *
	 * @param cardId
	 * @return
	 *
	 * @author herenfeng
	 * @createDate 2016年10月24日
	 */
	public static boolean checkBankCard(String cardId) {
		if (!checkBaseInfo(cardId)){
			return false;
		}
		char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
		if (bit == 'N') {
			return false;
		}
		
		return cardId.charAt(cardId.length() - 1) == bit;
	}

	/**
	 * 校验卡号的基本信息（是否全数字，长度等）
	 *
	 * @param cardId
	 * @return
	 *
	 * @author herenfeng
	 * @createDate 2016年10月24日
	 */
	public static boolean checkBaseInfo(String cardId) {
		
		if (cardId == null){
			return false;
		}
		//必须全为数字
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(cardId);
		if (!isNum.matches()) {
			return false;
		}
		//长度在16-19之间
		if (cardId.length() < 16 || cardId.length() > 19){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
	 *
	 * @param nonCheckCodeCardId
	 * @return
	 *
	 * @author herenfeng
	 * @createDate 2016年10月24日
	 */
	public static char getBankCardCheckCode(String nonCheckCodeCardId) {
		if (nonCheckCodeCardId == null
				|| nonCheckCodeCardId.trim().length() == 0
				|| !nonCheckCodeCardId.matches("\\d+")) {
			// 如果传的不是数据返回N
			return 'N';
		}
		
		char[] chs = nonCheckCodeCardId.trim().toCharArray();
		int luhmSum = 0;
		for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
			int k = chs[i] - '0';
			if (j % 2 == 0) {
				k *= 2;
				k = k / 10 + k % 10;
			}
			luhmSum += k;
		}
		return (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
	}
}
