package com.example.demo.service;

import com.example.demo.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author 86187
 */
public interface UserService {


    User findByName(String name);

}
