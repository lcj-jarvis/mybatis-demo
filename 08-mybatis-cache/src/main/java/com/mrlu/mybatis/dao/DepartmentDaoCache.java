package com.mrlu.mybatis.dao;

import com.mrlu.mybatis.domain.Department;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-23 19:35
 */
public interface DepartmentDaoCache {
    /**
     * 用于测试缓存
     * @param id
     * @return
     */
    Department getDeptById(Integer id);
}
