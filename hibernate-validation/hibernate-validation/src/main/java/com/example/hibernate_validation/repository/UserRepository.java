package com.example.hibernate_validation.repository;

import com.example.hibernate_validation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
