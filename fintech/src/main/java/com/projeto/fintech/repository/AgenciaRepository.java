package com.projeto.fintech.repository;

import com.projeto.fintech.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}