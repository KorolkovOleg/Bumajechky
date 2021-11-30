package com.bumajechky.repositories;

import com.bumajechky.domain.Card;
import com.bumajechky.domain.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByPack(Pack pack);
}
