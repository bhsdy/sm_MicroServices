package com.sm.controller;

import com.alibaba.fastjson.JSONObject;
import com.sm.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String doRegister(HttpServletRequest request) {
		JSONObject parmObj = HttpUtil.getParameters(request);
		logger.info("请求注册接口, 请求参数:"+ parmObj.toJSONString());
    	JSONObject resObject = new JSONObject();
        resObject.put("code", 0);
        resObject.put("msg", "成功");
        return resObject.toJSONString();
    }
	
	
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request) {
		JSONObject parmObj = HttpUtil.getParameters(request);
		logger.info("请求登录接口, 请求参数:"+ parmObj.toJSONString());
    	JSONObject resObject = new JSONObject();
        resObject.put("code", 0);
        resObject.put("msg", "成功");
        return resObject.toJSONString();
    }
	
}
