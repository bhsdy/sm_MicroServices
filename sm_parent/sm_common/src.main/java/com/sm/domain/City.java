package com.sm.domain;

import java.io.Serializable;

/**
 * 城市实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class City implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private String provinceCode;

    /**
     * 城市编号
     */
    private String code;
    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

    public City() {
    }

    public City(Long id, String provinceCode, String code, String cityName, String description) {
        this.id = id;
        this.provinceCode = provinceCode;
        this.code = code;
        this.cityName = cityName;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", provinceCode='" + provinceCode + '\'' +
                ", code='" + code + '\'' +
                ", cityName='" + cityName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
