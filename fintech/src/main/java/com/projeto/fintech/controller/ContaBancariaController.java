package com.projeto.fintech.controller;

import com.projeto.fintech.model.ContaBancaria;
import org.springframework.web.bind.annotation.*;

public class ContaBancariaController {
    @PostMapping("criar/{tipo}")
    public ContaBancaria criarContaBancaria(
            @PathVariable String tipo) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setTipo(tipo);
        return contaBancaria;
    }

    @GetMapping("mostrar/{tipo}")
    public ContaBancaria mostrarContaBancaria(
            @PathVariable String tipo) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setTipo(tipo);
        return contaBancaria;
    }

    @PutMapping("atualizar/{tipo}")
    public ContaBancaria atualizarContaBancaria(
            @PathVariable String tipo) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setTipo(tipo);
        return contaBancaria;
    }

    @PatchMapping("corrigir/{tipo}")
    public ContaBancaria corrigirContaBancaria(
            @PathVariable String tipo) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setTipo(tipo);
        return contaBancaria;
    }

    @DeleteMapping("excluir/{tipo}")
    public ContaBancaria excluirContaBancaria(
            @PathVariable String tipo) {
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.setTipo(tipo);
        return contaBancaria;
    }
}