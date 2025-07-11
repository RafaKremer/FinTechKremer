package com.projeto.fintech.config;

import java.util.HashMap;
import java.util.Map;

/**
SE ISSO NÃO É SINGLETON NÃO SEI MAIS O QUE É xD
 */
public final class ConfigurationManager {

    private static final ConfigurationManager instance = new ConfigurationManager();

    private final Map<String, Object> settings = new HashMap<>();

    private ConfigurationManager() {
        settings.put("application.name", "Fintech-Project");
        settings.put("api.version", "1.0");
        settings.put("transaction.timeout.seconds", 30);
    }

    /**
     * 3. O ponto de acesso global e público para a única instância.
     * @return A instância única de ConfigurationManager.
     */
    public static ConfigurationManager getInstance() {
        return instance;
    }

    /**
     * Obtém um valor de configuração.
     * @param key A chave da configuração.
     * @return O valor associado à chave.
     */
    public Object getSetting(String key) {
        return settings.get(key);
    }

    /**
     * Adiciona ou atualiza uma configuração em tempo de execução.
     * @param key A chave da configuração.
     * @param value O novo valor.
     */
    public void setSetting(String key, Object value) {
        settings.put(key, value);
    }
}