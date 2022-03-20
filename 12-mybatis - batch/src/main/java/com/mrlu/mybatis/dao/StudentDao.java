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

    /**
     * 批量插入多个学生
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 用查看源码
     * @param id
     * @return
     */
    Student getStudentById(Integer id);

    boolean insertStudentEnum(Student student);

    boolean insertStuDefineEnumHandler(Student student);

    Student getStudentByIdEnum(Integer id);
}
