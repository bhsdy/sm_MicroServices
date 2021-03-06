package com.sm.dao;

import org.apache.ibatis.annotations.Param;
import com.sm.domain.City;

import java.util.List;
import java.util.Map;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityMapper {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);

	long getAllByTotal();

//    List<Map<String,Object>> queryCityAndProvinceByMap(@Param("params") Map<String,Object> map);
    List<Map<String,Object>> queryCityAndProvinceByMap();
}
