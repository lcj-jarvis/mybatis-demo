package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
 * @author Mr.Lu
 * @create 2021-02-07 19:27
 */
public class TestStudentDao {
    @Test
    public void testSelectStudents(){
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println(studentDao.getClass().getName());//com.sun.proxy.$Proxy2
        //调用Dao的方法，执行数据库的操作
        List<Student> students = studentDao.selectStudents();
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        int lihua = studentDao.insertStudent(new Student(1014, "lihua", "lihua@qq.com", 20));
        sqlSession.commit();
        sqlSession.close();
        System.out.println(lihua);
    }
}
