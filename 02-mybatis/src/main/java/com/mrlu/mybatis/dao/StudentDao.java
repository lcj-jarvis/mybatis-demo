package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Student;

import java.util.List;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:03
 */
public interface StudentDao {

    List<Student> selectStudents();
    int insertStudent(Student student);
}
