package com.example.batch;

import org.springframework.stereotype.Component;

import com.example.domain.service.SampleService;

@Component
public class SampleComponent {

    private final SampleService sampleService;

    public SampleComponent(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public void run() {
        System.out.println(sampleService.hello());
    }

}
