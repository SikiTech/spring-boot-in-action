package com.sikiapp.springbootinaction;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
@EnableAdminServer
public class SpringBootInActionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInActionApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)  {
        // 目的是
        return args -> {
            System.out.println("来看看 SpringBoot 默认为我们提供的 Bean：");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
//            Arrays.stream(beanNames).forEach(System.out::println);
        };
    }

}
