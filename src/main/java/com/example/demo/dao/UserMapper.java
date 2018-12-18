package com.example.demo.dao;

import java.util.List;

import com.example.demo.domain.UserEntity;

public interface UserMapper {
    List<UserEntity> getAll();
    void insert(UserEntity user);
}
