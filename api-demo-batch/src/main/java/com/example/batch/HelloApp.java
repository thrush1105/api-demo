package com.example.batch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericApplicationContext;

import com.example.domain.service.SampleService;

/**
 * Hello world!
 *
 */
@ImportResource({ "classpath:META-INF/spring/applicationContext.xml" })
@ComponentScan
public class HelloApp {

    public static void main(String[] args) {
        try (GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloApp.class)) {
            SampleService sampleService = applicationContext.getBean(SampleService.class);
            System.out.println(sampleService.hello());
        }
    }

}
