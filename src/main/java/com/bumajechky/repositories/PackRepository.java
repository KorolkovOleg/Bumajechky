package com.bumajechky.repositories;

import com.bumajechky.domain.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Long> {
}
