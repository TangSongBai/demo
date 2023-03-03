package com.example.demo.controller.login;

import com.alibaba.fastjson.JSON;
import com.example.demo.annotation.AccessAnnotation;
import com.example.demo.enums.AccessEnum;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 86187
 * @Auther: 86187
 * @Date: 2023/3/2 16:08
 * @Description:
 */
@RestController
@Controller

public class LoginController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/login")
    @AccessAnnotation
    public Result<User> login(@RequestBody Map<String, String> map) {
        String userName = map.get("userName");
        String password = map.get("password");
        System.out.println(String.format("账号---%s,密码----%s", userName, password));

        User user = userService.findByName(userName);

        System.out.println(JSON.toJSONString(user));


        AccessEnum common = AccessEnum.COMMON;
        String permission = common.getPermission();

        System.out.println(permission);


        return Result.success("操作成功", user);
    }

    public static void main(String[] args) {

        try {
            for (Method declaredMethod : Class.forName("com.example.demo.controller.login.LoginController").getDeclaredMethods()) {
                if ("login".equals(declaredMethod.getName())){

                    Annotation[] annotations = declaredMethod.getAnnotations();

                    for (Annotation annotation : annotations) {

                        System.out.println(annotation);

                    }


                }


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
