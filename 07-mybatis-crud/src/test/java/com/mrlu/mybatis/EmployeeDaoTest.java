package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.EmployeeDao;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 13:39
 */
public class EmployeeDaoTest {

    @Test
    public void selectEmployees() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        List<Employee> employees = mapper.selectEmployees();
        employees.forEach(System.out::println);
    }

    @Test
    public void addEmployee() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(null,"marry","1","marry@qq.com");

        mapper.addEmployee(employee);
        sqlSession.commit();
        System.out.println("获取到的自增的主键值是："+employee.getId());
        sqlSession.close();
    }

    @Test
    public void deleteEmployee() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        boolean isTrue = mapper.deleteEmployee(4);
        sqlSession.commit();
        System.out.println(isTrue?"删除成功":"删除失败");
        sqlSession.close();
    }

    @Test
    public void updateEmployee() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee employee = new Employee(1,"jackson","0","jack@qq.com");
        int i = mapper.updateEmployee(employee);
        System.out.println(i);
        sqlSession.commit();
        sqlSession.close();
    }
}