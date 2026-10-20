# Tarefa - Conventional Commits

Formato: `tipo(escopo opcional): descrição`.

- `feat`: nova funcionalidade, por exemplo `feat(notificacoes): valida email com regex`.
- `fix`: correção, por exemplo `fix(header): trata valor nulo`.
- `test`: inclusão ou ajuste de testes.
- `docs`: alteração de documentação.
- `ci`: alteração nos workflows de integração contínua.
- `refactor`: mudança interna sem alterar o comportamento esperado.
- `chore`: manutenção e preparação do projeto.

A mensagem **Implementa validação de senha** é mantida literalmente no commit da atividade 1 porque foi solicitada no material. Os demais commits usam os tipos acima, e commits de merge identificam a integração das branches.

Uma mudança incompatível pode usar `!` depois do tipo/escopo e explicar o efeito em `BREAKING CHANGE:` no corpo. Exemplo: `feat(api)!: altera contrato de notificacoes`.

Referência: [especificação Conventional Commits 1.0.0](https://www.conventionalcommits.org/pt-br/v1.0.0/).
