package com.sikiapp.springbootinaction;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Arrays;

@EnableAsync
@EnableScheduling
@EnableAdminServer
@SpringBootApplication
public class SpringBootInActionApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootInActionApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInActionApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)  {
        return args -> {
            logger.debug("来看看 SpringBoot 默认为我们提供的 Bean：");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            Arrays.stream(beanNames).forEach(logger::debug);
        };
    }

    @Bean
    public TaskScheduler taskScheduler() {
        // 默认情况下 TaskScheduler 的 poolSize = 1
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10);
        return taskScheduler;
    }



}


