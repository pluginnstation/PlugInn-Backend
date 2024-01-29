package com.plugInnApp.userRegistration.repository;

import com.plugInnApp.userRegistration.entity.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserLoginEntity, Integer> {
    UserLoginEntity findByEmail(String email);
}
