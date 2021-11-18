package com.bumajechky.repositories;

import com.bumajechky.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String s);
}
