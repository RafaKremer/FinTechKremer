package com.projeto.fintech.controller;

import com.projeto.fintech.model.Cartao;
import com.projeto.fintech.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @PostMapping("/criar")
    public Cartao criarCartao(@RequestBody Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    @GetMapping("/todos")
    public List<Cartao> listarTodosCartoes() {
        return cartaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscarCartaoPorId(@PathVariable("id") Long id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);

        // Se o cartão for encontrado, retorna-o com o status 200 OK.
        // Caso contrário, retorna um 404 Not Found.
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
                }).orElseGet(() -> ResponseEntity.notFound().build()); // Se não encontrar, retorna 404
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Object> excluirCartao(@PathVariable("id") Long id) {
        return cartaoRepository.findById(id)
                .map(cartao -> {
                    cartaoRepository.delete(cartao);
                    // Retorna uma resposta 204 No Content, indicando sucesso na exclusão
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}