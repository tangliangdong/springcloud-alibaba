package com.xiaotang.springorder.annotation;

import java.lang.annotation.*;
/**
 * @author Administrator
 * @data 2020/1/6
 * @time 17:26
 */
@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UUID {
}
