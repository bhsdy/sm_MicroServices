package com.sm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.canstens.Constants;
import com.sm.dao.CityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.sm.domain.City;
import com.sm.service.CityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 城市业务 Dubbo 服务层实现层
 *
 * Created by bysocket on 28/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 1.根据城市ID,查询城市信息
     */
    public City findCityById(Long id) {
        // 从缓存中获取城市信息
        String key = Constants.CITY + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);

            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityMapper.findById(id);

        // 插入缓存
        operations.set(key, city, 10, TimeUnit.SECONDS);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());

        return city;
    }

    @Override
    public Long saveCity(City city) {
        return cityMapper.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        Long ret = cityMapper.updateCity(city);

        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }

        return ret;
    }

    @Override
    public Long deleteCity(Long id) {

        Long ret = cityMapper.deleteCity(id);

        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }

	@Override
	public Map<String, Object> findAllCity() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		long count = cityMapper.getAllByTotal();
		returnMap.put("count", count);
		
		if(count > 0) {
			returnMap.put("list", cityMapper.findAllCity());
		}
		return returnMap;
	}

    @Override
    public PageInfo<Map<String,Object>> queryCityAndProvinceByMap() {
        PageHelper.startPage(1,2);
        List<Map<String, Object>> maps = cityMapper.queryCityAndProvinceByMap();
        PageInfo<Map<String, Object>> mapPageInfo = new PageInfo<>(maps);
        return mapPageInfo;
    }

}
