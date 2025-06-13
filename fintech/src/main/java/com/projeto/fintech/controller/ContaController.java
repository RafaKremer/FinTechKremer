package com.projeto.fintech.controller;

import com.projeto.fintech.model.Conta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @PostMapping("criar/{tipo}")
    public Conta criarConta(
            @PathVariable String tipo) {
        Conta conta = new Conta();
        conta.setTipo(tipo);
        return conta;
    }

    @GetMapping("mostrar/{tipo}")
    public Conta mostrarConta(
            @PathVariable String tipo) {
        Conta conta = new Conta();
        conta.setTipo(tipo);
        return conta;
    }

    @PutMapping("atualizar/{tipo}")
    public Conta atualizarConta(
            @PathVariable String tipo) {
        Conta conta = new Conta();
        conta.setTipo(tipo);
        return conta;
    }

    @PatchMapping("corrigir/{tipo}")
    public Conta corrigirConta(
            @PathVariable String tipo) {
        Conta conta = new Conta();
        conta.setTipo(tipo);
        return conta;
    }

    @DeleteMapping("excluir/{tipo}")
    public Conta excluirConta(
            @PathVariable String tipo) {
        Conta conta = new Conta();
        conta.setTipo(tipo);
        return conta;
    }
}