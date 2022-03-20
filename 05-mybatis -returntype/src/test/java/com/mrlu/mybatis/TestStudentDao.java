package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.MyStudent;
import com.mrlu.mybatis.domain.ParamType;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Mr.Lu
 * @create 2021-02-07 19:27
 */
public class TestStudentDao {

    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.selectStudentById(1001);
        System.out.println(student);
        System.out.println(student);

        sqlSession.close();
    }

    @Test
    public void testSelectMultiParam(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = studentDao.selectMultiParam("jack", 20);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectParamType(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        /*
            mybatis把ResultSet指定列值赋给对象的同名属性。
	       【如果不是同名属性，无法赋值成功，对象的同名属性还要有相应的set方法
	       和get方法，以及无参构造】
        */
        ParamType paramType = studentDao.selectParamType("jack");
        System.out.println(paramType);
        sqlSession.close();
    }

    @Test
    public void testCountStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println(studentDao.countStudent());
        sqlSession.close();
    }

    @Test
    public void testSelectStuByNameLikeReturnMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //Map<Integer, Object> map = studentDao.selectStuByNameLikeReturnMap("%mr%");
        //lambda表达式遍历map
        Map<String, Object> map = studentDao.selectStuByNameLikeReturnMap("%mr%");
        map.forEach((id,student) -> System.out.println(id+"="+student));
    }

    @Test
    public void testSelectMapById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = studentDao.selectMapById(1001);
        map.forEach((id,student)-> System.out.println(id+"="+student));
        sqlSession.close();
    }

    @Test
    public void testSelectMyStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = studentDao.selectMyStudents();
        myStudents.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        String likeName = "%a%";
        List<Student> myStudents = studentDao.selectLikeOne(likeName);
        myStudents.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        String likeName = "a";
        List<Student> myStudents = studentDao.selectLikeTwo(likeName);
        myStudents.forEach(System.out::println);
        sqlSession.close();
    }
}
