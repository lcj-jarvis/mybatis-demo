package com.mrlu.mybatis;


import com.github.pagehelper.PageHelper;
import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:27
 */
public class TestStudentDao {

   @Test
    public void testSelectStudentIf(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
       StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
       Student student = new Student();
     //  student.setName("jack");
       student.setAge(18);
       List<Student> list = studentDao.selectStudentIf(student);
       list.forEach(System.out::println);
       sqlSession.close();
   }

   @Test
   public void testSelectStudentWhere(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
      Student student = new Student();
      //student.setName("jack");
      student.setAge(18);
      List<Student> list = studentDao.selectStudentWhere(student);
      list.forEach(System.out::println);
      sqlSession.close();
   }

   @Test
   public void testFor(){
      List<Integer> list = new ArrayList<>();
      list.add(1001);
      list.add(1002);
      list.add(1003);

      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select * from student where id in(");
      for (Integer i:list) {
         stringBuilder.append(i+",");
      }
      stringBuilder.deleteCharAt(stringBuilder.length()-1);
      stringBuilder.append(")");
      System.out.println(stringBuilder);

   }

   @Test
   public void testSelectListOne(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
      List<Integer> list = new ArrayList<>();
      list.add(1001);
      list.add(1002);
      list.add(1003);

      List<Student> stulist = studentDao.selectListOne(list);
      stulist.forEach(System.out::println);
      sqlSession.close();
   }

   @Test
   public void testSelectListTwo(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

      List<Student> list = new ArrayList<>();
      Student student0 = new Student();
      student0.setId(1001);
      list.add(student0);
      Student student1 = new Student();
      student1.setId(1002);
      list.add(student1);
      Student student2 = new Student();
      student2.setId(1003);
      list.add(student2);

      List<Student> stulist = studentDao.selectListTwo(list);
      stulist.forEach(System.out::println);
      sqlSession.close();
   }

   @Test
   public void testSelectStudentsByPageHelper(){
      SqlSession sqlSession = MybatisUtils.getSqlSession();
      StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
      /*
        加入PageHelper的方法，分页
        startPage(int pageNum, int pageSize)
        pageNum：第几页，从1开始
        pageSize:一页中有多少行数据
      */
      PageHelper.startPage(3,3);
      List<Student> list = studentDao.selectAll();
      list.forEach(System.out::println);
      sqlSession.close();
   }
}
