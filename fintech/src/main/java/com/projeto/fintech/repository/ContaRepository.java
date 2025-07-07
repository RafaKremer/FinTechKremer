package com.projeto.fintech.repository;

import com.projeto.fintech.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    // Tenho que lembrar que aqui não tem método porquê 
    // o JpaRepository já fornece os métodos básicos
}