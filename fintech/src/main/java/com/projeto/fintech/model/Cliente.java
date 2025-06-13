package com.projeto.fintech.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Id @GeneratedValue
    private Long id;
    private String nome;
    private String tipo;

    @OneToOne(cascade = CascadeType.ALL)
    private ContaBancaria contaBancaria;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cartao> cartoes;
}