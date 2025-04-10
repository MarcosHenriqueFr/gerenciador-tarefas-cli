<h1>Gerenciador de Tarefas Simples</h1>

<h2>Tecnologias Utilizadas</h2> 
<ul type="disc">
    <li>Java</li>
</ul>

<h3>Pré-requisitos</h3>
<ul>
    <li>Java SDK 21</li>
    <li>Git Atualizado</li>
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

1.1 Criação da Tarefa

<ol>
    <li> A tarefa possui as informações de ID, Nome, Status, Data de Criação e de Update.
    <li> A tarefa possui um atributo estático que atualiza a cada tarefa nova adicionada.
</ol>

1.2 Criação do Gerenciador de Tarefas

<ol>
    <li>É quem faz a comunicação entre o arquivo e as informações dadas pelo usuário.
    <li>O arquivo é atualizado toda vez que o usuário fecha o programa.
</ol>

2. Uso Simples do MVC

2.1 

- Foi aplicado uma estrutura básica do MVC, como o projeto é simples os dados do model já modificam a view diretamente



Ideia inicial de projeto derivada do site: [https://roadmap.sh/projects/task-tracker]