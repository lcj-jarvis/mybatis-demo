package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.EmployeeDaoCache;
import com.mrlu.mybatis.dao.EmployeeEhcacheDao;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-23 21:24
 */
public class EmployeeEhcacheDaoTest {

    /**
     * 测试第三方的缓存ehcache。
     * D:\软件\Cache\mybatis\ehcache 去这个文件夹看有没有数据，就知道有没有使用了
     */
    @Test
    public void getEmpById() {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmployeeEhcacheDao mapper1 = sqlSession1.getMapper(EmployeeEhcacheDao.class);
        EmployeeEhcacheDao mapper2 = sqlSession2.getMapper(EmployeeEhcacheDao.class);
        Employee emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();


        Employee emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        System.out.println(emp1==emp2);
        sqlSession2.close();

    }
}