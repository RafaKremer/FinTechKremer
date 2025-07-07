package com.projeto.fintech.controller;

import com.projeto.fintech.factory.ContaFactory;
import com.projeto.fintech.model.ContaBancaria;
import com.projeto.fintech.model.TipoConta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas-bancarias")
public class ContaBancariaController {
    
    @PostMapping("criar/{tipo}")
    public ResponseEntity<TipoConta> criarContaBancaria(@PathVariable String tipo) {
        TipoConta novaConta = ContaFactory.criarConta(tipo);
        return ResponseEntity.ok(novaConta);
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