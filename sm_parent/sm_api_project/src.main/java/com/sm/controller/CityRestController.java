package com.sm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.sm.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sm.domain.City;
import com.sm.service.CityService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class CityRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(CityRestController.class);
	
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/city/getAll", method = RequestMethod.GET)
    public String findAllCity() {
    	JSONObject resObject = new JSONObject();
        resObject.put("code", 0);
        resObject.put("msg", "成功");
        resObject.put("res_data", cityService.findAllCity());
        return resObject.toJSONString();
    }
	
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
    public City findOneCity(@PathVariable("id") Long id) {
        return cityService.findCityById(id);
    }

	/**
	 * 新增
	 * @param request
	 */
    @RequestMapping(value = "/city/insert", method = RequestMethod.POST)
    public String createCity(HttpServletRequest request) {
    	JSONObject parmObj = HttpUtil.getParameters(request);
        String cityStr = parmObj.getJSONObject("request_data").getString("city");
        City city = JSON.parseObject(cityStr, new City().getClass());
        Long result = cityService.saveCity(city);
        if (result > 0){
            JSONObject resObject = new JSONObject();
            resObject.put("code", 0);
            resObject.put("msg", "成功");
            return resObject.toJSONString();
        }
        logger.error("插入异常");
        JSONObject resObject = new JSONObject();
        resObject.put("code", 10002);
        resObject.put("msg", "异常");
        return resObject.toJSONString();
    }

    @RequestMapping(value = "/city", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody City city) {
    	cityService.updateCity(city);
    }
    
    /**
     * @param cityId
     */
    @RequestMapping(value = "/auth/city/delete", method = RequestMethod.POST)
    public String modifyCity(@RequestParam(name="city_id") String cityId) {
    	logger.info("认证通过, 执行删除请求开始...");
    	cityService.deleteCity(Long.valueOf(cityId));
    	
    	JSONObject resObject = new JSONObject();
        resObject.put("code", 0);
        resObject.put("msg", "成功");
        return resObject.toJSONString();
    }

    /**
     * @param request
     */
    @RequestMapping(value = "/city/queryCityAndProvinceByMap", method = RequestMethod.POST)
    public String queryCityAndProvinceByMap(HttpServletRequest request) {
        JSONObject parmObj = HttpUtil.getParameters(request);
        String requestDataStr = parmObj.getString("request_data");
        Map<String,Object> hashMap = JSON.parseObject(requestDataStr, new HashMap<String, Object>().getClass());

        PageInfo<Map<String,Object>> stringObjectList = cityService.queryCityAndProvinceByMap();

        JSONObject resObject = new JSONObject();
        resObject.put("code", 0);
        resObject.put("msg", "成功");
        resObject.put("data", stringObjectList);
        return resObject.toJSONString();
    }

}
