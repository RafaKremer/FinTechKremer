package com.projeto.fintech.repository;

import com.projeto.fintech.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    // JPA dá o CRUD
}