package com.engineer.repository;

import com.engineer.entity.LoggedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggedUserRepository extends JpaRepository<LoggedUser, Long> {
    LoggedUser findByUsername(String name);
}
