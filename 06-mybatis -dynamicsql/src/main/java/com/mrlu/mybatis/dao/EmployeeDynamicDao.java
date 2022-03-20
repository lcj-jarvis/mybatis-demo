package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-23 11:35
 */
public interface EmployeeDynamicDao {

    /**
     * if标签和where标签的测试
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionIf(Employee employee);

    /**
     * if标签和trim标签的测试
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionTrim(Employee employee);

    /**
     * choose标签的测试
     * @param employee
     * @return
     */
    List<Employee> getEmpsByConditionChoose(Employee employee);

    /**
     * 使用set标签和trim标签完成更新
     * @param employee
     * @return
     */
    boolean updateEmps(Employee employee);

    /**
     * foreach标签的使用
     * @param ids
     * @return
     */
    List<Employee> getEmpsByConditionForeach(/*@Param("ids")*/List<Integer> ids);

    /**
     * foreach标签遍历map集合
     * @param ids
     * @return
     */
    List<Employee> getEmpsByConditionForeachMap(@Param("map") Map<String, Integer> ids);

    /**
     * 批量插入
     * @param employees
     * @return
     */
    boolean addEmps(@Param("employees") List<Employee> employees);

    /**
     * 测试内置的两个参数_parameter、_databaseId和bind标签
     * @param employee
     * @return
     */
    List<Employee> getEmpTestInnerParameter(Employee employee);
}
