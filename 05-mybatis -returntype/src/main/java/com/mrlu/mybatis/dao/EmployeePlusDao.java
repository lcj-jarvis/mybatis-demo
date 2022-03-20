package com.mrlu.mybatis.dao;


import com.mrlu.mybatis.domain.Employee;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 20:05
 */
public interface EmployeePlusDao {
    /**
     * resultMap的测试
     * @param id
     * @return
     */
    Employee getEmpById(Integer id);

    /**
     * 查询员工和对应的部门
     * @param id
     * @return
     */
    Employee getEmpAndDept(Integer id);

    /**
     * 用于测试association分步查询
     * @param id
     * @return
     */
    Employee getEmpByStep(Integer id);

    /**
     * 分步查询部门和部门对应的所有员工
     * @param deptId
     * @return
     */
    Employee getEmpAndDeptByStep(Integer deptId);

    /**
     * 使用鉴别器【了解】
     * @param deptId
     * @return
     */
    Employee getEmpByDisc(Integer deptId);
}
