package br.edu.fatec.iqs09;

import java.util.regex.Pattern;

/** Serviço do desafio colaborativo, com envio de e-mail simulado localmente. */
public class NotificacaoService {

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9_+%-]+(?:\\.[A-Za-z0-9_+%-]+)*@"
                    + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z]{2,}$");

    /** Cria o serviço de notificações. */
    public NotificacaoService() {
    }

    /**
     * Valida o formato por regex e simula o envio para o destinatário.
     * O exercício não define servidor SMTP; a confirmação é retornada ao chamador.
     *
     * @param email destinatário no formato local@dominio.tld
     * @return confirmação do envio simulado
     * @throws IllegalArgumentException se o e-mail for nulo ou tiver formato inválido
     */
    public String enviarEmail(String email) {
        return "Email enviado para: " + email + " (simulação)";
    }
}
