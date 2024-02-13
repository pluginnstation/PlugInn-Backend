package com.plugInnApp.repository;

import com.plugInnApp.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<UserLoginEntity, String> {
    Optional<UserLoginEntity> findByEmail(String email);
}
