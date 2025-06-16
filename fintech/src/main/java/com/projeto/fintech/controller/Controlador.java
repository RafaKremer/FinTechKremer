package com.projeto.fintech.controller;

@RestController
@RequestMapping("/api/produtos")
public class Controlador {
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return null;
        
    }
}
