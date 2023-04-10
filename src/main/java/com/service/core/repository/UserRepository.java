package com.service.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.core.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
