package br.edu.fatec.iqs09;

/** Exemplo mínimo para o exercício da branch hotfix/header-null. */
public class HeaderUtil {

    /** Cria o utilitário. */
    public HeaderUtil() {
    }

    /**
     * Remove espaços externos e trata um cabeçalho ausente.
     *
     * @param header valor do cabeçalho, que pode ser nulo
     * @return valor sem espaços externos, ou uma string vazia se for nulo
     */
    public String normalizar(String header) {
        return header == null ? "" : header.trim();
    }
}
