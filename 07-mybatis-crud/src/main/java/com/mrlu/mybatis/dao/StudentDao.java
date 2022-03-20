package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.MyStudent;
import com.mrlu.mybatis.domain.Student;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-08 20:20
 */
public interface StudentDao {

    //查询所有的学生列表
    List<Student> selectStudents();

    //查询学生的总人数
    int selectCount();

    //查询学生的信息
    Student selectStudent(Integer id);

    //添加学生
    int insertStudent(Student student);

    //删除学生
    int deleteStudent(Integer id);

    //修改学生信息
    int updateStudent(Student student);

    //批量插入学生信息
    int insertStudentBatch(List<Student> list);

    //返回其他的类型
    List<MyStudent> selectOtherType();
}
