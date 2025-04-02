package main.tt.modelo;

public final class Commands {

    private Commands() {}

    public static void addTask(TaskManager manager, String[] args){
        /*
            Uso de StringBuilder para pegar todos os outros argumentos depois de 'add'
            Remoção do último espaço
         */
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
        manager.getTasks().forEach(System.out::println);
    }
    
    public static void listCommand(TaskManager manager, String[] args){
        
    }

    public static void markProgress(TaskManager manager, String[] args) {

    }

    public static void markDone(TaskManager manager, String[] args) {

    }

    public static void updateTask(TaskManager manager, String[] args) {

    }

    public static void deleteTask(TaskManager manager, String[] args) {

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
                \t\t\tlist done -> mostra todos as tarefas marcados como concluidos.
                \t\t\tlist todo -> mostra todos as tarefas marcados como a fazer.
                \t\t\tlist in-progress -> mostra todas as tarefas marcadas como em progresso.
                """);
    }
}
