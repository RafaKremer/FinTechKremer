package com.projeto.fintech.controller;

import com.projeto.fintech.model.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @PostMapping("criar/{tipo}")
    public Cliente criarCliente(
            @PathVariable String tipo) {
        Cliente cliente = new Cliente();
        cliente.setTipo(tipo);
        return cliente;
    }

    @GetMapping("mostrar/{tipo}")
    public Cliente mostrarCliente(
            @PathVariable String tipo) {
        Cliente cliente = new Cliente();
        cliente.setTipo(tipo);
        return cliente;
    }

    @PutMapping("atualizar/{tipo}")
    public Cliente atualizarCliente(
            @PathVariable String tipo) {
        Cliente cliente = new Cliente();
        cliente.setTipo(tipo);
        return cliente;
    }

    @PatchMapping("corrigir/{tipo}")
    public Cliente corrigirCliente(
            @PathVariable String tipo) {
        Cliente cliente = new Cliente();
        cliente.setTipo(tipo);
        return cliente;
    }

    @DeleteMapping("excluir/{tipo}")
    public Cliente excluirCliente(
            @PathVariable String tipo) {
        Cliente cliente = new Cliente();
        cliente.setTipo(tipo);
        return cliente;
    }

    
}