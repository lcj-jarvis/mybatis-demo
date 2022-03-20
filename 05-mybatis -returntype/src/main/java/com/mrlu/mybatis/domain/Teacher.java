package com.mrlu.mybatis.domain;

import lombok.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-20 2:13
 */
//测试插件
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class Teacher {
   private String name;
   private Integer age;
}
