package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Student;

import java.util.List;

/**
 * @author Mr.Lu
 * @create 2021-02-07 14:39
 */
public interface StudentDao {

    //查询Student表中所有的数据
    List<Student> queryStudents();
    //插入一个学生
    int insertStudent(Student student);

    /**
     * 用查看源码
     * @param id
     * @return
     */
    Student getStudentById(Integer id);
}
