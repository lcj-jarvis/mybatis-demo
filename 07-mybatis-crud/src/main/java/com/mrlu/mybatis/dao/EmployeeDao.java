package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Employee;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 13:24
 */
public interface EmployeeDao {
    /**
     * 查询所有的员工
     * @return
     */
    List<Employee> selectEmployees();

    /**
     * 测试增删值
     * 1、mybatis允许增删改直接定义以下类型的返回
     *  Integer，Long,Boolean，void 以及对应的包装类
     * 2、我们需要手动提交数据
     *  sqlSessionFactory.openSession() ==> 手动提交
     *  sqlSessionFactory.openSession(true) ==> 自动提交
     * @param employee
     * @return 返回受影响的行数
     */
    int addEmployee(Employee employee);

    /**
     * 删除员工，true表示删除成功，false表示删除失败
     * @param id
     * @return
     */
    boolean deleteEmployee(Integer id);

    /**
     * 修改员工
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);
}
