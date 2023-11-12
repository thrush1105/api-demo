package com.example.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;

import com.example.domain.model.Sample;

@Mapper
public interface SampleRepository {

    Cursor<Sample> findAll(@Param("since") String since, @Param("until") String until);

}
