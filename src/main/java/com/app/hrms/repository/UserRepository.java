package com.app.hrms.repository;

import com.app.hrms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("""
        SELECT DISTINCT u
        FROM User u
        LEFT JOIN FETCH u.roles
        WHERE u.username = :username
    """)
    Optional<User> findByUsername(String username);
}
