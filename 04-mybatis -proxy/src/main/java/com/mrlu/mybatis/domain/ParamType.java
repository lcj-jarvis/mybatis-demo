package com.mrlu.mybatis.domain;

/**
 * @author Mr.Lu
 * @create 2021-02-07 22:08
 */
public class ParamType {
    private String paramName;
    private Integer paramAge;

    public ParamType() {
    }

    public ParamType(String paramName, Integer paramAge) {
        this.paramName = paramName;
        this.paramAge = paramAge;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Integer getParamAge() {
        return paramAge;
    }

    public void setParamAge(Integer paramAge) {
        this.paramAge = paramAge;
    }

    @Override
    public String toString() {
        return "ParamType{" +
                "paramName='" + paramName + '\'' +
                ", paramAge='" + paramAge + '\'' +
                '}';
    }
}
