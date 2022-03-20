package com.mrlu.mybatis.dao;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-26 0:44
 */

/**
 * 插件的签名。
 *   告诉mybatis当前插件用来拦截哪个对象的哪个方法
 *   下面的是用来拦截：StatementHandler类的parameterize(Statement statement)方法
 */
@Intercepts(value = {
        @Signature(type = StatementHandler.class
                , method = "parameterize"
                ,args = {java.sql.Statement.class})
})
public class MyFirstPlugin implements Interceptor {
    /**
     * intercept:拦截
     *         拦截目标对象的目标方法的执行
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MyFirstPlugin...intercept:拦截到的目标方法："+invocation.getMethod());
        //System.out.println("MyFirstPlugin...intercept:获取到的目标方法的参数"+ Arrays.toString(invocation.getArgs()));
        //System.out.println("MyFirstPlugin...intercept:被拦截到的对象"+invocation.getTarget());
        //执行目标方法
        Object proceed = invocation.proceed();
        System.out.println("MyFirstPlugin执行完毕");
        //返回执行的返回值
        return proceed;
    }

    /**
     * 包装目标对象的：包装：为目标对象创建一个代理对象
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("MyFirstPlugin...plugin:mybatis将要包装对象"+target);

        //我们可以借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        Object wrap = Plugin.wrap(target,this);
        //返回为当前target创建的动态过程
        return wrap;
    }

    /**
     * setProperties:将插件注册时的property属性设置进来
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息:"+properties);
    }
}
