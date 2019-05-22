/**
 * projectName: spring-boot-in-action
 * fileName: SwaggerConfig.java
 * packageName: com.sikiapp.springbootinaction.config
 * date: 2019-05-22 下午5:40
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.springbootinaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @className: SwaggerConfig
 * @packageName: com.sikiapp.springbootinaction.config
 * @description: Swagger配置类
 * @author: Robert
 * @data: 2019-05-22 下午5:40
 * @version: V1.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sikiapp.springbootinaction.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        // 定义联系人信息
        Contact contact = new Contact("Robert", "https://github.com/SikiTech", "Robert.Tsai@sikiapp.com");
        return new ApiInfoBuilder()
                .title("点聚小程序APIs")
                .description("识迹科技有限公司版权所有️")
                .termsOfServiceUrl("https://www.sikiapp.com")
                .version("1.0")
                .contact(contact)
                .build();
    }

}