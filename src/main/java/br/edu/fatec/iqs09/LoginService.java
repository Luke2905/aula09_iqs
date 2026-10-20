package br.edu.fatec.iqs09;

/** Validação de senha da feature de login simulada na atividade 1. */
public class LoginService {

    /** Cria o serviço de validação. */
    public LoginService() {
    }

    /**
     * Verifica a regra didática adotada para esta simulação: mínimo de 8 caracteres.
     *
     * @param senha senha a validar
     * @return verdadeiro se a senha não for nula, vazia ou composta só de espaços,
     *         e tiver pelo menos 8 caracteres
     */
    public boolean validarSenha(String senha) {
        return senha != null && !senha.isBlank() && senha.length() >= 8;
    }
}
