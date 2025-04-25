package com.beira.mar2.repositories;

import com.beira.mar2.models.ItensModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensRepository extends JpaRepository<ItensModel, Integer> {
}