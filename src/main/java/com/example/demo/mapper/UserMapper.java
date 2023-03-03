package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: 86187
 * @Date: 2023/3/2 16:51
 * @Description:
 */
@Repository
public interface UserMapper  {
    User findByName(@Param("name") String name);
}
