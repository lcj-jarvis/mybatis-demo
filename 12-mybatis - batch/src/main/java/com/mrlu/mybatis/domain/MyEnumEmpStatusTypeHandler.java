package com.mrlu.mybatis.domain;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举类型的处理器。或者继承BaseTypeHandler
 * TypeHandler中的泛型，表示处理的类型
 * 然后还要在mybatis的配置文件中注册。
 *  <typeHandlers>
 *         <typeHandler handler="com.mrlu.mybatis.domain.MyEnumEmpStatusTypeHandler"
 *                      javaType="com.mrlu.mybatis.domain.MyEmpStatus"></typeHandler>
 *  </typeHandlers>
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-26 16:29
 */
public class MyEnumEmpStatusTypeHandler implements
        TypeHandler<MyEmpStatus> {

    /**
     * 定义当前数据是如何保存到数据库中的
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, MyEmpStatus parameter, JdbcType jdbcType) throws SQLException {
        //保存枚举的状态码到数据库中
        System.out.println("要保存的状态码："+parameter.getCode());
        ps.setString(i,parameter.getCode());
    }

    /**
     * 通过状态码返回的枚举类型
     */
    @Override
    public MyEmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
        //需要根据从数据库的中拿到枚举类型的状态码，然后返回一个枚举类型的对象
        String code = rs.getString(columnName);
        System.out.println("从数据库中获取到的状态码："+code);
        return MyEmpStatus.getMyEmpStatusByCode(code);
    }

    @Override
    public MyEmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
        //需要根据从数据库的中拿到枚举类型的状态码，然后返回一个枚举类型的对象
        String code = rs.getString(columnIndex);
        System.out.println("从数据库中获取到的状态码获取到的状态码："+code);
        return MyEmpStatus.getMyEmpStatusByCode(code);
    }

    @Override
    public MyEmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
        //需要根据从数据库的中拿到枚举类型的状态码，然后返回一个枚举类型的对象
        String code = cs.getString(columnIndex);
        System.out.println("从数据库中获取到的状态码获取到的状态码："+code);
        return MyEmpStatus.getMyEmpStatusByCode(code);
    }
}
