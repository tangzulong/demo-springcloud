package com.zulong.elasticsearch.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.beans.Transient;
import java.util.List;


/**
 * @author tangzulong
 * @file UserDto.java
 * @date 2017-11-29
 * 16:45
 */
public class UserDto {

    private String userId;  //用户id

    private String userName; //用户名

    private String mobileNumber; //手机号

    private String nickName; //昵称

    private String userGroup; //用户分组 (普通用户/员工用户)

    private String blackListFlag;//是否是黑名单

    public String userHeadPhoto;//用户头像

    private String  userLable; //标签

    private String remark; //备注

    private String email;  //邮箱

    private List<Address> addresses;

    private String password; //密码

    private String gender;  //性别

    private String districtCode; //区编号

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Long birthDate; //出生日期

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Long registrationTime; //注册时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Long lastLoginDate; //最后一次登录时间

    private String birthDateStr;

    private String registrationTimeStr;

    private String lastLoginDateStr;

    private String vcode;

    private long startDate;

    private long endDate;

    private int pageNumber;

    private int pageSize;

    public UserDto() {
    }

    public UserDto(String userId, String userName, String mobileNumber,String userHeadPhoto, String nickName, String userGroup, String blackListFlag, String userLable, String remark, String email, String password, String gender, String districtCode, Long birthDate, Long registrationTime, Long lastLoginDate) {
        this.userId = userId;
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.userHeadPhoto=userHeadPhoto;
        this.nickName = nickName;
        this.userGroup = userGroup;
        this.blackListFlag = blackListFlag;
        this.userLable = userLable;
        this.remark = remark;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.districtCode = districtCode;
        this.birthDate = birthDate;
        this.registrationTime = registrationTime;
        this.lastLoginDate = lastLoginDate;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public String getBlackListFlag() {
        return blackListFlag;
    }

    public void setBlackListFlag(String blackListFlag) {
        this.blackListFlag = blackListFlag;
    }

    public String getUserLable() {
        return userLable;
    }

    public void setUserLable(String userLable) {
        this.userLable = userLable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Long birthDate) {
        this.birthDate = birthDate;
    }

    public Long getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Long registrationTime) {
        this.registrationTime = registrationTime;
    }

    public Long getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Long lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getBirthDateStr() {
        return birthDateStr;
    }

    public void setBirthDateStr(String birthDateStr) {
        this.birthDateStr = birthDateStr;
    }

    public String getRegistrationTimeStr() {
        return registrationTimeStr;
    }

    public void setRegistrationTimeStr(String registrationTimeStr) {
        this.registrationTimeStr = registrationTimeStr;
    }

    public String getLastLoginDateStr() {
        return lastLoginDateStr;
    }

    public void setLastLoginDateStr(String lastLoginDateStr) {
        this.lastLoginDateStr = lastLoginDateStr;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getUserHeadPhoto() {
        return userHeadPhoto;
    }

    public void setUserHeadPhoto(String userHeadPhoto) {
        this.userHeadPhoto = userHeadPhoto;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userGroup='" + userGroup + '\'' +
                ", blackListFlag='" + blackListFlag + '\'' +
                ", userHeadPhoto='" + userHeadPhoto + '\'' +
                ", userLable='" + userLable + '\'' +
                ", remark='" + remark + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", districtCode='" + districtCode + '\'' +
                ", birthDate=" + birthDate +
                ", registrationTime=" + registrationTime +
                ", lastLoginDate=" + lastLoginDate +
                ", birthDateStr='" + birthDateStr + '\'' +
                ", registrationTimeStr='" + registrationTimeStr + '\'' +
                ", lastLoginDateStr='" + lastLoginDateStr + '\'' +
                ", vcode='" + vcode + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
