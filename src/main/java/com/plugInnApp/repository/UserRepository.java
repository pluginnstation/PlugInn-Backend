package com.plugInnApp.repository;

import com.plugInnApp.entity.UserLoginEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserLoginEntity, String> {
    UserLoginEntity findByEmail(String email);



}
