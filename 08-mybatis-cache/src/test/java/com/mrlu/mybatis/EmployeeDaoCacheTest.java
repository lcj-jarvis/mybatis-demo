package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.DepartmentDaoCache;
import com.mrlu.mybatis.dao.EmployeeDaoCache;
import com.mrlu.mybatis.domain.Department;
import com.mrlu.mybatis.domain.Employee;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-23 16:56
 */
public class EmployeeDaoCacheTest {


    /*
      两级缓存：
      一级缓存(本地缓存):sqlSession级别的缓存，一级缓存是一直开启的
         与数据库同一次会话期间查询到的数据会放到本地缓存中。
         以后如果需要获取相同的数据，直接从缓存中拿，没必要再去查询数据库

         一级缓存失效的情况（没有使用到当前一级缓存的情况，效果就是，还需要再向数据库发出查询）
         1、不同的数据库连接，且sqlSession不同
         2、sqlSession相同，查询条件不同（当前一级缓存中还没有这个数据）
         3、sqlSession相同，两次查询之间执行了增删改操作(这次操作可能对当前数据有影响)
         4、sqlSession相同，手动清除了一级缓存（缓存清空）

      二级缓存(全局缓存):基于namespace级别的缓存，一个namespace对应一个二级缓存
        工作机制：
        1、一个会话，查询一条数据，这个数据就会被放到会话的一级缓存中
        2、如果会话关闭：一级缓存中的数据会被保存到二级缓存中，新的会话查询信息，就可以
           参照二级缓存中的内容。
        3、sqlSession===EmployeeMapper===》Employee
                        DepartmentMapper===》Department
           不同namespace查出的数据会放到自己对应的缓存中（map）
           效果：数据会从二级缓存中获取
              命中二级缓存Cache Hit Ratio [com.mrlu.mybatis.dao.EmployeeDaoCache]: 0.5

           【注意*****】查出的数据都会默认先放在一级缓存中
                  只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中
        使用二级缓存的步骤：
        1、在mybatis的配置文件中开启二级缓存配置
            <setting name="cacheEnabled" value="true"/>

        2、在sql映射文件中，配置使用二级缓存
            <cache></cache>
        3、我们的POJO需要实现序列化接口

        和缓存有关的设置/属性：
           (1)cacheEnabled=true:false 关闭缓存(关闭二级缓存，一级缓存一直可用)
           (2)每个select标签都默认配置有useCache="true"
                 设置为false：会覆盖掉cacheEnabled=true，不使用缓存【一级缓存依然使用，二级缓存不使用】

    【重点***】（3）每个增删改标签都默认配有：flushCache="true" 【表示一二级缓存都会清除】
               增删改完成之后就会清除缓存
               测试：flushCache="true" ，一二级缓存都会清空
               查询标签：flushCache="false"【默认设置】
                     如果：flushCache="true"每次查询都会清空缓存，缓存是没有被使用的
           (4)sqlSession.clearCache();只是清除当前sqlSession的一级缓存
           (5)localCacheScope：
                 【在mybatis的配置文件中配置】
                 默认值为 SESSION，会缓存一个会话中执行的所有查询。
                 若设置值为 STATEMENT：禁用一级缓存,不会禁用二级缓存
    */
    @Test
    public void testFirstLevelCache() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        EmployeeDaoCache mapper = sqlSession.getMapper(EmployeeDaoCache.class);
        Employee emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        Employee emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
        System.out.println(emp1 == emp2);

        System.out.println("=================");
        //1、不同的数据库连接，且sqlSession不同
        EmployeeDaoCache mapper3 = MybatisUtils.getSqlSessionFactory().openSession().getMapper(EmployeeDaoCache.class);
        EmployeeDaoCache mapper4 = MybatisUtils.getSqlSessionFactory().openSession().getMapper(EmployeeDaoCache.class);
        //这样就是相同的。因为使用同一个连接
        /* EmployeeDao mapper3 = sqlSession.getMapper(EmployeeDao.class);
        EmployeeDao mapper4 = sqlSession.getMapper(EmployeeDao.class);*/
        System.out.println(mapper3);
        System.out.println(mapper4);
        Employee emp3 = mapper3.getEmpById(2);
        Employee emp4 = mapper4.getEmpById(2);
        //false
        System.out.println(emp3 == emp4);
        System.out.println("=================");
        //2、sqlSession相同，查询条件不同（当前一级缓存中还没有这个数据）
        Employee emp5 = mapper.getEmpById(3);
        Employee emp6 = mapper.getEmpById(4);
        //false
        System.out.println(emp5 == emp6);
        System.out.println("=================");
        //3、sqlSession相同，两次查询之间执行了增删改操作(这次操作可能对当前数据有影响)
        Employee emp7 = mapper.getEmpById(3);
        mapper.addEmployee(new Employee(null, "jackson", "1", "jackson@qq.com", new Department(1)));
        Employee emp8 = mapper.getEmpById(3);
        System.out.println(emp7 == emp8);
        System.out.println("=================");
        // 4、sqlSession相同，手动清除了一级缓存（缓存清空）
        Employee emp9 = mapper.getEmpById(5);
        sqlSession.clearCache();
        Employee emp10 = mapper.getEmpById(5);
        System.out.println(emp9 == emp10);

        sqlSession.close();

    }

    /**
     * 配合下面的测试二级缓存的属性
     */
    @Test
    public void testCacheAttribute(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeDaoCache mapper = sqlSession.getMapper(EmployeeDaoCache.class);
        Employee emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        //用于测试flushCache属性。不用提交
        //mapper.addEmployee(new Employee(null, "smith", "1", "smith@qq.com", new Department(2)));

        Employee emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
        System.out.println(emp1 == emp2);
    }
    /**
     * 测试二级缓存
     */
    @Test
    public void testSecondLevelCache() {
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        EmployeeDaoCache mapper1 = sqlSession1.getMapper(EmployeeDaoCache.class);
        EmployeeDaoCache mapper2 = sqlSession2.getMapper(EmployeeDaoCache.class);
        Employee emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        sqlSession1.close();

        //用于测试flushCache属性。不用提交
        //mapper2.addEmployee(new Employee(null, "allen", "1", "allen@qq.com", new Department(1)));

        //只是清除一级缓存，二级缓存不会清除
        sqlSession2.clearCache();

        //命中二级缓存Cache Hit Ratio [com.mrlu.mybatis.dao.EmployeeDaoCache]: 0.5
        Employee emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);
        //因为配置了 readOnly="false"。所以下面的结果返回false
        //<cache eviction="FIFO" flushInterval="60000" readOnly="false" size="1024"></cache>
        System.out.println(emp1==emp2);

        //如果在这里关闭就不能命中缓存
        /*查出的数据都会默认先放在一级缓存中
        只有会话提交或者关闭以后，一级缓存中的数据才会转移到二级缓存中*/
        //sqlSession1.close();
        sqlSession2.close();


    }

    /**
     * 测试没有开启二级缓存的情况
     */
    @Test
    public void testDepartmentDaoCache(){
        SqlSessionFactory sqlSessionFactory = MybatisUtils.getSqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        DepartmentDaoCache mapper1 = sqlSession1.getMapper(DepartmentDaoCache.class);
        DepartmentDaoCache mapper2 = sqlSession2.getMapper(DepartmentDaoCache.class);
        Department dept1 = mapper1.getDeptById(1);
        System.out.println(dept1);
        sqlSession1.close();
        Department dept2 = mapper2.getDeptById(1);
        System.out.println(dept2);
        sqlSession2.close();

    }

}