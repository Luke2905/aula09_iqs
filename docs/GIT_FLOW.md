# Atividade 1 - Git Flow executado localmente

O repositório desta pasta possui histórico real de commits e branches. Os merges feitos antes da publicação são simulações locais, sem registrar aprovação humana ou PR remoto fictício.

## Sequência executada

1. `main`: base Maven Java 17.
2. `develop`: workflows de PR e Javadoc.
3. `feature/login`: implementação e testes da senha; commit literal `Implementa validação de senha`.
4. Merge local de `feature/login` em `develop` com `--no-ff`.
5. `hotfix/header-null`: criada a partir de `main`, corrige header nulo e adiciona teste.
6. Hotfix integrado em `main` e `develop`.
7. `feature/revisao-calculadora`: teste reproduz a mensagem inadequada; correção do método conforme o material; merge local em `develop`.
8. `feature/notificacoes`: primeira implementação com erro, testes falhando e correção com regex e tratamento de nulo.
9. Merge local das notificações, preparação de `release/v1.0` e integração local da release.
10. `teste/pr-com-erro`: criada a partir da versão pronta; remove a validação para demonstrar a falha no CI, sem afetar a versão final.
11. `exemplo/develop-integrado`: preserva o resultado completo da simulação local.
12. Para a revisão real no GitHub, `develop` foi posicionada no commit anterior às notificações. Assim, `feature/notificacoes -> develop` tem diferenças reais e pode aguardar os revisores. `main` e `release/v1.0` contêm a versão final executável.

O repositório GitHub estava vazio no início. Por isso não havia `origin/develop` para executar `git pull origin develop`; o comando do enunciado foi preservado no roteiro abaixo para o trabalho futuro com remoto existente.

## Comandos do material

```shell
git checkout develop
git pull origin develop
git checkout -b feature/login
# Alterar arquivos
git add .
git commit -m "Implementa validação de senha"
git push origin feature/login
# Criar PR no GitHub para merge em develop
```

Exercício do hotfix:

```shell
git checkout main
git checkout -b hotfix/header-null
# Corrigir header nulo e adicionar teste
git add .
git commit -m "fix(header): trata header nulo"
```

## Inspeção

```shell
git log --all --graph --oneline --decorate
git show 32d662d
git show 45b43f1
git show cc21002
git show 795d787
git diff develop...feature/notificacoes
git diff main...teste/pr-com-erro
```

Execute a aplicação em `main`. A branch `teste/pr-com-erro` é intencionalmente defeituosa.

## Histórico antes do registro final das evidências

```text
* dfea733 (teste/pr-com-erro) test(ci): remove validacao para demonstrar PR com erro
*   12856df (HEAD -> main) merge: publica release/v1.0 localmente
|\  
* \   48f224c merge: aplica hotfix/header-null em main
|\ \  
| | | *   ad9b164 (exemplo/develop-integrado) merge: sincroniza release/v1.0 em develop
| | | |\  
| | | |/  
| | |/|   
| | * | ab96540 (release/v1.0) docs: registra atividades e revisoes simuladas
| | |/  
| | *   4320eb4 merge: integra notificacoes corrigidas em develop (simulacao local)
| | |\  
| | | * 795d787 (feature/notificacoes) fix(notificacoes): valida email com regex e trata nulo
| | | * 107c8da feat(notificacoes): simula envio com erro para revisao
| | |/  
| | *   36ee907 (develop) merge: integra revisao da calculadora em develop (simulacao local)
| | |\  
| | | * cc21002 (feature/revisao-calculadora) fix(calculadora): valida divisor conforme code review
| | | * b5e12f4 test(calculadora): reproduz problema da revisao
| | |/  
| | *   4e98775 merge: sincroniza hotfix/header-null em develop
| | |\  
| | |/  
| |/|   
| * | 45b43f1 (hotfix/header-null) fix(header): trata header nulo
|/ /  
| *   2392344 merge: integra feature/login em develop (simulacao local)
| |\  
| | * 32d662d (feature/login) Implementa validação de senha
| |/  
| * 1311074 ci: adiciona validacao de PR e Javadoc automatico
|/  
* 64d38f7 chore: prepara projeto Maven Java 17
```

## Ajustes de CI após a publicação

A opção `workflow_dispatch` foi adicionada ao workflow original, mantendo `pull_request`, as actions `@v3`, JDK 17 e `mvn clean test`. A configuração foi propagada a `develop` e às branches dos PRs. A feature de notificações recebeu um merge de `develop` para cumprir a verificação de branch atualizada; o novo commit passou no build remoto.
