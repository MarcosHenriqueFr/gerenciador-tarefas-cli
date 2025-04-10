<h1>Gerenciador de Tarefas Simples</h1>

<h2>Tecnologias Utilizadas</h2> 
<ul type="disc">
    <li>Java</li>
</ul>

<h3>Pré-requisitos</h3>
<ul>
    <li>Java SDK 21</li>
    <li>Git
</ul>

<h3>Como iniciar o Projeto</h3>

Abra a pasta onde vai baixar o projeto.

Clone o repositório:
```bash
git clone https://github.com/MarcosHenriqueFr/gerenciador-tarefas-cli
```

Entre na pasta de gerenciador
```bash
cd gerenciador-tarefas-cli
```

Compile o programa:
```bash
javac -d bin src/main/tt/*.java src/main/tt/modelo/*.java src/main/tt/visao/*.java
```

Execute o programa: 
```bash 
java -cp bin main.tt.Application
```

<h4>O que foi aprendido?</h4>

1. Uso de Orientação a objetos

- 1.1 Criação da Tarefa

    - A tarefa possui as informações de ID, Nome, Status, Data de Criação e de Update.
    - A tarefa possui um atributo estático que atualiza a cada tarefa nova adicionada.

- 1.2 Criação do Gerenciador de Tarefas

    - É quem faz a comunicação entre o arquivo e as informações dadas pelo usuário.
    - O arquivo é atualizado toda vez que o usuário fecha o programa.

2. Uso Simples do MVC
    - Foi aplicado uma estrutura modificada do MVC, sem usar o Controller, como o projeto é simples os dados do model já modificam a view diretamente.


<h2>O que será produzido a seguir</h2>

Planejo melhorar esse projeto simples usando diferentes tecnologias:

- Usar uma build tool para facilitar os clones do projeto;
- Usar JavaFX para interface gráfica;
- Usar JSON como estrutura de arquivo;
- Usar Estrutura de dados para organização das tarefas
<hr><br>


Ideia <strong>inicial</strong> de projeto derivada do site: [https://roadmap.sh/projects/task-tracker]