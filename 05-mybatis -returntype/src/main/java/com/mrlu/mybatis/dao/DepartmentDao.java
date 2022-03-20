package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Department;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 21:30
 */
public interface DepartmentDao {

    /**
     * 用于测试association的分步查询
     * @param id
     * @return
     */
    Department getDeptById(Integer id);

    /**
     * 查询部门的时候，顺便把所有员工的信息查询出来
     * @param id
     * @return
     */
    Department getDeptByIdPlus(Integer id);

    /**
     * 分步查询部门及所有的员工
     * @param id
     * @return
     */
    Department getDeptByStep(Integer id);

}
