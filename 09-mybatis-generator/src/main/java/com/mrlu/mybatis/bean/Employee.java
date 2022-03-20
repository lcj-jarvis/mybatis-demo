package com.mrlu.mybatis.bean;

public class Employee {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_employee.id
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_employee.last_Name
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_employee.gender
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private String gender;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_employee.email
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_employee.deptId
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    private Integer deptid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_employee.id
     *
     * @return the value of t_employee.id
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_employee.id
     *
     * @param id the value for t_employee.id
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_employee.last_Name
     *
     * @return the value of t_employee.last_Name
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_employee.last_Name
     *
     * @param lastName the value for t_employee.last_Name
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_employee.gender
     *
     * @return the value of t_employee.gender
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_employee.gender
     *
     * @param gender the value for t_employee.gender
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_employee.email
     *
     * @return the value of t_employee.email
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_employee.email
     *
     * @param email the value for t_employee.email
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_employee.deptId
     *
     * @return the value of t_employee.deptId
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public Integer getDeptid() {
        return deptid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_employee.deptId
     *
     * @param deptid the value for t_employee.deptId
     *
     * @mbg.generated Wed Feb 24 16:05:19 CST 2021
     */
    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", deptid=" + deptid +
                '}';
    }
}