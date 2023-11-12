package com.example.domain.service;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.ibatis.cursor.Cursor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Sample;
import com.example.domain.repository.SampleRepository;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public String hello() {
        return "Hello!!";
    }

    @Transactional(readOnly = true)
    public void outputCsv(String since, String until, PrintWriter writer)
            throws IOException {
        try (Cursor<Sample> samples = sampleRepository.findAll(since, until)) {
            for (Sample sample : samples) {
                outputCsvRow(sample, writer);
            }
        }
        writer.flush();
    }

    private void outputCsvRow(Sample sample, PrintWriter writer) {
        StringBuffer sb = new StringBuffer();

        sb.append(sample.getId());
        sb.append(",");
        sb.append(sample.getUuid());
        sb.append(",");
        sb.append(sample.getText());
        sb.append(",");
        sb.append(sample.getDate());
        sb.append(",");
        sb.append(sample.getCreatedAt());
        sb.append(",");
        sb.append(sample.getUpdatedAt());

        writer.println(sb);
    }

}
