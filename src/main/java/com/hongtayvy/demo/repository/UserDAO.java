package com.hongtayvy.demo.repository;

import com.hongtayvy.demo.repository.entity.UserEntity;

import java.util.List;

public interface UserDAO {
    List<UserEntity> findAll();
    UserEntity findById(int id);
    UserEntity update(int id, boolean active);
    UserEntity save(UserEntity userEntity);
    void deleteById(int id);
}
