package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.MyStudent;
import com.mrlu.mybatis.domain.ParamType;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:03
 */
public interface StudentDao {

    Student selectStudentById(Integer id);

    List<Student> selectMultiParam(@Param("name") String name, @Param("age")int age);

    ParamType selectParamType(@Param("name") String name);

    //返回总的记录数
    int countStudent();


    /**
     *   多条记录封装成一个map，Map<Integer, Object>:may的key是这条记录的主键，
     *   value是封装记录后的javaBean
     *   @MapKey("id") 告诉mybatis封装这个map的时候使用哪个属性作为map的key
     * @param likeName 模糊查询的名字
     * @return
     */
   /* @MapKey("id")
    Map<Integer, Object> selectStuByNameLikeReturnMap(String likeName);*/

   /**
     * 使用name字段作为map的key
     */
    @MapKey("name")
    Map<String, Object> selectStuByNameLikeReturnMap(String likeName);

    /**
     *  返回一个map类型
     *  返回一条记录的map，key就是列名，值就是对应的值
     */
    @MapKey("id")
    Map<Object,Object>  selectMapById(Integer id);


    /**
     * 使用resultMap定义映射关系
     */
    List<MyStudent> selectMyStudents();

    /**
     * 第一种方式实现模糊查询，在java代码指定like的内容
    */
    List<Student> selectLikeOne(String likeName);

    /**
     * 第二种方式实现模糊查询，在mapper的sql语句中拼接likeName的内容
     *   如：select  * from  student where  name like "%" #{likeName} "%"
     */
    List<Student> selectLikeTwo(String likeName);

}
