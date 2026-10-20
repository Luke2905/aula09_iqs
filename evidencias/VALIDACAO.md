# Validação real - 19/10/2026

- `mvn clean verify javadoc:javadoc`: BUILD SUCCESS, com Maven 3.9.11 e JDK 21.0.10; compilação com `release 17`.
- 42 testes executados, 0 falhas, 0 erros e 0 ignorados.
- Testes repetidos com o JDK 24.0.1 registrado no IntelliJ: BUILD SUCCESS, 42 testes aprovados.
- JAR `target/aula_iqs09-1.0.0.jar` executado com sucesso nos JDKs 21 e 24.
- Javadoc gerado em `target/reports/apidocs/index.html`, com doclint e falha obrigatória em warnings.

## Testes por classe

| Classe | Casos aprovados |
| --- | --- |
| CalculadoraTest | 7 |
| HeaderUtilTest | 3 |
| LoginServiceTest | 8 |
| NotificacaoServiceTest | 24 |
| Total | 42 |

## Cobertura de NotificacaoService

| Métrica | Coberto | Perdido | Percentual |
| --- | --- | --- | --- |
| Instruções | 22 | 0 | 100% |
| Branches | 4 | 0 | 100% |
| Linhas | 6 | 0 | 100% |
| Métodos | 3 | 0 | 100% |
| Classes | 1 | 0 | 100% |

As contagens foram conferidas no XML real do JaCoCo. A regra de build exige 100% de linhas e branches desta classe durante a fase `test`.

## Falhas intencionais confirmadas

1. Calculadora anterior à revisão: 1 falha, porque a mensagem `/ by zero` não corresponde à mensagem pedida no material.
2. Notificação sem validação: 19 falhas nos destinatários inválidos.
3. Execução só dos cenários válidos: o JaCoCo rejeitou a cobertura incompleta de NotificacaoService.

Os logs estão nesta pasta. Essas falhas didáticas foram executadas antes da restauração do código correto. A branch `main` contém a versão aprovada pelos testes locais; `teste/pr-com-erro` preserva o erro para a demonstração do CI.

A execução real do GitHub Actions e o estado das proteções/PRs são registrados em `docs/GITHUB.md` e `github-validacao.json` após a publicação. Aprovações humanas não são simuladas como aprovações reais.
