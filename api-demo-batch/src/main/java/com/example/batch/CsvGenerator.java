package com.example.batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.example.domain.service.SampleService;

public class CsvGenerator {

    public static void main(String[] args) {
        try (GenericApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            String since = args.length > 0 ? args[0] : null;
            String until = args.length > 1 ? args[1] : null;

            SampleService sampleService = applicationContext.getBean(SampleService.class);

            try {
                File file = new File("sample.csv");
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));

                sampleService.outputCsv(since, until, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
