package com.mrlu.mybatis;

import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.dao.impl.StudentDaoImpl;
import com.mrlu.mybatis.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:27
 */
public class TestStudentDao {
    @Test
    public void testSelectStudents(){
        StudentDao studentDao = new StudentDaoImpl();
        List<Student> students = studentDao.selectStudents();
        students.forEach(System.out::println);
        /*
        但是这种方式StudentDaoImpl有很多重复的部分
        所以要进行优化。这个由mybatis完成。
        */
        /**
         * List<Student> students = studentDao.selectStudents();调用
         *  1、dao对象，类型是StudentDao，全类名是com.mrlu.mybatis.StudentDao
         *     全类名和namespace一致。全类名通过反射可以获取
         *  2、方法名称，selectStudents，这个方法就是mapper文件中的id值selectStudents
         *
         *  3、通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *     如果返回值是List，调用的是SqlSession.selectList()方法
         *     如果返回值int，或是非List类型，看mapper文件中的标签是<insert>,<update>就会
         *     调用SqlSession的insert，update等方法
         *
         *   mybatis的动态代理：mybatis根据dao的方法调用，获取运行sql语句的信息
         *     mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象
         *     完成SqlSession调用方法，访问数据库
         *
         *
         *   见03-mybatis-proxy模块优化
         */

    }

    @Test
    public void testinsertStudent(){
        StudentDao studentDao = new StudentDaoImpl();
        Student student = new Student(1005,"marry","marry@qq.com",20);
        int i = studentDao.insertStudent(student);
        System.out.println(i);

    }
}
