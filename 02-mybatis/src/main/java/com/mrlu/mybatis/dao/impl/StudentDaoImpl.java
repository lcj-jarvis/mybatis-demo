package com.mrlu.mybatis.dao.impl;

import com.mrlu.mybatis.Utils.MybatisUtils;
import com.mrlu.mybatis.dao.StudentDao;
import com.mrlu.mybatis.domain.Student;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Mr.Lu
 * @create 2021-02-07 19:17
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.mrlu.mybatis.dao.StudentDao.selectStudents";
        List<Student> list = sqlSession.selectList(sqlId);
        sqlSession.close();
        return list;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.mrlu.mybatis.dao.StudentDao.insertStudent";
        int insert = sqlSession.insert(sqlId, student);
        sqlSession.commit(); //提交事务
        sqlSession.close();
        return insert;
    }
}
