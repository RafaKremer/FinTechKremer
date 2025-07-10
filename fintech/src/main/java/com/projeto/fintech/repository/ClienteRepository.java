package com.projeto.fintech.repository;

import com.projeto.fintech.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // JPA já dá o CRUD
}
