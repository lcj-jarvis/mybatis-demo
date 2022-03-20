package com.mrlu.mybatis.domain;

/**
 * @author Mr.Lu
 * @create 2021-02-07 14:37
 */
public class Student {

    private Integer id;
    private String  name;
    private String  email;
    private Integer age;

    //private EmpStatus empStatus = EmpStatus.LOGOUT;
    private MyEmpStatus empStatus = MyEmpStatus.LOGOUT;

    /*public EmpStatus getEmpStatus() {
        return empStatus;
    }*/

    public Student(String name, String email, Integer age, MyEmpStatus myEmpStatus) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.empStatus = myEmpStatus;
    }

    /*public void setEmpStatus(EmpStatus empStatus) {
        this.empStatus = empStatus;
    }*/

    public MyEmpStatus getMyEmpStatus() {
        return empStatus;
    }

    public void setMyEmpStatus(MyEmpStatus empStatus){
        this.empStatus = empStatus;
    }

    public Student() {
    }

    public Student(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
