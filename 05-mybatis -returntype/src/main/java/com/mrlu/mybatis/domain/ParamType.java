package com.mrlu.mybatis.domain;

/**
 * @author Mr.Lu
 * @create 2021-02-07 22:08
 */
public class ParamType {
    private String name;
    private Integer age;

    public ParamType() {
    }

    public ParamType(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ParamType{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
