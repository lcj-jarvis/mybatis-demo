package com.mrlu.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-24 16:38
 */
public class StudentDaoTest {

    /**
     * 插件原理
     * 在mybatis四大对象创建的时候。
     * 1、每个创建出来的对象不是直接返回的，而是
     *    interceptorChain.pluginAll(四大对象);
     * 2、获取到所有的Interceptor(拦截器)（插件需要实现的接口）
     *    调用interceptor.plugin(target);返回target包装后的对象
     * 3、插件机制，我们可以使用插件为目标对象创建一个代理对象：AOP(面向切面)
     *    我们的插件可以为四大对象创建出代理对象
     *    代理对象就可以拦截到四大对象的每一个执行
     * public Object pluginAll(Object target) {
     *     for (Interceptor interceptor : interceptors) {
     *       target = interceptor.plugin(target);
     *     }
     *     return target;
     *   }
     *
     *  插件的编写步骤：
     *  1、编写Interceptor接口的实现类
     *  2、使用@Intercepts注解和@Signature注解完成插件的签名
     *  3、将写好的插件注册到全局配置文件中
     *  例如：
     *     <plugins>
     *         <plugin interceptor="com.mrlu.mybatis.dao.MyFirstPlugin">
     *             <property name="username" value="root"/>
     *             <property name="password" value="123"/>
     *         </plugin>
     *     </plugins>
     */
    @Test
    public void testPlugin() {
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取接口的实现类
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        //通过插件修改了查询的结果
        Student student = mapper.getStudentById(1001);
        System.out.println(mapper.getClass());
        System.out.println(mapper.getClass().getName());
        System.out.println(student);
    }

    @Test
    public void testPageHelper01(){
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取接口的实现类
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        //第一页显示四条记录
        Page<Object> page = PageHelper.startPage(1, 4);
        //紧跟着的第一个select方法会被分页
        List<Student> list = mapper.queryStudents();
        list.forEach(System.out::println);

        System.out.println("当前页码："+page.getPageNum());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("每页的记录数："+page.getPageSize());
        System.out.println("总页码："+page.getPages());

    }

    @Test
    public void testPageHelper02(){
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取接口的实现类
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        //第一页显示四条记录
        Page<Object> page = PageHelper.startPage(2, 4);
        //紧跟着的第一个select方法会被分页
        List<Student> list = mapper.queryStudents();
        //用PageInfo对结果进行包装
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        //获取查询到的结果遍历
        pageInfo.getList().forEach(System.out::println);

        System.out.println("当前页码："+pageInfo.getPageNum());
        System.out.println("总记录数："+pageInfo.getTotal());
        System.out.println("每页的记录数："+pageInfo.getPageSize());
        System.out.println("总页码："+pageInfo.getPages());
        System.out.println("当前页开始的记录数："+pageInfo.getStartRow());
        System.out.println("当前页结束的记录数："+pageInfo.getEndRow());
        System.out.println("是否是第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一页："+pageInfo.isIsLastPage());
        System.out.println("是否有下一页："+pageInfo.isHasNextPage());
        System.out.println("是否有上一页："+pageInfo.isHasPreviousPage());

    }

    @Test
    public void testPageHelper03(){
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        //2、获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3、获取接口的实现类
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);

        //第一页显示四条记录
        Page<Object> page = PageHelper.startPage(4, 2);
        //紧跟着的第一个select方法会被分页
        List<Student> list = mapper.queryStudents();

        //用PageInfo对结果进行包装
        //传入要连续显示多少页。这里表示连续显示5页
        PageInfo<Student> pageInfo = new PageInfo<>(list,5);
        //
        list.forEach(System.out::println);

        System.out.println("总页码："+pageInfo.getPages());
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        System.out.println("连续显示的页码：");
        for (int i = 0; i < navigatepageNums.length; i++) {
            System.out.println(navigatepageNums[i]);
        }
    }
}