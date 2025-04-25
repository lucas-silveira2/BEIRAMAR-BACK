package com.beira.mar2.repositories;

import com.beira.mar2.models.MesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<MesaModel, Integer> {
}