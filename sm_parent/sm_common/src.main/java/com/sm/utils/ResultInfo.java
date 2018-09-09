package com.sm.utils;

/**
 * 自定义的结果集
 *
 * @description 
 *
 * @author DaiZhengmiao
 * @createDate 2015年12月4日
 */
public class ResultInfo {

	/** 公共错误码-99:数据库错误 */
	public static final int ERROR_SQL = -99;
	
	/** 公共错误码-404:未找到资源() */
	public static final int ERROR_404 = -404;
	
	/** 公共错误码-500:程序错误 */
	public static final int ERROR_500 = -500;
	
	/** 公共错误码-900:非法请求 */
	public static final int ILLEGAL_REQUEST = -900;
	
	
	
	
	//特殊业务标识定义范围：-1000 ~ -2000
	
	/** 特殊业务标识-1000:数据未更新 */
	public static final int NOT_UPDATE = -1000;
	
	/** 特殊业务标识-1001:某业务已经成功执行 */
	public static final int ALREADY_RUN = -1001;
	
	/** 特殊业务标识-1002:规定时长内，重复发送短信 */
	public static final int SMS_RESEND = -1002;
	
	
	
	
	//拦截标识定义范围：-2000 ~ -3000  
	/** 拦截标识-2000:没有登录 */
	public static final int NOT_LOGIN = -2000;
	
	/** 拦截标识-2001:没有权限 */
	public static final int NOT_RIGHT = -2001;
	


	/** 登录超时*/
	public static final int  LOGIN_TIME_OUT = -105; 
	
	/** 登录超时提醒语*/
	public static final String LOGIN_TIME_OUT_MSG = "登录超时，请重新登录";
	
	/** 没有绑定银行卡 */
	public static final int NOT_BIND_BANKCARD = -104; 
	
	/** 拦截标识-103:未实名认证 */
	public static final int NOT_REAL_NAME = -103;
	
	/** 
	 * 消息码。
	 * 默认：code = 0
	 * 成功：code > 0
	 * 失败：code < 1
	 */
	public int code = 0;
	
	/** 提示信息 */
	public String msg = "亲，系统繁忙！";
	
	/** 结果集中的对象 */
	public Object obj;

	@Override
	public String toString() {
		return "ResultInfo [code=" + code + ", msg=" + msg + ", object="
				+ obj + "]";
	}
	
}
