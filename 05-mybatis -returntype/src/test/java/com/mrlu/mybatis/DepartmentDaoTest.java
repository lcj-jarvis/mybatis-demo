package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.DepartmentDao;
import com.mrlu.mybatis.domain.Department;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 22:41
 */
public class DepartmentDaoTest {

    @Test
    public void testGetDeptByIdPlus() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department dept = mapper.getDeptByIdPlus(1);
        System.out.println(dept);
        List<Employee> emps = dept.getEmps();
        emps.forEach(System.out::println);
        sqlSession.close();

    }

    @Test
    public void  testGetEmpAndDeptByStep() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        DepartmentDao mapper = sqlSession.getMapper(DepartmentDao.class);
        Department dept = mapper.getDeptByStep(1);
        System.out.println(dept);
        List<Employee> emps = dept.getEmps();
        emps.forEach(System.out::println);
        sqlSession.close();
    }
}