package main.tt.modelo;

import java.util.NoSuchElementException;

public final class Commands {

    private Commands() {}

    public static void addTask(TaskManager manager, String[] args){
        /*
            Uso de StringBuilder para pegar todos os outros argumentos depois de 'add'
            Remoção do último espaço
         */
        try {
            verificarSegundoArg(args);

            StringBuilder taskName = new StringBuilder();
            Task.aumentarQuant();
            Long ID = Task.getQuantTasks();

            for(int i = 1; i < args.length; i++){
                taskName.append(args[i]).append(" ");
            }
            taskName.deleteCharAt(taskName.length() - 1);

        /*
            Adição do nome na tarefa, o ID vem de um atributo static de TASK.
            Atributo atualizado cada vez que adiciona uma tarefa
         */

            Task task = new Task(ID, taskName.toString());
            manager.getTasks().add(task);

            System.out.println("Tarefa adicionada!!!");
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /*
        Verifica qual é o tipo de comando de lista especificado
     */
    public static void listCommand(TaskManager manager, String[] args){
        try{
            verificarSegundoArg(args);

            switch(args[1]){
                case "done":
                    listDone(manager);
                    break;
                case "todo":
                    listTodo(manager);
                    break;
                case "in-progress":
                    listInProgress(manager);
                case "all":
                    listAll(manager);
                    break;
                default:
                    System.out.println("Comando 'list' não identificado. Digite 'help'");
            }
        } catch (NullPointerException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listAll(TaskManager manager) {
        manager.getTasks().forEach(System.out::println);
    }

    private static void listInProgress(TaskManager manager) {
        manager.getTasks().stream()
                .filter(task -> task.getStatus() == Status.IN_PROGRESS)
                .forEach(System.out::println);
    }

    private static void listTodo(TaskManager manager) {
        manager.getTasks().stream()
                .filter(task -> task.getStatus() == Status.TODO)
                .forEach(System.out::println);
    }

    private static void listDone(TaskManager manager) {
        manager.getTasks().stream()
                .filter(task -> task.getStatus() == Status.DONE)
                .forEach(System.out::println);
    }

    /*
        Padrão para verificar os argumentos
        verificarSegundoArg -> verifica o próximo elemento após o comando. ex: 'add a'
        Integer.parseInt() -> pode lançar uma NumberFormatException
        verifyTaskExistence(taskmanager, args) -> verifica se aquele elemento existe na lista do taskmanager

     */

    public static void markProgress(TaskManager manager, String[] args) {
        try {
            verificarSegundoArg(args);

            int inputId = Integer.parseInt(args[1]);

            boolean exists = verifyTaskExistence(manager, inputId);

            if(exists){
                manager.getTasks().stream()
                        .filter(task -> task.getID() == inputId)
                        .forEach(task -> task.setStatus(Status.IN_PROGRESS));
            } else {
                System.out.println("Elemento não existe.");
            }
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Não foi passado um número.");
        }
    }

    public static void markDone(TaskManager manager, String[] args) {
        try {
            verificarSegundoArg(args);

            int inputId = Integer.parseInt(args[1]);

            boolean exists = verifyTaskExistence(manager, inputId);

            if(exists){
                manager.getTasks().stream()
                        .filter(task -> task.getID() == inputId)
                        .forEach(task -> task.setStatus(Status.DONE));
            } else {
                System.out.println("Elemento não existe.");
            }
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Não foi passado um número.");
        }
    }

    /*
        Possui uma verificação a mais
        Após verificar 'update id', ainda verifica se possui mais um 3° argumento
     */
    public static void updateTaskName(TaskManager manager, String[] args) {
        try {
            verificarSegundoArg(args);
            int inputId = Integer.parseInt(args[1]);
            boolean exists = verifyTaskExistence(manager, inputId);

            if(exists){
                StringBuilder newName = new StringBuilder();

                if(args.length == 2){
                    throw new NullPointerException("Não foi repassado nenhum novo nome.");
                }

                for(int i = 2; i < args.length; i++){
                    newName.append(args[i]).append(" ");
                }

                newName.deleteCharAt(newName.length() - 1);

                manager.getTasks().stream()
                        .filter(task -> task.getID() == inputId)
                        .forEach(task -> task.setName(newName.toString()));

                System.out.println("Nome atualizado!!!");
            } else {
                System.out.println("Elemento não existe.");
            }
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Não foi passado um número.");
        }
    }

    public static void deleteTask(TaskManager manager, String[] args) {
        try {
            verificarSegundoArg(args);
            int inputId = Integer.parseInt(args[1]);
            boolean exists = verifyTaskExistence(manager, inputId);

            if(exists){
                Task task = manager.getTasks().stream()
                                .filter(t -> t.getID() == inputId)
                                .findFirst()
                                .get();

                manager.getTasks().remove(task);
            } else {
                System.out.println("Elemento não existe.");
            }
        } catch (NullPointerException | NoSuchElementException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Não foi passado um número.");
        }
    }

    private static boolean verifyTaskExistence(TaskManager manager, int inputId){
        return manager.getTasks().stream()
                .anyMatch(task -> task.getID() == inputId);
    }

    private static void verificarSegundoArg(String[] args){
        if(args.length == 1){
            throw new NullPointerException("Não foi repassado nenhum comando. Digite 'help'.");
        }
    }

    public static void help() {
        System.out.println("Os comandos do Task Tracker são:");
        // TextBlock - Java 13
        System.out.print("""
                \t\thelp -> Mostra os comandos do sistema.
                \t\tadd -> adiciona uma nova tarefa, com a info do id.
                \t\tupdate -> atualiza uma informação da tarefa, com a info do id.
                \t\tdelete -> elimina uma tarefa, com a info do id.
                \t\tmark-in-progress -> modifica o status da tarefa para em progresso.
                \t\tmark-done -> modifica o status da tarefa para concluido.
                \t\tlist -> comandos relaciondados as consultas das listas.
                \t\t\tlist all -> mostra todos as tarefas, independentemente dos status
                \t\t\tlist done -> mostra todos as tarefas marcados como concluidos.
                \t\t\tlist todo -> mostra todos as tarefas marcados como a fazer.
                \t\t\tlist in-progress -> mostra todas as tarefas marcadas como em progresso.
                """);
    }

    // Limpa o console dependendo do terminal utilizado
    public static void limpar() {
    }
}
