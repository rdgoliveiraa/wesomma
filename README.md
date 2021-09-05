# Wessoma

##

Projeto de gestão financeira familiar

<!-- prettier-ignore-start -->
[![Build Status][build-badge]][build]
[![Code Coverage][coverage-badge]][coverage]



<!--ts-->
   * [Sobre](#Sobre)
   * [Tabela de Conteudo](#tabela-de-conteudo)
   * [Instalação](#instalacao)
   * [Como usar](#como-usar)
      * [Pre Requisitos](#pre-requisitos)
      * [Local files](#local-files)
      * [Remote files](#remote-files)
      * [Multiple files](#multiple-files)
      * [Combo](#combo)
   * [Tests](#testes)
   * [Tecnologias](#tecnologias)
   * [Status](#status)
   * [Features](#features)
<!--te-->

## Sobre
Wessoma é uma plataforma de gestão financeira familiar que facilita a criação e controle das finanças em um conceito de colaboração em grupo.

## Tabela de Conteudo

## Instalação

## Como usar

* Pre Requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
Git, Java 11, Maven e MySql.
Além disto é bom ter um editor para trabalhar com o código como Intellij

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone <https://github.com/rdgoliveiraa/wesomma.git>

# Acesse a pasta do projeto no terminal/cmd
$ cd wesomma

# Instale as dependências
$ mvn install
```

## Tests
Para executar os teste é necessário executar o seguinte comando na raiz do projeto:
```
mvn test
```
Para validações de código é utilizado o sonar. Você pode utilizar o docker para criar uma instancia local e realizar o mapeamento do projeto no Sonar. Após feita configuração basta executar o seguinte comando para avaliar o código implementado:
```
mvn sonar:sonar \   -Dsonar.projectKey=Wesomma \   -Dsonar.host.url=http://localhost:9000 \   -Dsonar.login=${token}
```
    
## Tecnologias
* Java
* SpringBoot
* Maven
* MySql

## Status
<h4 align="center"> 
	🚧  Wesomma 🚀 Em construção...  🚧
</h4>

#Features
- [x] Cadastro de usuário
- [ ] Cadastro de familias
- [ ] Cadastro de contas
- [ ] Cadastro de orçamentos
- [ ] Cadastro de orçamentos
- [ ] Cadastro de metas
- [ ] Cadastro de transações
