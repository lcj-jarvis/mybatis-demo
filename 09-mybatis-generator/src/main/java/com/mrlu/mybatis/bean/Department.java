package com.mrlu.mybatis.bean;

public class Department {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dept.id
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dept.dept_Name
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private String deptName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dept.id
     *
     * @return the value of t_dept.id
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dept.id
     *
     * @param id the value for t_dept.id
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dept.dept_Name
     *
     * @return the value of t_dept.dept_Name
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dept.dept_Name
     *
     * @param deptName the value for t_dept.dept_Name
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}