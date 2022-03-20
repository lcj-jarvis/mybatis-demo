package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDaoAnnotation;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 12:51
 */
public class StudentDaoAnnotationTest {

    @Test
    public void selectStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDaoAnnotation mapper = sqlSession.getMapper(StudentDaoAnnotation.class);
        mapper.selectStudents();
        sqlSession.close();
    }
}
