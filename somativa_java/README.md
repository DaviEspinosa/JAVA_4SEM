# Sistema "Clínica Saúde"

### **Projeto:**

Sistema de Gerenciamento de Clínica Médica

<hr>

### **Descrição do Projeto:**

O Sistema de Gerenciamento de Clínica Médica "Clínica Saúde" será uma aplicação destinada a gerenciar as operações de uma clínica médica. O projeto incluirá funcionalidades como cadastro de pacientes, agendamento de consultas, gerenciamento de médicos e registros de atendimentos.
    <hr>
    <br>
- **Escopo:**
    
    **Sistema será capaz de:**

    - **Cadastrar:**
    Pacientes poderão visualizar um formulário para registrar suas informações, como: CPF, nome, endereço,      telefone, e-mail, data de nascimento e histórico médico.
    <hr>

    - **Logar:**
    Pacientes e profissionais de saúde poderão autenticar-se para acessar suas áreas específicas do sistema     usando CPF e senha.
    <hr>

    - **Gerenciamento de Pacientes:**
    Os profissionais de saúde poderão visualizar e atualizar informações dos pacientes, como histórico de       consultas e tratamentos.
    <hr>

    - **Agendamento de Consultas:**
    Permitir que os pacientes agendem consultas, visualizem horários disponíveis e recebam confirmações de      agendamentos.
    <hr>

    - **Atendimentos:**
    Registro de atendimentos médicos, incluindo anotações sobre diagnósticos, prescrições e orientações         dadas aos pacientes.
 <br>

<hr>

<br>

- **Recursos/Requisitos:**
    - **Ferramentas de Desenvolvimento:**
        - IDE: Visual Studio Code com extensões para Java Swing tendo suporte para o maven.

    - **Tecnologias:**
        - Frontend: Java Swing para o desenvolvimento da interface gráfica.
        - Backend: Java com integração ao banco de dados e lógica de negócio.
        - Banco de Dados: MongoDB para armazenamento de dados não relacionais.

<hr>

### **Diagramas**

**Diagrama de Classe:**
```mermaid
classDiagram
    class Paciente {
        +int id
        +String cpf
        +String nome
        +String email
        +String endereco
        +Date dataNascimento
        +String historicoMedico
        +List<Consulta> consultas
        +void cadastrar()
        +void atualizarDados()
        +void excluirPaciente()
    }
    class Medico {
        +int id
        +String nome
        +String especialidade
        +String crm
        +List<Consulta> consultas
        +void cadastrar()
        +void atualizarDados()
        +void excluirMedico()
    }
    class Consulta {
        +int id
        +Date dataHora
        +Paciente paciente
        +Medico medico
        +String observacoes
        +void agendar()
        +void cancelar()
    }
    Paciente "1" o-- "0..*" Consulta : possui
    Medico "1" o-- "0..*" Consulta : realiza

```
**Diagrama de Fluxo:**

```mermaid
flowchart TD
    A["Início"] --> B{"Usuário está logado?"}
    B -- Não --> C["Usuário cria cadastro"]
    C --> D["Coletar informações do paciente"]
    D --> E["Cadastrar paciente"]
    E --> F["Paciente cadastrado com sucesso"]
    F --> G["Paciente deseja agendar uma consulta?"]
    G -- Sim --> H["Coletar informações da consulta"]
    H --> I["Agendar consulta"]
    I --> J["Consulta agendada com sucesso"]
    J --> K["Fim"]
    B -- Sim --> L["Usuário acessa o sistema"]
    L --> M{"Escolha uma ação"}
    M -- Agendar --> N["Coletar detalhes da consulta"]
    N --> O["Executar agendamento"]
    O --> P["Agendamento realizado com sucesso"]
    P --> M
    M -- Cancelar --> Q["Coletar detalhes do cancelamento"]
    Q --> R["Executar cancelamento"]
    R --> S["Cancelamento realizado com sucesso"]
    S --> M
    M -- Visualizar histórico --> T["Mostrar histórico de consultas"]
    T --> M
    M -- Sair --> U["Fim"]
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


```

**Diagrama de Uso:**
