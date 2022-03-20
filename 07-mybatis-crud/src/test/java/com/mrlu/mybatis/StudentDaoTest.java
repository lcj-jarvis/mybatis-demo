package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.MyStudent;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-08 20:35
 */
public class StudentDaoTest {

    @Test
    public void selectStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = studentDao.selectStudents();
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectCount() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("学生的总人数"+studentDao.selectCount());
        sqlSession.close();
    }

    @Test
    public void selectStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.selectStudent(1001);
        System.out.println(student);
        sqlSession.close();

    }

    /**
     * 增删改完之后，都要手动提交事务
     */
    @Test
    public void insertStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1007,"aabb","aabb@qq.com",30);
        int i = studentDao.insertStudent(student);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void deleteStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        int i = studentDao.deleteStudent(1007);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void updateStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1007,"pdd","pdd@qq.com",28);
        int i = studentDao.updateStudent(student);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }


    @Test
    public void insertStudentBatch() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student1 = new Student(1008,"mrlu1","mrlu1@qq.com",23);
        Student student2 = new Student(1009,"mrlu2","mrlu2@qq.com",24);
        Student student3 = new Student(1010,"mrlu3","mrlu3@qq.com",25);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);

        int i = studentDao.insertStudentBatch(list);
        sqlSession.commit();
        System.out.println(i);
        sqlSession.close();
    }

    @Test
    public void selectOtherType(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> myStudents = studentDao.selectOtherType();
        myStudents.forEach(System.out::println);
        sqlSession.close();
    }
}
