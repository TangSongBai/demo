package com.example.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * @Author: 86187
 * @Date: 2023/3/3 10:40
 * @Description:
 */
@Configuration
public class FastJsonHttpMessageConverterConfig {

    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8));

        converter.setFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);

        return converter;
    }



}
