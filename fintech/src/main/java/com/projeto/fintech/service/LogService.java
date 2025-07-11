package com.projeto.fintech.service;

import com.projeto.fintech.config.ConfigurationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogService {

    private static final Logger logger = LoggerFactory.getLogger(LogService.class);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private final ConfigurationManager config = ConfigurationManager.getInstance();

    public LogService() {
        String appName = (String) config.getSetting("application.name");
        logger.info("### LogService INICIADO para a aplicação: {} ###", appName);
    }

    public void info(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
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