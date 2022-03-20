package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.EmpStatus;
import com.mrlu.mybatis.domain.MyEmpStatus;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-26 14:50
 */
public class StudentDaoTest {

    @Test
    public void insertStudent() {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //批量：预编译sql一次==》设置参数===10000次 ====》执行（一次）
        //执行总豪秒：3405ms
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        //非批量：（预编译参数==》设置参数==》执行）10000次
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        long begin  = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            mapper.insertStudent(new Student(UUID.randomUUID().toString().substring(0,6),
                    "b"+i+"@qq.com",i));
        }
        sqlSession.commit();
        long end = System.currentTimeMillis();

        System.out.println("执行总豪秒："+(end-begin)+"ms");
    }


    /**
     * 默认mybatis在处理枚举对象的时候保存的是枚举的名字：EnumTypeHandler
     * 改变使用EnumOrdinalTypeHandler,保存的是枚举的索引
     * 在mybatis的主配置文件中加入以下配置
     *     <typeHandlers>
     *         <typeHandler handler="org.apache.ibatis.type.EnumOrdinalTypeHandler"
     *                      javaType="com.mrlu.mybatis.domain.EmpStatus"></typeHandler>
     *     </typeHandlers>
     */
    @Test
    public void testEnum(){
        EmpStatus login = EmpStatus.Login;
        System.out.println("枚举的索引："+login.ordinal());
        System.out.println("枚举的名字："+login.name());
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //boolean jack = mapper.insertStudentEnum(new Student("jack", "jack@qq.com", 25));
        boolean mary = mapper.insertStudentEnum(new Student("mary", "mary@qq.com", 25));
        //System.out.println(jack);
        System.out.println(mary);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试自定义类型的枚举处理器。初始数据库中保存的就是枚举类型的状态码
     */
    @Test
    public void testDefineEnumHandler(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = new Student("mike", "mike@qq.com", 25, MyEmpStatus.Login);
        boolean isTrue = mapper.insertStuDefineEnumHandler(student);
        System.out.println(isTrue);
        System.out.println(student.getMyEmpStatus().getMessage());
        sqlSession.commit();
        System.out.println("=================================");
        Student mike = mapper.getStudentByIdEnum(3);
        System.out.println(mike.getMyEmpStatus());
        sqlSession.close();

    }

    @Test
    public void testGetResult(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student mike = mapper.getStudentByIdEnum(3);
        System.out.println(mike.getMyEmpStatus());
        sqlSession.close();
    }
}