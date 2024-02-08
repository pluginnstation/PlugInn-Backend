package com.plugInnApp.repository;

import com.plugInnApp.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLoginEntity, Integer> {
    UserLoginEntity findByEmail(String email);
}
