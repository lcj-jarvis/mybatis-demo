package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 15:32
 */
public interface EmployeeDao {

    /**
     * 测试传参的过程
     * @param id
     * @param lastName
     * @return
     */
    Employee getEmpByIdAndLastName(@Param("id") Integer id,
                                   @Param("lastName") String lastName);
}
