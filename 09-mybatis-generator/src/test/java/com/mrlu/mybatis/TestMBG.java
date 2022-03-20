package com.mrlu.mybatis;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.bean.Employee;
import com.mrlu.mybatis.bean.EmployeeExample;
import com.mrlu.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-24 14:50
 */
public class TestMBG {

    @Test
    public void testCreat(){
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("src/main/resources/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                    callback, warnings);
            myBatisGenerator.generate(null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Mybatis3Simple简单版的测试
     */
   /* @Test
    public void testMybatis3Simple(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectAll();
        employees.forEach(System.out::println);
    }*/

   /**
     * Mybatis3复杂版的测试
     */
   @Test
   public void testMybatis3Simple(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();
       EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
       //查询所有的员工
       List<Employee> employees = mapper.selectByExample(null);
       employees.forEach(System.out::println);
       System.out.println("=================================");
       //xxxExample是封装查询条件的
       EmployeeExample employeeExample = new EmployeeExample();
       //创建一个Criteria。这个Criteria就是拼装sql的查询条件的
       EmployeeExample.Criteria criteria = employeeExample.createCriteria();
       //select id, last_Name, gender, email, deptId from t_employee WHERE ( last_Name like ? and gender = ? )
       criteria.andLastNameLike("%a%");
       criteria.andGenderEqualTo("1");
       List<Employee> employees1 = mapper.selectByExample(employeeExample);
       employees1.forEach(System.out::println);

       System.out.println("=================================");
       //select id, last_Name, gender, email, deptId from t_employee WHERE ( last_Name like ? and gender = ? ) or( email like ? )
       EmployeeExample.Criteria criteria1 = employeeExample.createCriteria();
       criteria1.andEmailLike("@qq.com");
       employeeExample.or(criteria1);
       List<Employee> employees2 = mapper.selectByExample(employeeExample);
       employees2.forEach(System.out::println);
   }
}
