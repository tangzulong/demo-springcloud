package com.zulong.elasticsearch.entity;

/**
 * @Project_Name: demo-springcloud
 * @Description: 地址
 * @Author: Mr.Tang
 * @Create_Date: 2018-07-20 10:00
 **/
public class Address {

    //国
    private String country;
    //省
    private String province;
    //市
    private String city;
    //县
    private String county;
    //镇


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
