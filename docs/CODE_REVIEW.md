# Atividade 3 - Code Review Simulado

## Cenário do PR #123 do enunciado

O número #123 pertence ao exemplo da aula; este documento não afirma a existência de um PR remoto com esse número.

### Trecho recebido

```java
public class Calculadora {
    public int divide(int a, int b) {
        return a / b;
    }
}
```

### Comentário específico de revisão

**Solicitar alterações - Calculadora.divide:** a chamada `divide(10, 0)` lança a exceção padrão da JVM, sem a mensagem de domínio apresentada no material. Sugiro validar `b == 0` antes da divisão e lançar `ArithmeticException("Divisor não pode ser zero")`. Acrescente um teste que confira o tipo e a mensagem da exceção. Preserve a divisão inteira para os demais valores.

### Alternativa aplicada

```java
public int divide(int a, int b) {
    if (b == 0) {
        throw new ArithmeticException("Divisor não pode ser zero"); // Fail fast
    }
    return a / b;
}
```

A versão inicial já lança `ArithmeticException` ao dividir por zero; o ajuste torna explícita a pré-condição e controla a mensagem. Os testes também verificam divisão positiva, negativa, resultado truncado e dividendo zero.

## Desafio colaborativo - notificações

Os papéis abaixo são uma simulação didática, sem representar pessoas ou aprovações reais.

| Papel | Ação simulada | Resultado |
| --- | --- | --- |
| Dev 1 | Implementa `feature/notificacoes` sem validar o destinatário | Testes de e-mails inválidos falham |
| Dev 2 | Prepara a descrição do PR e o pedido de revisão | Modelo em `.github/pull_request_template.md` |
| Dev 3 | Solicita regex, tratamento de nulo e testes válidos/inválidos | Correção aplicada na versão final |

**Comentário 1 - resolvido no código:** antes de retornar a confirmação, valide o destinatário com `Pattern` e `matcher(email).matches()`. Verifique nulo antes de invocar o matcher. Lance `IllegalArgumentException("Email inválido")` para os formatos recusados.

**Comentário 2 - resolvido no código:** inclua testes de e-mails válidos, subdomínios, tag `+`, e-mail nulo, vazio, sem `@`, sem domínio, com espaços e com pontos consecutivos. Confira a confirmação e a mensagem de erro.

**Comentário 3 - resolvido na configuração:** faça o JaCoCo exigir 100% de cobertura de linhas e branches para `NotificacaoService` durante `mvn clean test`, impedindo que o PR passe apenas com cenários válidos.

## Checklist local

- Implementação conforme os requisitos e exemplos.
- Código legível, pré-condições explícitas e documentação Javadoc.
- Testes para cenários válidos e inválidos.
- Histórico da implementação incorreta e da correção preservado em branches.
- Resultado real da execução registrado em `evidencias/VALIDACAO.md`.

A aprovação remota permanece condicionada a build aprovado, comentários remotos resolvidos e duas revisões humanas. Este documento não concede aprovação de PR.

## Encerramento - discussão

A parte mais delicada do fluxo é coordenar branches e revisões: corrigir o erro no branch da feature, aguardar a nova validação, resolver os comentários e integrar apenas depois das aprovações. Testes que reproduzem o problema tornam a revisão objetiva e mostram se a correção realmente resolveu o caso relatado.
