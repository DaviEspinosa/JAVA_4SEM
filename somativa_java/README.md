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
        +void depositar(Decimal valor)
        +void sacar(Decimal valor)
        +void transferir(ContaBancaria contaDestino, Decimal valor)
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
```
**Diagrama de Fluxo:**

```mermaid
flowchart TD
    A["Início"] --> B{"Usuário está logado?"}
    B -- Não --> C["Usuário cria cadastro"]
    C --> D["Coletar informações do usuário"]
    D --> E["Cadastrar usuário"]
    E --> F["Usuário cadastrado com sucesso"]
    F --> G["Usuário deseja abrir uma conta?"]
    G -- Sim --> H["Coletar informações da conta"]
    H --> I["Abrir conta bancária"]
    I --> J["Conta bancária criada com sucesso"]
    J --> K["Fim"]
    B -- Sim --> L["Usuário acessa o sistema"]
    L --> M{"Escolha uma ação"}
    M -- Depositar --> N["Coletar detalhes do depósito"]
    N --> O["Executar depósito"]
    O --> P["Depósito realizado com sucesso"]
    P --> M
    M -- Sacar --> Q["Coletar detalhes do saque"]
    Q --> R["Executar saque"]
    R --> S["Saque realizado com sucesso"]
    S --> M
    M -- Transferir --> T["Coletar detalhes da transferência"]
    T --> U["Executar transferência"]
    U --> V["Transferência realizada com sucesso"]
    V --> M
    M -- Visualizar saldo --> W["Mostrar saldo"]
    W --> M
    M -- Sair --> X["Fim"]
    G -- Não --> K

    style A stroke:#FF6D00
    style B stroke:#FF6D00
    style C stroke:#FF6D00
    style D stroke:#FF6D00
    style E stroke:#FF6D00
    style F stroke:#FF6D00
    style G stroke:#FF6D00
    style H stroke:#FF6D00
    style I stroke:#FF6D00
    style J stroke:#FF6D00
    style K stroke:#FF6D00
    style L stroke:#FF6D00
    style M stroke:#FF6D00
    style N stroke:#FF6D00
    style O stroke:#FF6D00
    style P stroke:#FF6D00
    style Q stroke:#FF6D00
    style R stroke:#FF6D00
    style S stroke:#FF6D00
    style T stroke:#FF6D00
    style U stroke:#FF6D00
    style V stroke:#FF6D00
    style W stroke:#FF6D00
    style X stroke:#FF6D00

```