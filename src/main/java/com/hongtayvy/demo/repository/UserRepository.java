package com.hongtayvy.demo.repository;

import com.hongtayvy.demo.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
