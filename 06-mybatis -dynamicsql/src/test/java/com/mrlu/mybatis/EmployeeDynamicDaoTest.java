package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.EmployeeDynamicDao;
import com.mrlu.mybatis.domain.Department;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-23 11:51
 */
public class EmployeeDynamicDaoTest {

    @Test
    public void testGetEmpsByConditionIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        //Employee employee = new Employee(2,"%a%",null,null);
        Employee employee = new Employee(null,"%a%",null,null);
        /*用于测试where标签的and在后面处理的情况*/
        List<Employee> emps = mapper.getEmpsByConditionIf(employee);
        System.out.println(emps);
        sqlSession.close();
    }

    @Test
    public void testGetEmpsByConditionTrim() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        Employee employee = new Employee(2,"%a%",null,null);
        List<Employee> emps = mapper.getEmpsByConditionTrim(employee);
        System.out.println(emps);
        sqlSession.close();
    }

    @Test
    public void testGetEmpsByConditionChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        Employee employee = new Employee(2,"%a%",null,null);
        //Employee employee = new Employee(null,"%a%",null,null);
        //Employee employee = new Employee();
        List<Employee> emps = mapper.getEmpsByConditionChoose(employee);
        System.out.println(emps);
        sqlSession.close();
    }

    @Test
    public void testUpdateEmps(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        //测试set标签
        //Employee employee = new Employee(3,"lucy",null,null);
        Employee employee = new Employee(3,"lucy",null,"lucy@qq.com");
        boolean isTrue = mapper.updateEmps(employee);
        System.out.println(isTrue);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testGetEmpsByConditionForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        List<Employee> emps = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3));
        emps.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testGetEmpsByConditionForeachMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        List<Employee> emps = mapper.getEmpsByConditionForeachMap(map);
        emps.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testAddEmps(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);
        Employee employee1= new Employee(null,"lihua","1","lihua@qq.com",new Department(1));
        Employee employee2= new Employee(null,"aabb","1","aabb@qq.com",new Department(2));
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        boolean isAddTrue = mapper.addEmps(employees);
        System.out.println(isAddTrue);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void testGetEmpTestInnerParameter(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDynamicDao mapper = sqlSession.getMapper(EmployeeDynamicDao.class);

        Employee employee= new Employee(null,"%a%","1",null,null);
        //测试binder标签
        //Employee employee= new Employee(null,"a","1",null,null);
        List<Employee> employees = mapper.getEmpTestInnerParameter(employee);
        employees.forEach(System.out::println);
        sqlSession.close();

    }
}