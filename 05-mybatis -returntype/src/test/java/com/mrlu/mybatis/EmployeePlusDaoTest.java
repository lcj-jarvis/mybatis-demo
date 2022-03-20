package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.EmployeePlusDao;
import com.mrlu.mybatis.domain.Department;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 20:19
 */
public class EmployeePlusDaoTest {

    @Test
    public void testGgetEmpById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeePlusDao mapper = sqlSession.getMapper(EmployeePlusDao.class);
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee);
        sqlSession.close();
    }

    @Test
    public void testGetEmpAndDept() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeePlusDao mapper = sqlSession.getMapper(EmployeePlusDao.class);
        Employee employee = mapper.getEmpAndDept(1);
        Department department = employee.getDepartment();
        System.out.println(department);
        System.out.println(employee);
        sqlSession.close();
    }

    @Test
    public void testGetEmpByStep() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeePlusDao mapper = sqlSession.getMapper(EmployeePlusDao.class);
        Employee empByStep = mapper.getEmpByStep(1);
        //按需加载，没有使用department的属性,看控制台的日志发现只执行了一条sql
        System.out.println(empByStep.getLastName());
        //按需加载，没有使用department的属性,看控制台的日志发现只执行了两条sql
        System.out.println(empByStep.getDepartment());
        sqlSession.close();
    }

    @Test
    public void testGetEmpByDisc() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeePlusDao mapper = sqlSession.getMapper(EmployeePlusDao.class);
        //男生
        //Employee employee = mapper.getEmpByDisc(1);
        //女生
        Employee employee = mapper.getEmpByDisc(2);
        System.out.println(employee);
        System.out.println(employee.getDepartment());
    }
}