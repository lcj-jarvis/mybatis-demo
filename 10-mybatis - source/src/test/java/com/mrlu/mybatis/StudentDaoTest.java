package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-24 16:38
 */
public class StudentDaoTest {

    /**
     * 1、获取sqlSessionFactory对象
     *    解析文件的每一个信息保存在Configuration中，
     *    返回包含Configuration的DefaultSqlSessionFactory
     * 2、获取SqlSession对象
     *     返回一个DefaultSqlSession，包含Executor和Configuration
     *     这一步会创建一个Executor对象
     *
     * 3、获取接口的代理对象（MapperProxy）
     *      getMapper，使用MapperProxyFactory创建于一个MapperProxy的代理对象
     *      代理对象里面包含了DefaultSqlSession(Executor)
     *
     *  4、执行增删改查方法:
     *     (1)调用DefaultSqlSession的增删改查(Executor：实际上是CachingExecutor执行)
     *     (2)会创建一个StatementHandler接口的实现类RoutingStatementHandler。
     *         RoutingStatementHandler有一个StatementHandler类型的属性delegate。
     *         delegate属性保存的对象是PreparedStatementHandler。【默认情况下】
     *          PreparedStatementHandler有两个属性：
     *          ResultSetHandler resultSetHandler;  【处理结果】
     *          ParameterHandler parameterHandler;  【处理参数】
     *        （同时也会创建出）
     *     (3) 调用StatementHandler预编译参数以及设置方法参数的值
     *         使用ParameterHandler类给sql语句设置参数
     *     (4) 调用StatementHandler的增删查方法
     *     (5) ResultSetHandler封装结果集合
     *
     *     注意四大对象：
     *     Executor
     *     StatementHandler
     *     ParameterHandler
     *     ResultSetHandler
     *     都有一个
     *      interceptorChain.pluginAll(四大对象)包装的方法
     *
     */
    @Test
    public void getStudentById() {
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取接口的实现类
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.getStudentById(1001);
        System.out.println(mapper.getClass());
        System.out.println(mapper.getClass().getName());
        System.out.println(student);

    }
}