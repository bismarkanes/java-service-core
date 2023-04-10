package com.service.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.service.core.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM USERS u where u.name ILIKE %?1% OFFSET ?2 LIMIT ?3", nativeQuery = true)
    List<User> findCustomUsers(String search, Integer offset, Integer limit);

    @Query(value = "SELECT COUNT(u.id) FROM USERS u where u.name ILIKE %?1%", nativeQuery = true)
    Integer findCountCustomUsers(String search);
}
