package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-22 12:47
 */
public interface StudentDaoAnnotation {

    /**
     * 没有sql映射文件，所有的sql都是利用注解写在接口上
     * @return 返回包含所有学生的接口
     */
    @Select("select * from  select * from student order by id")
    List<Student> selectStudents();
}
