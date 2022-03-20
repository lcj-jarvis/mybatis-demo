package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Mr.Lu
 * @create 2021-02-07 15:50
 */

public class TestStudentDao {
    @Test
    public void testQueryStudents() throws IOException {
        //访问mybatis读取Student参数
        //1、定义mybatis主配置文件的路径，用类路径的根开始(target/classes下开始)
        //String config = "mybatis.xml";
        //2、读取这个config表示的文件,使用org.apache.ibatis.io.Resources类
        //InputStream in = Resources.getResourceAsStream(config);
        //3、创建一个SqlSessionFactoryBuilder对象
        //SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4、创建SqlSessionFactory对象
        //SqlSessionFactory sqlSessionFactory = builder.build(in);
        //5、【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //6、【重要】指定要执行的sql语句的标识。
        // 标识的格式是：sql映射文件中的：namespace标签的属性值 + "." + 标签id的属性值
        //String sqlId = "com.mrlu.mybatis.dao.StudentDao" + "." + "queryStudents";
        String sqlId = "com.mrlu.mybatis.dao.StudentDao.queryStudents";
        //7、执行sql语句，通过sqlId找到语句
        List<Student> list = sqlSession.selectList(sqlId);
        //如果执行的是增删改就要手动提交事务
        //8、输出结果
        list.forEach(System.out::println);
        //9、关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void testInsertStudent() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //获取SqlSession对象。
        SqlSession sqlSession = factory.openSession();
        //获取到对应的sql语句
        String sqlId = "com.mrlu.mybatis.dao.StudentDao.insertStudent";
        Student student = new Student();
        student.setId(1004);
        student.setName("john");
        student.setEmail("john@qq.com");
        student.setAge(20);
        //执行sql语句
        int insert = sqlSession.insert(sqlId,student);

        //Mybatis默认不是自动提交事务的，所以在insert，update,delete后要手动提交事务。
        sqlSession.commit();
        //但是这样有一个缺陷，就是不能看到详细的信息。所以要在主配置文件中配置mybatis的日志。
        System.out.println(insert > 0 ? "执行成功":"执行失败");

        sqlSession.close();
    }
}