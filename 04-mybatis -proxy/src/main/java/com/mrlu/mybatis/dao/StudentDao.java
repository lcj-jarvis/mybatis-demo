package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.ParamType;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:03
 */
public interface StudentDao {

    List<Student> selectStudents();
    int insertStudent(Student student);

    /**
     * 一个简单类型的参数
     *  简单类型：mybatis把java的基本数据类型和他们的包装类以及String都叫简单类型
     *  在mapper文件中获取简单类型的一个参数的值，使用#{任意字符}。可以理解成占位符？
     */
    Student selectStudentById(Integer id);

    /**
     * 多个参数，mybatis会做特殊处理
     *   多个参数被封装成一个map
     *      map的key：param1.....paramN
     *      map的value：就是传入参数的值
     *   #{} 就是从map中获取指定的key的值
     *
     */


    /**
     * 多个参数：命名参数，在形参定义的前面加上 @Param("自定义参数名称")
     *
     * 使用@Param注解明确指定封装参数是map的key。
     *   多个参数被封装成一个map
     *      map的key：使用@Param注解指定的值
     *      map的value：就是传入参数的值
     *   #{指定的key} 取出对应的属性值
     */
    List<Student> selectMultiParam(@Param("myName") String name,
                                   @Param("myAge")int age);


    /**
     * 多个参数，使用java对象的属性值，作为参数实际值
     */
    List<Student> selectMultiObject(ParamType paramType);

    //当然也可以传一个Student类型的对象
    List<Student> selectMultiStudent(Student student);


    /**
     * 多个参数-简单的类型，按位置传值
     * mybatis.3.4之前，使用#{0}，#{1};
     * 0和1对应方法形参的位置，从0开始
     * mybatis.3.4之后，使用#{arg0}，#{agr1}  从0开始
     *
     * #{param1}，#{param2} 从1开始
    */
    List<Student> selectMultiStudent2(String name,Integer age);

    /**
     *  多个参数使用Map
    */
    List<Student> selectMultiByMap(Map<String,Object> map);

    /**
     * 使用${} 字符串替换
     */
    List<Student> selectStudent$(@Param("name") String name);

    /**
     * 使用${},实现替换列名或者表名，完成不同的查询
     */
    List<Student> selectStudentByColumn(@Param("column")String column,
                                        @Param("value")String value);

    /**
     * 通过List集合里面的Student的id来查询Student
     * @param students
     * @return
     */
    Student selectStudentByList(List<Student> students);

}
