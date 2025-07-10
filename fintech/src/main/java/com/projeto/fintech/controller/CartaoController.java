package com.projeto.fintech.controller;

import com.projeto.fintech.model.Cartao;
import com.projeto.fintech.repository.CartaoRepository;
import com.projeto.fintech.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoRepository cartaoRepository;
    
    @Autowired
    private ContaRepository contaRepository;

    @PostMapping("/criar")
    public Cartao criarCartao(@RequestBody Cartao cartao) {
        if (cartao.getConta() == null || cartao.getConta().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A conta (com id) é obrigatória para criar um cartão.");
        }

        Long contaId = cartao.getConta().getId();
        contaRepository.findById(contaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta com id " + contaId + " não encontrada."));

        return cartaoRepository.save(cartao);
    }

    @GetMapping("/todos")
    public List<Cartao> listarTodosCartoes() {
        return cartaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscarCartaoPorId(@PathVariable("id") Long id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);

        return cartao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cartao> atualizarCartao(@PathVariable("id") Long id, @RequestBody Cartao dadosCartao) {
        return cartaoRepository.findById(id)
                .map(cartaoExistente -> {
                    cartaoExistente.setTipo(dadosCartao.getTipo());
                    cartaoExistente.setNumero(dadosCartao.getNumero());
                    cartaoExistente.setUsuario(dadosCartao.getUsuario());
                    Cartao cartaoAtualizado = cartaoRepository.save(cartaoExistente);
                    return ResponseEntity.ok(cartaoAtualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluirCartao(@PathVariable("id") Long id) {
        return cartaoRepository.findById(id)
                .map(cartao -> {
                    cartaoRepository.delete(cartao);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}