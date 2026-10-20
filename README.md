# Aula 09 - Versionamento e Git Avançado

Projeto Maven da disciplina Qualidade de Software, preparado para o IntelliJ IDEA e para Java 17.

## Executar no IntelliJ

1. Selecione **File > Open**, escolha esta pasta ou seu `pom.xml` e abra como projeto Maven.
2. Aguarde a importação das dependências. Se necessário, use **Reload All Maven Projects**.
3. Em **File > Project Structure > Project**, selecione um JDK 17 ou superior. O Maven compila com `release 17`.
4. Execute a configuração **Aula IQS 09** ou o método `main` de `br.edu.fatec.iqs09.Main` pelo botão verde.
5. Para testar, clique com o botão direito em `src/test/java` e escolha **Run All Tests**, ou execute `test` no painel Maven.

A aplicação demonstra validação de senha, tratamento de header nulo, divisão inteira e notificações. O envio de e-mail é simulado: o enunciado não fornece servidor SMTP, credenciais ou integração de envio.

## Executar pelo terminal

```shell
mvn clean test
mvn package
java -jar target/aula_iqs09-1.0.0.jar
mvn javadoc:javadoc
```

A primeira execução precisa baixar as dependências Maven.

- Cobertura: `target/site/jacoco/index.html`.
- Javadoc: `target/reports/apidocs/index.html`.
- A regra do JaCoCo é executada em `test`, junto com o comando exato do material: `mvn clean test`.
- A compilação falha se `NotificacaoService` não alcançar 100% de linhas e de branches.

## Correspondência com a atividade

| Parte do material | Entrega |
| --- | --- |
| Feature de login e validação de senha | `LoginService`, testes e branch `feature/login` |
| Hotfix a partir de `main` | `HeaderUtil`, teste para nulo e branch `hotfix/header-null` |
| Validação automática de PR | `.github/workflows/pr-validation.yml`, com JDK 17 e `mvn clean test` |
| Code review da calculadora | `Calculadora` com o método e a mensagem de erro do material; `docs/CODE_REVIEW.md` |
| Desafio de notificações | `NotificacaoService.enviarEmail(String email)`, regex e cenários válidos/inválidos |
| PR intencionalmente incorreto | Branch `teste/pr-com-erro`, isolada da versão final; evidências em `evidencias/` |
| 100% de cobertura da nova classe | Testes JUnit e verificação obrigatória pelo JaCoCo |
| Javadoc automático | `.github/workflows/javadoc.yml` |
| Conventional Commits | `docs/CONVENTIONAL_COMMITS.md` |
| Proteção, dois revisores e PR remoto | Estado real e roteiro em `docs/GITHUB.md`; aprovações dependem de revisores humanos |

## Fidelidade aos arquivos fornecidos

O arquivo chamado `Aula_09_IQS.java` reúne comandos Git, YAML e trechos Java; ele não é uma unidade Java compilável. Os trechos foram separados nos arquivos próprios.

O método `Calculadora.divide(int a, int b)` mantém a divisão inteira, o `if (b == 0)` e a mensagem **Divisor não pode ser zero**. O comentário `# Fail fast` foi convertido em `// Fail fast`, sintaxe válida em Java.

O workflow mantém `actions/checkout@v3`, `actions/setup-java@v3`, Java 17 e `mvn clean test`. Foi acrescentada a opção `workflow_dispatch` para permitir executar o mesmo check manualmente, mantendo o gatilho `pull_request`. Foi acrescentado `distribution: 'temurin'`, campo obrigatório do `setup-java@v3` que não aparece no exemplo. A confirmação está na [documentação oficial da action](https://github.com/actions/setup-java/tree/v3).

O enunciado não estabelece regras para a senha nem o comportamento do header: para a simulação, foi adotado mínimo de 8 caracteres, rejeitando nulo/vazio/somente espaços, e retorno vazio para header nulo. O nome `enviarEmail` foi preservado e o destinatário foi recebido por parâmetro para permitir os testes de formato.

A regex aceita endereços simples com domínio e extensão de pelo menos duas letras, subdomínios e tags com `+`. Ela verifica formato didático; não consulta a existência da caixa postal.

## Git e colaboração

Consulte `docs/GIT_FLOW.md` para o histórico executado e `docs/GITHUB.md` para as etapas remotas. As revisões locais são simulações identificadas como tal. Uma simulação não equivale às duas aprovações humanas pedidas no PDF.

O autor técnico dos commits locais é **Atividade IQS 09 <iqs09@local.invalid>**, sem atribuir revisões ou aprovações a colegas.
