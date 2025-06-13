package com.projeto.fintech.controller;

import com.projeto.fintech.model.Cartao;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @PostMapping("criar/{tipo}")
    public Cartao criarCartao(
            @PathVariable String tipo) {
        Cartao cartao = new Cartao();
        cartao.setTipo(tipo);
        return cartao;
    }

    @GetMapping("mostrar/{tipo}")
    public Cartao mostrarCartao(
            @PathVariable String tipo) {
        Cartao cartao = new Cartao();
        cartao.setTipo(tipo);
        return cartao;
    }

    @PutMapping("atualizar/{tipo}")
    public Cartao atualizarCartao(
            @PathVariable String tipo) {
        Cartao cartao = new Cartao();
        cartao.setTipo(tipo);
        return cartao;
    }

    @PatchMapping("corrigir/{tipo}")
    public Cartao corrigirCartao(
            @PathVariable String tipo) {
        Cartao cartao = new Cartao();
        cartao.setTipo(tipo);
        return cartao;
    }

    @DeleteMapping("excluir/{tipo}")
    public Cartao excluirCartao(
            @PathVariable String tipo) {
        Cartao cartao = new Cartao();
        cartao.setTipo(tipo);
        return cartao;
    }

}