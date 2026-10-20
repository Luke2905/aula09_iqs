package br.edu.fatec.iqs09;

/** Exemplo de divisão inteira utilizado na revisão de código da aula. */
public class Calculadora {

    /** Cria uma calculadora. */
    public Calculadora() {
    }

    /**
     * Divide dois inteiros, com a validação fail fast apresentada no material.
     *
     * @param a dividendo
     * @param b divisor
     * @return quociente inteiro, com truncamento em direção a zero
     * @throws ArithmeticException se o divisor for zero
     */
    public int divide(int a, int b) {
        return a / b;
    }
}
