package main.tt.modelo;

public final class Commands {

    private Commands() {}

    public static void addTask(String[] args){

    }
    
    public static void listCommand(String[] args){
        
    }

    public static void markProgress(String[] args) {

    }

    public static void markDone(String[] args) {

    }

    public static void updateTask(String[] args) {

    }

    public static void deleteTask(String[] args) {

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
