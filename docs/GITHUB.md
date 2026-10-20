# GitHub - estado real da atividade

Repositório: [Luke2905/aula09_iqs](https://github.com/Luke2905/aula09_iqs).

## Entrega publicada

A branch `main` contém o projeto Maven completo e executável no IntelliJ. `release/v1.0` e a tag `v1.0.0` registram a entrega. As branches do exercício e a simulação local também foram publicadas.

`develop` está posicionada antes da integração das notificações. O histórico completo dos merges locais está preservado em `exemplo/develop-integrado`. A revisão remota das notificações é um PR real e não foi aprovada artificialmente.

## PR correto

[PR #1 - validação de notificações](https://github.com/Luke2905/aula09_iqs/pull/1): `feature/notificacoes -> develop`.

- [Job build aprovado no commit atual](https://github.com/Luke2905/aula09_iqs/actions/runs/39347674712/job/118384115201).
- JDK 17 e comando `mvn clean test`, conforme o material.
- 42 testes aprovados; a versão corrigida alcançou 100% de cobertura de linhas e branches de `NotificacaoService`.
- A feature foi atualizada com `develop` antes da validação final.
- Permanece aberto aguardando duas aprovações humanas. Nenhuma revisão humana foi inventada e o PR não foi integrado.

## PR com erro intencional

[PR #2 - teste de falha de CI](https://github.com/Luke2905/aula09_iqs/pull/2): a validação do e-mail foi removida intencionalmente.

O [job build falhou](https://github.com/Luke2905/aula09_iqs/actions/runs/39347449754/job/118383375722) pelos 19 testes de destinatários inválidos, como esperado. O log real confirma 42 testes executados, 19 falhas e 0 erros. Depois da comprovação, o PR foi fechado sem merge. A branch `teste/pr-com-erro` permanece como exemplo.

## Javadoc automático

O [workflow Javadoc foi executado com sucesso](https://github.com/Luke2905/aula09_iqs/actions/runs/39347139370), gerando o artefato `javadoc` no GitHub Actions. Ele também está configurado para push em `main`/`develop` e eventos de PR.

As execuções remotas registradas nesta entrega foram iniciadas por `workflow_dispatch`. Os eventos automáticos do repositório recém-criado não iniciaram as primeiras execuções durante a preparação. O gatilho `pull_request` permanece no workflow, e a opção manual permite repetir o mesmo comando de validação sem alterar o código.

## Proteção das branches

As regras de `main` e `develop` exigem:

1. Integração por pull request e duas aprovações.
2. Descarte de aprovações antigas após novos commits.
3. Check obrigatório `build` aprovado.
4. Branch atualizada antes da integração.
5. Resolução de todas as conversas de revisão.
6. Aplicação das regras também aos administradores.

A configuração reproduzível está em `docs/branch-protection.json`. O estado foi conferido pela API após a aplicação das regras.

## Evidências

- `evidencias/github-validacao.json`: URLs, conclusões, commits dos checks e configuração das regras.
- `evidencias/github-notificacoes-correto.log`: log da primeira validação remota da implementação corrigida.
- `evidencias/github-notificacoes-com-erro.log`: log do erro intencional.
- `evidencias/VALIDACAO.md`: testes, cobertura, JAR e Javadoc locais.

## Pendência humana

Para concluir a integração real do PR #1 em `develop`, dois revisores humanos precisam aprová-lo e os comentários de revisão, se houver, precisam estar resolvidos. O código completo pode ser usado imediatamente a partir de `main`.

[Documentação oficial de proteção de branches](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/about-protected-branches).
