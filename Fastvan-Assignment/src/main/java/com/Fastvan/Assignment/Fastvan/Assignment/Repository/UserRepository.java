package com.Fastvan.Assignment.Fastvan.Assignment.Repository;

import com.Fastvan.Assignment.Fastvan.Assignment.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

