package com.xiaotang.springaccount.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xiaotang.springaccount.interceptor.LoginInterceptor;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Administrator
 * @data 2020/1/15
 * @time 15:01
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/loginSys").excludePathPatterns("/static/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MappingJackson2HttpMessageConverter());
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastjson的配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();

        SerializerFeature[] serializerFeatures = new SerializerFeature[]{
                //    输出key是包含双引号
//                SerializerFeature.QuoteFieldNames,
                //    是否输出为null的字段,若为null 则显示该字段
                SerializerFeature.WriteMapNullValue,
                //    数值字段如果为null，则输出为0
                SerializerFeature.WriteNullNumberAsZero,
                //     List字段如果为null,输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //    字符类型字段如果为null,输出为"",而非null
                SerializerFeature.WriteNullStringAsEmpty,
                //    Boolean字段如果为null,输出为false,而非null
                SerializerFeature.WriteNullBooleanAsFalse,
                //    Date的日期转换器
                SerializerFeature.WriteDateUseDateFormat,
                //    循环引用
                SerializerFeature.DisableCircularReferenceDetect,
        };

        fastJsonConfig.setSerializerFeatures(serializerFeatures);
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));

        //3、在convert中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(1, fastConverter);
    }

}
