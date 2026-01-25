package com.example.multiple_db_config.db2.repository;

import com.example.multiple_db_config.db2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
