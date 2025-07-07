package com.projeto.fintech.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// criando um singleton para atender as exigências do projeto
// coloquei no ContaController para testar o LogService
@Service
public class LogService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LogService() {
        System.out.println("### LogService INICIADO ###");
    }

    public void info(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println("[INFO] " + timestamp + " - " + message);
    }

    public void error(String message) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.err.println("[ERROR] " + timestamp + " - " + message);
    }
}