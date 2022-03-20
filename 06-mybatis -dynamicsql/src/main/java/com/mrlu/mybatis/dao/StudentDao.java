package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.type.Alias;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:03
 */
public interface StudentDao {

     //动态sql要是用java对象作为参数
     List<Student> selectStudentIf(Student student);

     //使用where标签
     List<Student> selectStudentWhere(Student student);

     //foreach使用1，List<Integer>
     List<Student> selectListOne(List<Integer> list);

     //foreach使用2，List<Integer>
     List<Student> selectListTwo(List<Student> list);

     //PageHelper进行分页
     List<Student> selectAll();
}
