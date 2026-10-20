# Etapas remotas da aula

Repositório indicado: https://github.com/Luke2905/aula09_iqs.git

A conta Luke2905 foi autenticada pelo gerenciador de credenciais do Windows e possui permissão administrativa neste repositório. A publicação e os checks remotos serão registrados abaixo. Duas aprovações exigem revisores humanos distintos do autor.

## Publicar

O remote `origin` está configurado para o repositório acima. Com a conta autenticada, os comandos de publicação são:

```shell
git push -u origin main
git push -u origin develop
git push -u origin feature/login
git push -u origin hotfix/header-null
git push -u origin feature/revisao-calculadora
git push -u origin feature/notificacoes
git push -u origin teste/pr-com-erro
git push -u origin release/v1.0
git push origin v1.0.0
```

Os merges locais são simulações e não criam PRs no site. Para permitir a revisão real das notificações, `develop` foi posicionada antes dessa feature; `exemplo/develop-integrado` preserva a simulação completa. A branch `main` contém a entrega executável completa.

## Proteção de branches

Em **Settings > Branches > Add branch protection rule**, configure `main` e `develop`:

1. **Require a pull request before merging**.
2. **Require approvals**, com **2** aprovações.
3. **Dismiss stale pull request approvals when new commits are pushed**.
4. **Require status checks to pass before merging**, selecionando o job **build** do workflow **PR Validation**.
5. **Require branches to be up to date before merging**.
6. **Require conversation resolution before merging**.
7. Aplique as regras também aos administradores, quando disponível.

O check `build` aparece na interface após a primeira execução do workflow. O arquivo `branch-protection.json` guarda o corpo equivalente para a API, sem afirmar que a configuração já foi aplicada. [Documentação oficial de proteção de branches](https://docs.github.com/en/repositories/configuring-branches-and-merges-in-your-repository/managing-protected-branches/about-protected-branches).

## Teste da falha intencional

Abra um PR com `teste/pr-com-erro` como origem e `develop` como destino. A alteração remove a validação do destinatário; os testes de e-mails inválidos devem falhar. Não integre essa branch. Feche o PR após registrar a falha do check `build`.

O teste local correspondente está em `evidencias/notificacoes-com-erro.log`. O resultado local não é apresentado como uma execução de GitHub Actions.

## Revisão válida

A versão correta está em `main`, `release/v1.0` e `feature/notificacoes`. O PR real `feature/notificacoes -> develop` deve aguardar duas aprovações humanas, build aprovado e resolução dos comentários. `develop` permanece no estado anterior à feature até a integração desse PR.

## Javadoc automático

O workflow **Javadoc** executa em push para `main`/`develop`, em PR e manualmente. Ele gera `target/reports/apidocs/` e salva o artefato `javadoc` na execução do GitHub Actions. A geração local usa `mvn javadoc:javadoc`.
