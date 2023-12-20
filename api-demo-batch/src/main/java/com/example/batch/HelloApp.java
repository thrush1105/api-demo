package com.example.batch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Hello world!
 *
 */
public class HelloApp {

    public static void main(String[] args) {
        try (GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            SampleComponent sampleComponent = applicationContext.getBean(SampleComponent.class);
            sampleComponent.hello();
        }
    }

}
