package com.example.batch;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan({
        "com.example.batch",
        "com.example.domain.service"
})
@ImportResource({ "classpath:META-INF/spring/applicationContext.xml" })
public class App {
    public static void main(String[] args) {
        try (GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class)) {
            SampleComponent sampleComponent = applicationContext.getBean(SampleComponent.class);
            sampleComponent.run();
            UserComponent userComponent = applicationContext.getBean(UserComponent.class);
            userComponent.run();
        }
    }
}
