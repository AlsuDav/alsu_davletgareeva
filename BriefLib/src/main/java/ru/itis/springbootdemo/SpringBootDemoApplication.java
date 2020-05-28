package ru.itis.springbootdemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableSwagger2
public class SpringBootDemoApplication {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
    //Bean named 'defaultSockJsTaskScheduler' is expected to be of type 'org.springframework.scheduling.TaskScheduler' but was actually of type 'org.springframework.beans.factory.support.NullBean'
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(3);
        taskScheduler.setThreadNamePrefix("task");
        taskScheduler.setDaemon(true);
        return taskScheduler;
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ru.itis.springbootdemo.api"))
                .paths(PathSelectors.any())
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }



}
