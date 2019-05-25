/**
 * projectName: spring-boot-in-action
 * fileName: Electronics.java
 * packageName: com.sikiapp.springbootinaction.model
 * date: 2019-05-25 上午11:15
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.model;

import com.sikiapp.springbootinaction.annotation.Groups;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @className: Electronics
 * @packageName: com.sikiapp.springbootinaction.model
 * @description: 电子产品
 * @author: Robert
 * @data: 2019-05-25 上午11:15
 * @version: V1.0
 **/
@Data
public class Electronics implements Serializable {

    private static final long serialVersionUID = 3703535695618150804L;

    @NotNull(message = "id不能为空", groups = Groups.Update.class)
    private Integer id;

    @NotBlank(message = "name 不允许为空", groups = Groups.Default.class)
    @Length(min = 2, max = 10, message = "name 必须在{min} - {max}之间")
    private String name;

    @NotNull(message = "price 不能为空", groups = Groups.Default.class)
    @DecimalMin(value = "0.1", message = "价格不能低于{999.99}")
    private BigDecimal price;
}