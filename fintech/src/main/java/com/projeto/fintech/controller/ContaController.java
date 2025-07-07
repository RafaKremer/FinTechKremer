package com.projeto.fintech.controller;

import com.projeto.fintech.model.Conta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/contas")
public class ContaController {

    private static final Logger logger = LoggerFactory.getLogger(ContaController.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("criar")
    public Conta criarConta(@RequestBody Conta conta) {
        try { // botei um depurador pra cumprir exigências
            logger.debug("Payload recebido para criação de conta: {}", objectMapper.writeValueAsString(conta));
        } catch (Exception e) {
            logger.debug("Não foi possível serializar o objeto conta para o log.");
        }
        logger.info("Recebida requisição para criar conta do tipo: {}", conta.getTipo());
        logger.info("Conta do tipo {} criada com sucesso.", conta.getTipo());

        return conta;
    }

    @GetMapping("mostrar/{tipo}")
    public Conta mostrarConta(@PathVariable String tipo) {
        logger.info("Mostrando conta do tipo: {}", tipo);
        Conta conta = new Conta();
        conta.setTipo(tipo);
        return conta;
    }

    @GetMapping("/exemplo-erro")
    public void exemploErro() {
        try {
            // Simulando um erro
            @SuppressWarnings("unused") // coloquei @supr... pra não ficar mostrando o erro no console
            int resultado = 10 / 0;
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao processar a requisição de exemplo.", e);
        }
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