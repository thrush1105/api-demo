package com.example.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.service.SampleService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("sample")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("hello")
    public String hello() {
        return sampleService.hello();
    }

    @GetMapping("csv")
    public void index(
            @RequestParam(name = "since", required = false) String since,
            @RequestParam(name = "until", required = false) String until,
            HttpServletResponse response)
            throws IOException {
        response.setContentType("text/csv");
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        PrintWriter writer = response.getWriter();

        sampleService.outputCsv(since, until, writer);
    }

}
