package com.sm.service;

import com.github.pagehelper.PageInfo;
import com.sm.domain.City;

import java.util.Map;

/**
 * 城市业务 Dubbo 服务层
 *
 * Created by bysocket on 28/02/2017.
 */
public interface CityService {
    /**
     * 根据城市 ID,查询城市信息
   *
   * @param id
   * @return
   */
  City findCityById(Long id);

  /**
   * 新增城市信息
   *
   * @param city
   * @return
   */
  Long saveCity(City city);

  /**
   * 更新城市信息
   *
   * @param city
   * @return
   */
  Long updateCity(City city);

  /**
   * 根据城市 ID,删除城市信息
   *
   * @param id
   * @return
   */
  Long deleteCity(Long id);
  
  Map<String, Object> findAllCity();

  /**
   * 传入map参数
   * @param map
   * @return
   */
//  List<Map<String,Object>> queryCityAndProvinceByMap(Map<String,Object> map);
  PageInfo<Map<String,Object>> queryCityAndProvinceByMap();

}
