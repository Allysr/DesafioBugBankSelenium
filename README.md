# Desafio Bug Bank

> Este repositório contém testes automatizados desenvolvidos
> para simular o processo de trânsferencia entre coisas, para isso foi realizado o cadastro de duas contas no site de teste BugBank, seguido pelo acesso a uma das contas
> e pela realização de transferência de saldo para a outra.


### 🔖 Objetivo
O objetivo desses testes é verificar a funcionalidade do sistema de cadastro de contas e de transferência de saldo do Banco BugBank de forma automatizada e gerar um relatório dos testes realizados.

### Caso de teste
1. Acessar o site do BugBank;
2. Criar duas contas com Saldo e salvar os seus dados.
3. Acessar uma conta e realizar uma transfêrencia de valor para a outra.
4. Validar a saída e entrada das contas envolvidas.

### Tecnologias
Projeto criado com:
* JUnit 5 versao: 5.10
* Selenium versao: 4.18
* Webdriver Mananger versao: 5.7
* Extent Reports versao: 5.1

###  Executando o projeto
```
git clone git@github.com:Allysr/DesafioBugBankSelenium.git
cd desafioBugBankSelenium
instalar as dependencias Maven
executar a suite de teste "transferBetweenTroAccounts"
```

### Testes bugbank
![Transferencia](https://i.imgur.com/OyjKKXe.png)


### Relatório gerado
![Relátorio](https://i.imgur.com/meGxKwl.png)

#### Site utilizado para os testes: [Bugbank](https://bugbank.netlify.app/#)
