package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.ParamType;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        int lihua = studentDao.insertStudent(new Student(1006, "lihua", "lihua@qq.com", 20));
        sqlSession.commit();
        sqlSession.close();
        System.out.println(lihua);
    }


    @Test
    public void testSelectStudentById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.selectStudentById(1001);
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
    public void testSelectMultiObject(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        ParamType paramType = new ParamType("jack",28);
        List<Student> list = studentDao.selectMultiObject(paramType);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("jack");
        student.setAge(28);
        List<Student> list = studentDao.selectMultiStudent(student);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = studentDao.selectMultiStudent2("jack",28);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectMultiByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("stuName","jack");
        map.put("stuId",1001);
        List<Student> list = studentDao.selectMultiByMap(map);
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectStudent$(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //注意，因为是进行sql语句的拼接。所以要有 ''
        List<Student> list = studentDao.selectStudent$("'李四'");
        //这种方式存在sql注入问题
        //List<Student> list = studentDao.selectStudent$("'李四' or age = 20");

        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectStudentByColumn(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        //按照id列进行查找
       // List<Student> list = studentDao.selectStudentByColumn("id", "1001");
        //查找age列进行查找
        //List<Student> list = studentDao.selectStudentByColumn("age", "20");
        //按照姓名列进行查找
        List<Student> list = studentDao.selectStudentByColumn("name", "jack");
        list.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectStudentByList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student1 = new Student();
        student1.setId(1001);
        Student student2 = new Student();
        student2.setId(1002);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        Student student = mapper.selectStudentByList(list);
        System.out.println(student);
    }
}
