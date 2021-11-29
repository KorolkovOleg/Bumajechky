package com.bumajechky.repositories;

import com.bumajechky.domain.Pack;
import com.bumajechky.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, Long> {

    List<Pack> findAllByUsers(User user);

    void deleteById(Long id);

}
