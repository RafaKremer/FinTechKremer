package com.projeto.fintech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// criando um singleton para atender as exigências do projeto
// coloquei no ContaController para testar o LogService
@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogService() {
        logger.info("### LogService INICIADO ###");
    }

    /**
     * Registra uma mensagem de informação no log.
     * @param message A mensagem a ser registrada.
     */
    public void info(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        // 2. Substituindo System.out.println por logger.info()
        // Registra a mensagem com o nível INFO.
        logger.info("{} - {}", timestamp, message);
    }

    /**
     * Registra uma mensagem de erro no log.
     * @param message A mensagem de erro a ser registrada.
     */
    public void error(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        logger.error("{} - {}", timestamp, message);
    }
    
    /**
     * Registra uma mensagem de depuração (debug) no log.
     * Esta mensagem só aparecerá se o nível de log estiver definido como DEBUG.
     * @param message A mensagem de depuração.
     */
    public void debug(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        logger.debug("{} - {}", timestamp, message);
    }
}