package com.sm.controller;

import com.alibaba.fastjson.JSONObject;
import com.sm.util.HttpUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sm.domain.Permission;
import com.sm.service.PermissionService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/api")
public class PermissionController {
    
	private static final Logger logger = Logger.getLogger(PermissionController.class);
    
    @Autowired
    private PermissionService permissionService;
    
    @RequestMapping(value = "/Permission/save")
    public String save(HttpServletRequest request){
        JSONObject resObject = new JSONObject();
        try {
        JSONObject reqData = HttpUtil.getParameters(request);
        JSONObject parmObj = JSONObject.parseObject(reqData.getString("request_data")) ;
        Permission permission = new Permission();
        permission.setPerName(parmObj.getString("per_name"));
            int insert = permissionService.insert(permission);
            if (insert > 0){
                resObject.put("code", 0);
                resObject.put("msg", "成功");
                return resObject.toJSONString();
            }else {
                resObject.put("code", 10001);
                resObject.put("msg", "失败");
                return resObject.toJSONString();
            }
        } catch (Exception e) {
            logger.error("插入异常", e);
            resObject.put("code", 10002);
            resObject.put("msg", "异常");
            return resObject.toJSONString();
        }
    }
    
}
