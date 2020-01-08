package com.xiaotang.springaccount.interceptor;

import com.xiaotang.commonpart.annotation.UUID;
import org.apache.commons.lang.reflect.FieldUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Properties;
import com.xiaotang.commonpart.annotation.CreateTime;
import com.xiaotang.commonpart.annotation.UpdateTime;

/**
 * @author Administrator
 * @data 2020/1/6
 * @time 17:24
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class })
})
public class InsertInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] objects = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        String commandType =  mappedStatement.getSqlCommandType().name();
        Object object = objects[1];
        BeanWrapper beanWrapper = new BeanWrapperImpl(object);
        PropertyDescriptor[] descriptors = beanWrapper.getPropertyDescriptors();
        if("INSERT".equals(commandType)) {
            for (PropertyDescriptor descriptor : descriptors) {
                String filedName = descriptor.getName();
                if (!"class".equals(filedName) && !"empty".equals(filedName)) {
                    Field field = FieldUtils.getField(object.getClass(), filedName, true);
                    UUID uuid = field.getAnnotation(UUID.class);
                    CreateTime createTime = field.getAnnotation(CreateTime.class);
                    UpdateTime updateTime = field.getAnnotation(UpdateTime.class);
                    if (uuid != null) {
                        if(beanWrapper.getPropertyValue(filedName)==null || "".equals(beanWrapper.getPropertyValue(filedName))) {
                            beanWrapper.setPropertyValue(filedName, java.util.UUID.randomUUID().toString().replaceAll("-", ""));
                        }
                    } else if (createTime != null) {
                        beanWrapper.setPropertyValue(filedName, Calendar.getInstance().getTime());
                    } else if (updateTime != null) {
                        beanWrapper.setPropertyValue(filedName, Calendar.getInstance().getTime());
                    }
                }
            }
        } else if("UPDATE".equals(commandType)){
            for (PropertyDescriptor descriptor : descriptors) {
                String filedName = descriptor.getName();
                if(!"class".equals(filedName)&&!"empty".equals(filedName)){
                    Field field=  FieldUtils.getField(object.getClass(), filedName, true);
                    UpdateTime updateTime = field.getAnnotation(UpdateTime.class);
                    if(updateTime!=null){
                        beanWrapper.setPropertyValue(filedName, Calendar.getInstance().getTime());
                    }
                }
            }
        }

        objects[1] = beanWrapper.getWrappedInstance();
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
