package com.sikiapp.springbootinaction.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title: DateTime
 * @package com.sikiapp.springbootinaction.annotation
 * @description: Date注解，标注@Constraint 注解，它的作用就是指定一个具体的校验器类
 * @author: Robert
 * @date: 2019/5/25 下午3:38
 * @version: V1.0
*/
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface DateTime {

    String message() default "格式错误";

    String format() default "yyyy-MM-dd";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
