package com.mrlu.mybatis.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author Mr.Lu
 * @create 2021-02-07 17:59
 */
public class MybatisUtils {
    //为什么不定义成static final的呢？因为要手动赋默认值
    public static SqlSessionFactory build;

    static {
        String config = "mybatis.xml";//需要和你项目的文件名一样
        try {
            InputStream in = Resources.getResourceAsStream(config);
            build = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        if (build != null){
            sqlSession = build.openSession();//非自动提交事务的
        }
        return sqlSession;
    }
}
