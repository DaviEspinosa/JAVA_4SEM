# Sistema "Itaú"

### **Projeto:**

Sistema de Gerenciamento Bancário

<hr>

### **Descrição do Projeto:**

O Sistema de Gerenciamento Bancário Itaú será uma aplicação para simular as funcionalidades de um sistema bancário. O projeto abrangerá desde o cadastro de usuários até operações bancárias como consultas de saldo, transferências e histórico de transações.
    <hr>
    <br>
- **Escopo:**
    
     **Sistema será capaz de:**
        
    - **Cadastrar:**
        Usuários irão visualizar um formulário para cadastrar suas informações, como: cpf, nome, senha, endereço, telefone, e-mail, data de nascimento.
        <hr>
    - **Logar:**
        Poderão também fazer a autenticação para entrar no sistema. Deverá ser digitado as informações de cpf e senha para a entrada.
        <hr>
    - **Gerenciamento da Conta:**
        
        Tipos de contas: Conta Corrente, Conta Poupança.
        Saldo inicial configurável.
        Consulta de Saldo: Permitir que os     usuários verifiquem o saldo de suas contas.
        <hr>
    - **Operações Bancárias:**
        
        Depósito: Permitir que o usuário faça depósitos em sua conta.

        Saque: Permitir que o usuário realize saques (com validação de saldo suficiente).
        
        Transferências entre Contas: Implementar transferências entre contas do mesmo banco.
    
    <br>
    
    <hr>


    <br>
- **Recursos/Requisitos:**
    - **Ferramentas de Desenvolvimento:**
        - IDE: Visual Studio Code com extensões para Java Swing tendo suporte para o maven.

    - **Tecnologias:**
        - Frontend: Java Swing para o desenvolvimento da interface gráfica.
        - Backend: Java com integração ao banco de dados e lógica de negócio.
        - Banco de Dados: PostgreSQL para armazenamento de dados relacionais.

<hr>

### **Diagramas**

**Diagrama de Classe:**
```mermaid
%%{ init : { 'theme': 'dark', 'themeVariables': { 
    'classBackground': '#4A148C', 
    'classTextFill': '#333', 
    'classBorder': '#000', 
    'classTextColor': '#000',
    'edgeLineColor': '#333',
    'edgeTextColor': '#000' } 
}}%%
classDiagram
    class Usuario {
        +int id
        +String cpf
        +String nome
        +String email
        +String senhaHash
        +String endereco
        +Date dataNascimento
        +List<ContaBancaria> contas
        +void cadastrar()
        +void atualizarDados()
        +void excluirConta()
    }
    class ContaBancaria {
        +int id
        +String numeroConta
        +Decimal saldo
        +String tipoConta
        +Usuario usuario
        +void depositar()
        +void sacar()
        +void transferir()
        +List<Transacao> transacoes
        +List<Transacao> listarTransacoes()
    }
    class Transacao {
        +int id
        +String tipoTransacao
        +Decimal valor
        +Date dataTransacao
        +ContaBancaria contaOrigem
        +ContaBancaria contaDestino
    }
    Usuario "1" o-- "0..*" ContaBancaria : possui
    ContaBancaria "1" o-- "0..*" Transacao : registra


**Diagrama de Classe:**

<img src="diagramas/diagramaUso.png" alt="Diagrama" width="500"/>

**Diagrama de Fluxo:**

<img src="diagramas/diagramaFluxo1.png" alt="Diagrama" width="500"/>
<img src="diagramas/diagramaFluxo2.png" alt="Diagrama" width="500"/>
