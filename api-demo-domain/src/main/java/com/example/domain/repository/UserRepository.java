package com.example.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.model.User;

@Mapper
public interface UserRepository {

    List<User> findAll();

}
