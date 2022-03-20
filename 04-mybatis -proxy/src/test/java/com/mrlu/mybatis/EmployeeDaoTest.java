package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.EmployeeDao;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 15:37
 */
public class EmployeeDaoTest {

    @Test
    public void getEmpByIdAndLastName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
        Employee jack = mapper.getEmpByIdAndLastName(1, "jack");
        System.out.println(jack);
    }
}