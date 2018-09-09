package com.sm.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtil {
	
	/**
	 * 获取请求参数
	 * @param request
	 * @return
	 */
	public static JSONObject getParameters(HttpServletRequest request) {
		try {
			StringBuffer sb = new StringBuffer();
			InputStream is = request.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String s = "";
			while ((s=br.readLine()) != null) {
				sb.append(s);
			}
			String str = sb.toString();
			JSONObject jsonObject = new JSONObject();
			if(null != str && !"".equals(str)) {
				jsonObject = JSONObject.parseObject(str);
			}
			return jsonObject;
		} catch (IOException e) {
			e.printStackTrace();
			return new JSONObject();
		}
	}
}
