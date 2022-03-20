package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Employee;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-23 21:06
 */
public interface EmployeeEhcacheDao {
    /**
     *
     * @param id
     * @return
     */
    Employee getEmpById(Integer id);

    int addEmployee(Employee employee);
}
