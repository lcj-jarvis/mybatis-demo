package com.mrlu.mybatis.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.Properties;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-26 11:16
 */
@Intercepts(value = {
        @Signature(type = StatementHandler.class
                , method = "parameterize"
                ,args = {java.sql.Statement.class})
})
public class MySecondPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("MySecondPlugin...intercept:拦截到的目标方法："+invocation.getMethod());
        //动态的改变一下sql运行的参数：以前1001学生，实际从数据库查1002号学生
        Object target = invocation.getTarget();
        System.out.println("当前拦截到的对象："+target);
        //拿到StatementHandler ==》 ParameterHandler ==》paramObject
        //拿到target的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("sql语句用到的参数："+value);
        metaObject.setValue("parameterHandler.parameterObject",1002);
        //执行【修改后的】目标方法
        Object proceed = invocation.proceed();
        System.out.println("MySecondPlugin执行完毕");
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("MySecondPlugin...plugin:"+target);
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息:"+properties);
    }
}
