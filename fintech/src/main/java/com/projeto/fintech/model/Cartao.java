package com.projeto.fintech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cartao {
    @Id
    private Long id;
    private String tipo;
    private int numero;
    private String usuario;

    public Cartao(String tipo, int numero, String usuario) {
        this.tipo = tipo;
        this.numero = numero;
        this.usuario = usuario;
    }

}