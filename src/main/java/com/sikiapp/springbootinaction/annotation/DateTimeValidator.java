/**
 * projectName: spring-boot-in-action
 * fileName: DateTimeValidator.java
 * packageName: com.sikiapp.springbootinaction.annotation
 * date: 2019-05-25 下午3:34
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @className: DateTimeValidator
 * @packageName: com.sikiapp.springbootinaction.annotation
 * @description: 日期格式验证
 * @author: Robert
 * @data: 2019-05-25 下午3:34
 * @version: V1.0
 **/
public class DateTimeValidator implements ConstraintValidator<DateTime, String> {

    private DateTime dateTime;

    @Override
    public void initialize(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果 value 为空则不进行格式验证，为空验证可以使用 @NotBlank @NotNull @NotEmpty 等注解来进行控制，职责分离
        if (value == null) {
            return true;
        }
        String format = dateTime.format();
        if (value.length() != format.length()) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try {
            simpleDateFormat.parse(value);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}