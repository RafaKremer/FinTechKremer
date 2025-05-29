package com.projeto.fintech.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.server.ExportException;

import org.aspectj.weaver.bcel.ExceptionRange;
import org.hibernate.query.sqm.EntityTypeException;

public class Tratamento {
    /**
     * @param caminho
     */
    public Tratamento(String caminho) {
        FileReader arquivo = null;
        try {
            arquivo = new FileReader(caminho);
            // Processamento do arquivo
        } catch (FileNotFoundException e) {
            logger.error("Arquivo não encontrado: " + caminho, e);
            throw new RecursoNaoEncontradoException();
        } catch (IOException e) {
            logger.error("Erro ao ler arquivo: " + caminho, e);
            throw new ErroProcessamentoException();
        } finally {
            if (arquivo != null) {
                try {
                    arquivo.close();
                } catch (ExportException e) {
                    logger.error("Não é possível exportar esse tipo de arquivo");
                } finally {
                    System.out.println("It's done");
                }
            }
        }
    }
}