package com.example.demo.config;

import com.example.demo.annotation.AccessAnnotation;
import com.example.demo.exception.DemoException;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: 86187
 * @Date: 2023/3/3 13:40
 * @Description: 资源鉴权
 */
@Component
@Aspect
public class AccessAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("execution(* com.example.demo.controller..*.*(..))")
    public  void  accessAspect(){};

    /**
     * 进行接口访问前进行认证
     * @param joinPoint
     */
    @SneakyThrows
    @Before("accessAspect()")
    public void accessBefore(JoinPoint joinPoint){
        //判断用户是否登录
        loginOrNot(httpServletRequest);


        //判断用户是否又资源访问权限
        resourceAuthentication(joinPoint);


    }

    public void loginOrNot(HttpServletRequest request) {
        //放行不需要鉴权的接口，todo:后续网关进行
        String requestURI = request.getRequestURI();

        if (requestURI.contains("login")) {
            return;
        }
        //获取token
        String authorizationHeader = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authorizationHeader))throw new DemoException(401,"还未登录");
        
    }




    /**
     * 判断用户是否有资源访问权限
     * @param joinPoint
     * @throws ClassNotFoundException
     */
    public void resourceAuthentication(JoinPoint joinPoint) throws ClassNotFoundException {
        //类名
        String className = joinPoint.getTarget().getClass().getName();

        //方法名
        String methodName = joinPoint.getSignature().getName();

        //参数名
        Object[] args = joinPoint.getArgs();


        //获得方法上的自定义注解
        Method[] declaredMethods = Class.forName(className).getDeclaredMethods();

        AccessAnnotation methodAnnotation =null;

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().equals(methodName)){
                AccessAnnotation annotation = declaredMethod.getAnnotation(AccessAnnotation.class);
                methodAnnotation=declaredMethod.getAnnotation(AccessAnnotation.class);
            }
        }

        //todo:判断用户是否有权限能够访问
        if ( methodAnnotation !=null){
            //获取登录用户信息，todo：可以存放threadlocal或redis中
            throw  new DemoException(403,"无权限访问");

        }
    }


}
